package com.fusionskye.learning_deom.service;

import com.fusionskye.learning_deom.po.Company;
import com.fusionskye.learning_deom.po.User;

import java.util.List;

/**
 * @author LHY
 */
public interface CompanyService {
    /**
     *
     * */
    List<Company> selectAll();

    Integer insert(Company company);

    void insertBatch(List<Company> companyList);
}
