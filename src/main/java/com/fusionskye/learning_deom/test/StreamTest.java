package com.fusionskye.learning_deom.test;

import com.fusionskye.learning_deom.po.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LHY
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            companyList.add(Company.builder()
                    .id(i)
                    .companyName("taobao" + i)
                    .companyAddress("hangzhou" + i)
                    .build());
        }
        List<Company> companyList1 = companyList.stream().filter(company -> !company.getCompanyName().equals("taobao1")).collect(Collectors.toList());
        System.out.println(companyList1);
    }
}
