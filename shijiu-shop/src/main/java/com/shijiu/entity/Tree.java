package com.shijiu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "表tree实体类", description = "表tree实体类")
public class Tree implements Serializable {
    private static final long serialVersionUid = 1L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "主键id")
    private String theme;

    @ApiModelProperty(value = "主键id")
    private String mainPart;

    @ApiModelProperty(value = "主键id")
    private String firstFactor;

    @ApiModelProperty(value = "主键id")
    private String secondFactor;

    @ApiModelProperty(value = "主键id")
    private String thirdFactor;

    @ApiModelProperty(value = "主键id")
    private String fourFactor;

}
