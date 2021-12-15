package com.fusionskye.learning_deom.mapper.ds1;

import com.fusionskye.learning_deom.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LHY
 */
@Mapper
public interface UserMapper {

    List<User> selectAll();
}
