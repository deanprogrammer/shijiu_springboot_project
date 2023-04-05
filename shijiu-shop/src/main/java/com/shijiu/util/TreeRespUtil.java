package com.shijiu.util;

import com.shijiu.entity.OverViewTreeResp;
import com.shijiu.entity.Tree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeRespUtil {

    public static OverViewTreeResp processData(List<Tree> dataList){
        OverViewTreeResp resp = new OverViewTreeResp();
        if (!CollectionUtils.isEmpty(dataList)){
            //根节点
            OverViewTreeResp rootTree = new OverViewTreeResp();
            List<OverViewTreeResp> rootList = new ArrayList<>();
            rootTree.setId(MenuData.ALL_MENU);
            rootTree.setNodeName(MenuData.ALL_MENU);
            rootTree.setGid(MenuData.ALL_MENU);
            rootTree.setPid(MenuData.ALL_MENU);
            rootList.add(rootTree);

            //所有子节点
            List<OverViewTreeResp> bodyList = new ArrayList<>();

            //处理叶子节点
            Map<String, OverViewTreeResp> themeMap = new HashMap<>();
            Map<String, OverViewTreeResp> mainPartMap = new HashMap<>();
            Map<String, OverViewTreeResp> firstMap = new HashMap<>();
            Map<String, OverViewTreeResp> secondMap = new HashMap<>();
            Map<String, OverViewTreeResp> thirdMap = new HashMap<>();
            Map<String, OverViewTreeResp> fourthMap = new HashMap<>();
            dataList.forEach(e -> {
                //处理叶子节点
                proceThemeData(themeMap, e.getTheme(), MenuData.ALL_MENU, MenuData.ALL_MENU, e.getTheme(), bodyList);
                proceThemeData(mainPartMap, e.getMainPart(), MenuData.ALL_MENU, e.getTheme(), e.getMainPart(), bodyList);
                proceThemeData(firstMap, e.getTheme() + e.getMainPart() + e.getFirstFactor(), e.getTheme(), e.getMainPart(), e.getFirstFactor(), bodyList);
                proceThemeData(secondMap, e.getMainPart() + e.getFirstFactor() + e.getSecondFactor(), e.getMainPart(), e.getFirstFactor(), e.getSecondFactor(), bodyList);
                proceThemeData(thirdMap, e.getFirstFactor() + e.getSecondFactor() + e.getThirdFactor(), e.getFirstFactor(), e.getSecondFactor(), e.getThirdFactor(), bodyList);
                proceThemeData(fourthMap, e.getSecondFactor() + e.getThirdFactor() + e.getFourFactor(), e.getSecondFactor(), e.getThirdFactor(), e.getFourFactor(), bodyList);
            });
            MenuData menuData = new MenuData(rootList, bodyList);
            if (null != menuData.getTree() && menuData.getTree().size() > 0){
                resp = menuData.getTree().get(0);
            }
        }
        return resp;
    }

    private static void proceThemeData(Map<String, OverViewTreeResp> map, String key, String f0, String f1, String f2, List<OverViewTreeResp> bodyList){
        if (StringUtils.isNotEmpty(f2.trim())){
            if (!map.containsKey(key)){
                OverViewTreeResp treeResp = new OverViewTreeResp();
                treeResp.setNodeName(f2);
                treeResp.setPid(f1);
                treeResp.setId(f2);
                treeResp.setGid(f0);
                map.put(key, treeResp);
                bodyList.add(treeResp);
            }
        }
    }
}
