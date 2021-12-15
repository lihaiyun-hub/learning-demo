package com.fusionskye.learning_deom.service.impl;

import com.fusionskye.learning_deom.mapper.ds1.UserMapper;
import com.fusionskye.learning_deom.mapper.ds2.CompanyMapper;
import com.fusionskye.learning_deom.po.Company;
import com.fusionskye.learning_deom.po.User;
import com.fusionskye.learning_deom.service.CompanyService;
import com.fusionskye.learning_deom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LHY
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> selectAll() {
        return companyMapper.selectAll();
    }

    @Override
    public Integer insert(Company company) {
       return companyMapper.insert(company);

    }

    @Override
    public void insertBatch(List<Company> companyList) {
        companyMapper.batchInsert(companyList);
    }
}
