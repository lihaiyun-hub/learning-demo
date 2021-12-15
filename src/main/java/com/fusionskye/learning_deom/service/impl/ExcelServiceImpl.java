package com.fusionskye.learning_deom.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.fusionskye.learning_deom.listener.StudentListener;
import com.fusionskye.learning_deom.po.Student;
import com.fusionskye.learning_deom.service.ExcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author mazhen
 * @className ExcelServiceImpl
 * @Description TODO
 * @date 2020/11/17 15:43
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    //读取上传的excel
    @Override
    public List<Student> uploadExcel(MultipartFile file, Class head, StudentListener listener) {
        try {
            //1.获取工作簿
            ExcelReaderBuilder readBook = EasyExcel.read(file.getInputStream(), head, listener);
            //2.获取sheet
            ExcelReaderSheetBuilder sheet = readBook.sheet();
            //3.获取Excel中的数据
            List<Student> students = sheet.doReadSync();
            //4.返回数据
            return students;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
