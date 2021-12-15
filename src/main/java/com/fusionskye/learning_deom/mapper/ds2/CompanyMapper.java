package com.fusionskye.learning_deom.mapper.ds2;

import com.fusionskye.learning_deom.po.Company;
import com.fusionskye.learning_deom.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LHY
 */
@Mapper
public interface CompanyMapper {

    List<Company> selectAll();

    Integer insert(Company company);

    void batchInsert(List<Company> companyList);
}
