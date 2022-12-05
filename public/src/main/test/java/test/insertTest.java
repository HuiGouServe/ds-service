//package com.pingan.test;
//
////import com.alibaba.excel.EasyExcel;
////import com.pingan.Listener.ExcelListener;
//import com.alibaba.excel.EasyExcel;
//import com.pingan.Mapper.ProductDetailMapper;
//import com.pingan.Mapper.ProductPriceMapper;
//import com.pingan.Mapper.UserDetailMapper;
//import com.pingan.Mapper.UserLoginMapper;
//import com.pingan.Object.*;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Pattern;
//
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class insertTest {
//
//    @Autowired
//    private ProductDetailMapper productDetailMapper;
//
//    @Autowired
//    private ProductPriceMapper productPriceMapper;
//
//    @Autowired
//    private UserLoginMapper userLoginMapper;
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private UserDetailMapper userDetailMapper;
//
//    private List<String> nameData = new ArrayList<>();
//
//    @Test
//    public void testExcel() throws FileNotFoundException {
//        String filename = "D:\\taobaobao.xlsx";
//        FileInputStream fileInputStream = new FileInputStream(new File(filename));
//        ExcelListener excelListener = new ExcelListener();
//        EasyExcel.read(fileInputStream, excel.class, excelListener).sheet().doRead();
//        List<excel> datas = excelListener.getDatas();
//        for (excel i : datas) {
//            nameData.add((String) i.getName1());
//        }
//        System.out.println("nameData" + nameData);
//    }
//
//    @Test
//    public void insertData() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(new File("D:\\taobaobao.xlsx"));
//        ExcelListener excelListener = new ExcelListener();
//        EasyExcel.read(fileInputStream, excel.class, excelListener).sheet().doRead();
//        for (excel i : excelListener.getDatas()) {
//            nameData.add(StringTo30((String) i.getName1()));
//        }
//        Double evaluateData[] = {1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0};
//        String labelData[] = {"非常好", "很好", "好", "一般", "差", "很差", "非常差"};
//        String colorData[] = {"紅色", "白色", "黑色", "混合色", "其他", "", "綠色"};
//        String weightData[] = {"50Kg", "100g", "", "1000g", "1kg", "2.5kg", "1.05g", "1g", "500g", "100g"};
//        String typeData[] = {"服装", "厨房", "旅游", "美食", "电子", "书籍", "酒店"};
//        String bossData[] = {"郑意婷", "彭玉芳"};
//
//        for (int i = 0; i < 20; i++) {
//            DecimalFormat df = new DecimalFormat("#.00");
//            String id = "pro" + Long.toString(new Date().getTime()) + Math.round(Math.random() * 1000 + 1000);
//            ProductDetail productDetail = new ProductDetail();
//            productDetail.setProductId(id);
//            productDetail.setUpdateTime(Long.toString(new Date().getTime()));
//            productDetail.setCreateTime(Long.toString(new Date().getTime()));
//            productDetail.setProductName(nameData.get(i));
//            productDetail.setProductColor(colorData[(int) (Math.random() * 7)]);
//            productDetail.setProductType(typeData[(int) (Math.random() * 7)]);
//            productDetail.setProductCollect((int) (Math.random() * 10000));
//            productDetail.setProductEvaluate(evaluateData[(int) (Math.random() * 8)]);
//            productDetail.setProductCommentCount((int) (Math.random() * 10000));
//            productDetail.setProductDealCount((int) (Math.random() * 1000));
//            productDetail.setProductForGold(Double.parseDouble(df.format(Math.random() * 10)));
//            productDetail.setProductImgs("---------------");
//            productDetail.setProductFreight(10.05);
//            productDetail.setProductWeight(weightData[(int) (Math.random() * 10)]);
//            productDetail.setProductLabel(labelData[(int) (Math.random() * 7)]);
//            productDetail.setProductMonthlySale((int) (Math.random() * 1000));
//            productDetail.setProductParticulars("--------");
//            productDetail.setProductIntroduce("abababababababababababababababababababababab");
//            productDetail.setProductRepertory((int) (Math.random() * 10000));
//            productDetail.setProductShop(bossData[(int) (Math.random() * 2)]);
//
//            int math = (int) (Math.random() * 5);
//            for (int j = 0; j <= math; j++) {
//                ProductPrice productPrice = new ProductPrice();
//                productDetail.setProductId(id);
//                double prc = Math.random() * 1000;
//                productPrice.setPrice(Double.parseDouble(df.format(prc)));
//                productPrice.setTbPrice(Double.parseDouble(df.format(prc * 0.8)));
//                productPrice.setContent("类型" + j);
//                productPrice.setImg("图片" + j);
//                productPrice.setProductId(id);
//                productPriceMapper.insert(productPrice);
//            }
//            productDetailMapper.insert(productDetail);
//        }
//    }
//
//    public String StringTo30(String text) {
//        String Data[] = {"人见人爱", "学生", "好用", "润百颜", "娇韵", "雅诗兰黛", "精华", "2022"};
//        if (text.length() < 30) {
//            text = Data[(int) (Math.random() * 8)] + text;
//            return StringTo30(text);
//        } else {
//            return text;
//        }
//    }
//
//    @Test
//    public void tesess() {
//        String id = "";
//        String idx = "123";
//        System.out.println("" + 123);
//    }
//
//    @Test
//    public void userTest() {
//        UserLogin userLogin = new UserLogin();
////        UserDetail userDetail = new UserDetail();
//
//        String nameData1[] = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "刘", "张",
//                "李", "陈", "许", "邓", "邱", "卢", "马", "龙", "东方", "西门", "南宫", "北丘", "司马", "欧阳",
//                "诸葛", "罗", "孙", "郑", "彭"};
//        String nameData2[] = {"小", "晓", "燕", "天", "昊", "皓", "世", "秋", "纯", "春", "夏", "冬", "意", "玉",
//                "南", "西", "林", "风", "山", "安", "科", "木"};
//        String nameData3[] = {"婷", "芳", "平", "可", "燕", "傲", "艳", "洁", "杰", "铠", "龙", "聂", "庄", "涵",
//                "香"};
//        for (int i = 0; i < 100; i++) {
//            String id = "use" + Long.toString(new Date().getTime()) + Math.round(Math.random() * 1000 + 1000);
////            userDetail.setUserId(id);
//            userLogin.setUserId(id);
//            String name = "";
//            if ((int) (Math.random() * 10) > 5) {
//                name = nameData1[(int) (Math.random() * 33)] + nameData2[(int) (Math.random() * 22)] + nameData2[(int) (Math.random() * 15)];
//            } else {
//                name = nameData1[(int) (Math.random() * 33)] + nameData3[(int) (Math.random() * 15)];
//            }
//            userLogin.setUserName(name);
//            userLogin.setEmail("11@11.com");
//            userLogin.setPassword("1111" + i);
//            userLogin.setPhone("187" + i);
//            userLogin.setUserAccount("admin" + i);
//            userLogin.setRegistrationTime(Long.toString(new Date().getTime()));
//            userLoginMapper.insert(userLogin);
////            userDetailMapper.insert(userDetail);
//        }
//
//
//    }
//
//    @Test
//    public void MD5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        MessageDigest md5 = MessageDigest.getInstance("md5");
//        System.out.println(md5.digest("1234".getBytes("utf-8")).toString());
//    }
//
//    @Test
//    public void testSting() {
//        String str = "java.lang.Exception: token不能为空";
//        System.out.println(str.split(":")[1]);
//    }
//
//    @Test
//    public void testSQL() {
//        // String id="pro16469161528251714";
//        //List<ProductPrice> productPrice =  productPriceMapper.selectById(id);
//
////        ProductDetail ProductDetail = productService.findProductDetailById(id);
//        //  System.out.println(productPrice);
////        String regex = ;
//        //  Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
//        String data[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
//                "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
//                "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
//        String str = "";
//        for (int i = 0; i < 1000; i++) {
//            str += data[(int) (Math.random() * 36)];
//        }
//        String id = "pro" + Long.toString(new Date().getTime()) + str;
//
//        System.out.println(id);
//
//    }
//
//
//}
//
//
//
//}