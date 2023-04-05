package com.shijiu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "树形菜单", description = "树形菜单")
public class OverViewTreeResp implements Serializable {

    private static final long serialVersionUid = 1L;

    @ApiModelProperty(value = "当前节点id")
    private String id;

    @ApiModelProperty(value = "父节点id")
    private String pid;

    @ApiModelProperty(value = "顶层节点id")
    private String gid;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "节点名称")
    private String nodeName;

    @ApiModelProperty(value = "数据个数")
    private Integer dataNum = 0;

    @ApiModelProperty(value = "排序")
    private Integer sortOrder;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "层级目录")
    private String idMenu;

    @ApiModelProperty(value = "子节点")
    private List<OverViewTreeResp> children = new ArrayList<>();

    @ApiModelProperty(value = "末节点数据")
    private List<OverViewResp> overViewList = new ArrayList<>();

    @ApiModelProperty(value = "第一层到当前节点")
    private List<FlagTag> idList;

    public OverViewTreeResp() {
    }

    public OverViewTreeResp(String id, String pid, String gid, String icon, String nodeName, Integer dataNum, Integer sortOrder, String theme, String idMenu, List<OverViewTreeResp> children, List<OverViewResp> overViewList, List<FlagTag> idList) {
        this.id = id;
        this.pid = pid;
        this.gid = gid;
        this.icon = icon;
        this.nodeName = nodeName;
        this.dataNum = dataNum;
        this.sortOrder = sortOrder;
        this.theme = theme;
        this.idMenu = idMenu;
        this.children = children;
        this.overViewList = overViewList;
        this.idList = idList;
    }
}
