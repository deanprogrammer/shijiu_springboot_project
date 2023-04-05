package com.shijiu.util;

import com.shijiu.entity.OverViewTreeResp;
import com.shijiu.entity.Tree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeListUtil {

    public static List<OverViewTreeResp> processData(List<Tree> dataList){
        List<OverViewTreeResp> parentList = new ArrayList<>();
        OverViewTreeResp treeResp = new OverViewTreeResp();
        if (!CollectionUtils.isEmpty(dataList)){
            //根节点
            OverViewTreeResp rootTree = new OverViewTreeResp();
            List<OverViewTreeResp> rootList = new ArrayList<>();
            //所有子节点
            List<OverViewTreeResp> bodyList = new ArrayList<>();
            rootTree.setId(MenuData.ALL_MENU);
            rootTree.setNodeName(MenuData.ALL_MENU);
            rootList.add(rootTree);

            //处理叶子节点
            Map<String, OverViewTreeResp> classify = new HashMap<>();
            Map<String, OverViewTreeResp> dataSource = new HashMap<>();
            Map<String, OverViewTreeResp> cc1 = new HashMap<>();
            Map<String, OverViewTreeResp> cc2 = new HashMap<>();
            Map<String, OverViewTreeResp> cc3 = new HashMap<>();
            Map<String, OverViewTreeResp> cc4 = new HashMap<>();
            Map<String, OverViewTreeResp> cc5 = new HashMap<>();
            Map<String, OverViewTreeResp> cc6 = new HashMap<>();

            Map<String, Integer> aMap = new HashMap<>();
            Map<String, Integer> bMap = new HashMap<>();
            Map<String, Integer> cMap = new HashMap<>();
            Map<String, Integer> dMap = new HashMap<>();
            Map<String, Integer> eMap = new HashMap<>();
            Map<String, Integer> fMap = new HashMap<>();
            Map<String, Integer> gMap = new HashMap<>();
            Map<String, Integer> hMap = new HashMap<>();

            dataList.forEach(e -> {
                proceThemeData(classify, aMap, e.getTheme(), MenuData.ALL_MENU, MenuData.ALL_MENU, e.getTheme(), bodyList, e.getTheme());
                proceThemeData(dataSource, bMap, e.getMainPart(), MenuData.ALL_MENU, e.getTheme(), e.getMainPart(), bodyList, e.getTheme());
                proceThemeData(cc1, cMap, e.getMainPart() + e.getFirstFactor(), e.getTheme(), e.getMainPart(), e.getFirstFactor(), bodyList, e.getTheme());
                proceThemeData(cc2, dMap, e.getFirstFactor() + e.getSecondFactor(), e.getMainPart(), e.getFirstFactor(), e.getSecondFactor(), bodyList, e.getTheme());
                proceThemeData(cc3, eMap, e.getSecondFactor() + e.getThirdFactor(), e.getFirstFactor(), e.getSecondFactor(), e.getThirdFactor(), bodyList, e.getTheme());
                proceThemeData(cc4, fMap, e.getThirdFactor() + e.getFourFactor(), e.getSecondFactor(), e.getThirdFactor(), e.getFourFactor(), bodyList, e.getTheme());
            });

            MenuData menuData = new MenuData(rootList, bodyList);
            if (null != menuData.getTree() && menuData.getTree().size() > 0){
                treeResp = menuData.getTree().get(0);
                parentList = treeResp.getChildren();
            }
            if (!CollectionUtils.isEmpty(parentList)){
                parentList.stream().forEach(a -> {

                });
            }
        }
        return parentList;
    }

    private static void proceThemeData(Map<String, OverViewTreeResp> map, Map<String, Integer> numMap, String key, String f0, String f1, String f2, List<OverViewTreeResp> bodyList, String theme) {
        if (StringUtils.isNotEmpty(f2.trim())) {
            if (numMap.containsKey(key)){
                numMap.put(key, numMap.get(key).intValue() + 1);
            }else {
                numMap.put(key, 1);
            }
            if (!map.containsKey(key)) {
                OverViewTreeResp treeResp = new OverViewTreeResp();
                treeResp.setNodeName(f2);
                treeResp.setPid(f1);
                treeResp.setId(f2);
                treeResp.setGid(f0);
                treeResp.setTheme(theme);
                map.put(key, treeResp);
                bodyList.add(treeResp);
            }
        }
    }
}
