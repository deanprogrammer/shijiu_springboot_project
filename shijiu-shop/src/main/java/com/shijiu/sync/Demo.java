package com.shijiu.sync;

import java.io.UnsupportedEncodingException;

public class Demo {

    public static void main(String[] args) {
//        new BaseInfoEventThreadHandler().execute(new IEventTask() {
//            @Override
//            public void run() {
//
//            }
//        });
        String t1="ａＡ　（－＿｀～全角１２，。、？／！！？？！!,.";
        System.out.println(switchFullToHalf(t1));

        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; ++i) {
            System.out.println(i + "    " + (char)i);
        }
    }


    public static final String switchFullToHalf(String fullStr) {

        if (fullStr == null) {
            return "";
        }

        StringBuffer buffer = new StringBuffer("");

        try {
            String singleStr = "";
            byte[] byteArray = null;
            for (int i = 0; i < fullStr.length(); i++) {
                singleStr = fullStr.substring(i, i + 1);
                // 全角空格转换成半角空格
                if (singleStr.equals("　")) {
                    buffer.append(" ");
                    continue;
                }
                byteArray = singleStr.getBytes("unicode");
                // 得到 unicode 字节数据
                if (byteArray[2] == -1) {// 表示全角
                    byteArray[3] = (byte) (byteArray[3] + 32);
                    byteArray[2] = 0;
                    buffer.append(new String(byteArray, "unicode"));
                } else {
                    buffer.append(singleStr);
                }
            }
        }catch( UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch( Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();

    }
}
