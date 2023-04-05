package com.shijiu.util;

import com.shijiu.entity.OverViewTreeResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuData {

    public static final String ALL_MENU = "全部";

    private List<OverViewTreeResp> bodyList; //全部节点

    private List<OverViewTreeResp> rootList; //根节点

    public MenuData(List<OverViewTreeResp> bodyList, List<OverViewTreeResp> rootList) {
        this.bodyList = bodyList;
        this.rootList = rootList;
    }

    public List<OverViewTreeResp> getTree(){
        if (!CollectionUtils.isEmpty(bodyList)){
            Map<String, String> map = new HashMap<>(bodyList.size());
            rootList.forEach(e -> {
                getChildren(e, map);
            });
            return rootList;
        }
        return null;
    }

    /**
     * 获取所有子节点
     */
    public void getChildren(OverViewTreeResp tree, Map<String, String> map){
        List<OverViewTreeResp> childs = new ArrayList<>();
        bodyList.stream().filter(c -> !map.containsKey(c.getPid() + c.getId()))
                .filter(c -> tree.getId().equals(c.getPid()) && StringUtils.isNotEmpty(tree.getPid()) && StringUtils.isNotEmpty(c.getGid()) && tree.getPid().equals(c.getGid()))
                .forEach(c -> {
                    map.put(c.getPid() + c.getId(), c.getPid());
                    getChildren(c, map);
                    childs.add(c);
                });
        tree.setChildren(childs);
    }
}
