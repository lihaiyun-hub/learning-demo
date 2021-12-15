package com.fusionskye.learning_deom.service;

import com.fusionskye.learning_deom.listener.StudentListener;
import com.fusionskye.learning_deom.po.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    List<Student> uploadExcel(MultipartFile file, Class head, StudentListener listener);
}
