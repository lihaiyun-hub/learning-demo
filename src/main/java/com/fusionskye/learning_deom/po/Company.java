package com.fusionskye.learning_deom.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LHY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "公司名字")
    private String companyName;
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;
}
