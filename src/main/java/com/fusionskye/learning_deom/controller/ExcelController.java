package com.fusionskye.learning_deom.controller;

import com.fusionskye.learning_deom.dto.ResultResponse;
import com.fusionskye.learning_deom.listener.StudentListener;
import com.fusionskye.learning_deom.po.Student;
import com.fusionskye.learning_deom.service.ExcelService;
import com.fusionskye.learning_deom.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mazhen
 * @className ExcelController
 * @Description TODO
 * @date 2020/11/17 15:48
 */
@Log4j2
@RestController
@RequestMapping("/excel")
@Api(tags = "Excel上传下载")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    private CopyOnWriteArrayList<Student> studentList;

    public CopyOnWriteArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(CopyOnWriteArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    //上传excel
    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public ResultResponse excelUpload(MultipartFile file) {
        ResultResponse response = checkParam(file);
        if (!(200 == response.getStatus())) {
            return response;
        }
        //调用service中的uploadExcel()获取excel中的数据
        List<Student> students = excelService.uploadExcel(file, Student.class, new StudentListener());
        //将得到的excel数据封装后进行返回
        return ResultResponse.success(students);
    }

    private ResultResponse checkParam(MultipartFile file) {
        if (null == file) {
            return ResultResponse.fail("上传的文件为空");
        }
        String filename = file.getOriginalFilename();
        if (StringUtils.isEmpty(filename)) {
            return ResultResponse.fail("文件格式异常");
        }
        if (!filename.contains(".xlsx") && !filename.contains(".XLSX")) {
            return ResultResponse.fail("文件格式错误");
        }
        return ResultResponse.success();
    }

    //先从前端获取studentList
    @PostMapping("/getStudent")
    public void getStudent(@RequestBody CopyOnWriteArrayList<Student> students) {
        setStudentList(students);
    }

    //实现excel下载功能
    @GetMapping("/download")
    @ApiOperation("下载文件")
    public void downloadExcel(HttpServletResponse response) {
        try {
            ExcelUtils.writeExcel("学生信息", Student.class, response, getStudentList());
        } catch (Exception e) {
            log.error("导出excel表格失败:", e);
        }
    }

}
