package com.pingan.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pingan.Object.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class UserExcelListener extends AnalysisEventListener<User> {
    private List<User> datas = new ArrayList<>();

    @Override
    public void invoke(User data, AnalysisContext analysisContext) {
        datas.add(data);
    }

    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }


    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if(datas.size()==0){
            return;
        }
        saveData(datas);
        System.out.println(datas+"333333");
    }

    public List<User> getData() {
        return this.datas;
    }

    public void saveData(List<User> datas) {
        this.datas = datas;
    }
}
