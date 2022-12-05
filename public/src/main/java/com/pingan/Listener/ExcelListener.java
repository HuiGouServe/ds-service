//package com.pingan.Listener;
//
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.event.AnalysisEventListener;
//import com.pingan.Object.excel;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ExcelListener extends AnalysisEventListener<excel> {
//    private List<excel> datas = new ArrayList<>();
//
//    @Override
//    public void invoke(excel data, AnalysisContext analysisContext) {
////        System.out.println("****"+data);
//        datas.add(data);
//    }
//
//    //读取表头内容
//    @Override
//    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//        System.out.println("表头：" + headMap);
//    }
//
//    //读取完成之后
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//    }
//
//    public List<excel> getDatas() {
//        return datas;
//    }
//
//    public void setDatas(List<excel> datas) {
//        this.datas = datas;
//    }
//}
