package com.shijiu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "概览", description = "概览")
public class OverViewResp implements Serializable {

    private static final long serialVersionUid = 1L;

    @ApiModelProperty(value = "id")
    private String fieldId;

    @ApiModelProperty(value = "字段中文名")
    private String fieldCn;

    @ApiModelProperty(value = "字段中文描述")
    private String fieldDesc;

    @ApiModelProperty(value = "类型：1:基础；0:衍生")
    private String labelType;
}
