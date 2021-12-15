package com.fusionskye.learning_deom.controller;

import com.fusionskye.learning_deom.dto.ResultBody;
import com.fusionskye.learning_deom.po.Company;
import com.fusionskye.learning_deom.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "获取公司信息")
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    @ApiOperation(value = "添加公司信息")
    public ResultBody insert(@RequestBody Company company) {
        System.out.println("开始新增...");

        Integer num = companyService.insert(company);
        System.out.println(company.getId());
        return ResultBody.success();
    }

    @PutMapping("/modifyCompany")
    @ApiOperation(value = "修改公司信息")
    public ResultBody update(@RequestBody Company company) {
        System.out.println("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理

        return ResultBody.success();
    }

    @DeleteMapping("/removeCompany")
    @ApiOperation("删除公司信息")
    public boolean delete(@RequestBody Company company) {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

    @GetMapping("/selectCompany")
    @ApiOperation("查询公司信息")
    public ResultBody findByUser() {
        System.out.println("开始查询...");
        List<Company> companyList = new ArrayList<>();
        companyList = companyService.selectAll();
        return ResultBody.success(companyList);
    }

   /* @Scheduled(cron = "0 ")
    public void fixedRate() throws Exception {
        log.info("fixedRate run");
        TimeUnit.SECONDS.sleep(3);
    }*/

    @GetMapping("/batch_addCompany")
    @ApiOperation("批量添加公司信息")
    public ResultBody batchInsert() {
        System.out.println("开始新增...");
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Company company = new Company();
            company.setCompanyName("淘宝" + i);
            company.setCompanyAddress("浙江杭州" + i);
            companyList.add(company);
        }
        companyService.insertBatch(companyList);
        return ResultBody.success();
    }
}