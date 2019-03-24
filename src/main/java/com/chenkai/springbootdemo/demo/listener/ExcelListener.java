package com.chenkai.springbootdemo.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.chenkai.springbootdemo.demo.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析监听器，
 * * 每解析一行会回调invoke()方法。
 * * 整个excel解析结束会执行doAfterAllAnalysed()方法
 * Author: chenkai
 * Date: 2019-03-24
 */
public class ExcelListener extends AnalysisEventListener {
    private Logger logger = LoggerFactory.getLogger(getClass());


    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList();

    /**
     * 读取数据之后的操作
     * @param object
     * @param context
     */
    public void invoke(Object object, AnalysisContext context) {
//        System.out.println(JSON.toJSON(object));
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }

    private void doSomething(Object object) {
        //1、入库调用接口
        // 打印出时间
        UserInfo userInfo = (UserInfo) object;
        logger.info("获取的对象为：{}", JSON.toJSONString(userInfo));

    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
