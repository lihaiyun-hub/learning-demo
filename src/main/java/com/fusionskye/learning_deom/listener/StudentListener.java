package com.fusionskye.learning_deom.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fusionskye.learning_deom.po.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author mazhen
 * @className StudentListener
 * @Description TODO
 * @date 2020/11/17 15:39
 */
@Component
@Scope("prototype")
public class StudentListener extends AnalysisEventListener<Student> {
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
