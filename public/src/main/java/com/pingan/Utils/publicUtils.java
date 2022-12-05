package com.pingan.Utils;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class publicUtils {

    public String generationId(String type) {
        String data[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += data[(int) (Math.random() * 36)];
        }
        return type + Long.toString(new Date().getTime()) + str;
    }

    public JSONObject MapToJson(Map<String,Object> params) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.toJSONString(params);
        return jsonObject;
    }

    /**
     * 求并集
     *
     * @param m
     * @param n
     * @return
     */
    public static Integer[] getB(Integer[] m, Integer[] n)
    {
        // 将数组转换为set集合
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(m));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(n));

        // 合并两个集合
        set1.addAll(set2);

        Integer[] arr = {};
        return set1.toArray(arr);
    }

    /**
     * 求交集
     *
     * @param m
     * @param n
     * @return
     */
    public static Integer[] getJ(Integer[] m, Integer[] n)
    {
        List<Integer> rs = new ArrayList<Integer>();

        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (Integer i : m.length > n.length ? n : m)
        {
            if (set.contains(i))
            {
                rs.add(i);
            }
        }

        Integer[] arr = {};
        return rs.toArray(arr);
    }



    /**
     * 求差集
     *
     * @param m
     * @param n
     * @return
     */
    public static Integer[] getC(Integer[] m, Integer[] n)
    {
        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (Integer i : m.length > n.length ? n : m)
        {
            // 如果集合里有相同的就删掉，如果没有就将值添加到集合
            if (set.contains(i))
            {
                set.remove(i);
            } else
            {
                set.add(i);
            }
        }

        Integer[] arr = {};
        return set.toArray(arr);
    }

}
