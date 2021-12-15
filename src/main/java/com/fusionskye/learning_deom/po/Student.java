package com.fusionskye.learning_deom.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author mazhen
 * @className Student
 * @Description 
 * @date 2020/11/17 15:30
 */
@Data
public class Student {
    /**
     * @ExcelProperty(value = "ID") 将列与Excel中的列名进行对应
     * 也可不加此注解，但就要求Excel中列名与类的属性名要一致
     */
    @ApiModelProperty("id")
    @ExcelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty("姓名")
    @ExcelProperty(value = "姓名")
    private String name;
    @ApiModelProperty("性别")
    @ExcelProperty(value = "性别")
    private String gender;
    @ApiModelProperty("生日")
    @ColumnWidth(20)
    @ExcelProperty(value = "生日")
    private String birthday;
    @ApiModelProperty("成绩")
    @ExcelProperty(value = "成绩")
    private Integer score;
}
