package com.shijiu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "节点标志", description = "节点标志")
public class FlagTag implements Serializable {

    private static final long serialVersionUid = 1L;

    @ApiModelProperty(value = "第一节点")
    private String first;

    @ApiModelProperty(value = "第二节点")
    private String second;

    @ApiModelProperty(value = "第三节点")
    private String third;

    @ApiModelProperty(value = "第四节点")
    private String fourth;

    @ApiModelProperty(value = "第五节点")
    private String fifth;

    @ApiModelProperty(value = "第六节点")
    private String sixth;

    @ApiModelProperty(value = "第七节点")
    private String seventh;

    @ApiModelProperty(value = "第八节点")
    private String eighth;

    @ApiModelProperty(value = "第九节点")
    private String ninth;
}
