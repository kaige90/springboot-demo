package com.chenkai.springbootdemo.demo.service;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;
import com.chenkai.springbootdemo.demo.listener.ExcelListener;
import com.chenkai.springbootdemo.demo.model.UserInfo;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chenkai.springbootdemo.demo.util.DataUtil.*;
import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

/**
 * 表格处理测试类
 * Author: chenkai
 * Date: 2019-03-24
 */
public class ExcelServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testExcel2003WithReflectModel() throws IOException {
        InputStream inputStream = getInputStream("/Users/chenkai/data/temp/users1.xlsx");
        try {
            // 解析每行结果在listener中处理
            AnalysisEventListener<UserInfo> listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(inputStream, UserInfo.class, listener);

            excelReader.read(new Sheet(1, 1, UserInfo.class));
            List<Object> list = ((ExcelListener) listener).getDatas();
            logger.info("查询的结果为：{}", JSON.toJSON(list));

        } catch (Exception e) {
            logger.error("文本读取错误", e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void readData() throws IOException {
        InputStream inputStream = getInputStream("/Users/chenkai/data/temp/users1.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1, UserInfo.class));
        logger.info("读取的数据为：{}", JSON.toJSONString(data));
    }

    @Test
    public void writeDate() throws IOException {
        OutputStream out = new FileOutputStream("/Users/chenkai/data/temp/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 1);
        sheet1.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 10000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        List<List<String>> head = Lists.newArrayList();
        head.add(Lists.newArrayList("姓名"));
        head.add(Lists.newArrayList("手机号"));
        head.add(Lists.newArrayList("性别"));
        head.add(Lists.newArrayList("注册日期"));
        sheet1.setHead(head);
        //or 设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);


        //关闭资源
        writer.finish();
        out.close();
    }

    @Test
    public void writeDate2() throws IOException {
        OutputStream out = new FileOutputStream("/Users/chenkai/data/temp/2007_2.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 1,UserInfo.class);
        sheet1.setSheetName("第一个sheet");
        //or 设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        // 模拟用户
        List<UserInfo> list = Lists.newArrayList();
        UserInfo u1 = new UserInfo();
        u1.setMobile("10312012311");
        u1.setName("Kate");
        u1.setSex("male");
        u1.setCreateDate(new Date());
        list.add(u1);
        UserInfo u2 = new UserInfo();
        u2.setMobile("18011231122");
        u2.setSex("female");
        u2.setCreateDate(new Date());
        u2.setName("Mike");
        list.add(u2);
        writer.write(list, sheet1);
        //关闭资源
        writer.finish();
        out.close();
    }
}
