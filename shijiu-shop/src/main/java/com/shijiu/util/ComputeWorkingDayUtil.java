package com.shijiu.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shijiu.entity.HoliDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ComputeWorkingDayUtil {
    public static void main(String[] args) {
        addHolidayAndWeekends("2021");
    }

    public static void addHolidayAndWeekends(String year) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            Object response = restTemplate.exchange("http://timor.tech/api/holiday/year/" + year + "?type=Y&week=Y", HttpMethod.GET, entity, Object.class);
            Object object = ((ResponseEntity) response).getBody();
            Map<String, Object> map = (Map) object;
            Map<String, Object> mapHoliday = (Map) map.get("holiday");
            System.out.println(JSONObject.toJSONString(mapHoliday));

            List<HoliDTO> list = new ArrayList<>();
            for (Map.Entry<String, Object> entry : mapHoliday.entrySet()) {
                HoliDTO holidayEntry = new HoliDTO();
                Map<String, Object> mapValue = (Map<String, Object>) entry.getValue();
                Boolean holiday = (Boolean) mapValue.get("holiday");
                String name = (String) mapValue.get("name");
                Integer wage = (Integer) mapValue.get("wage");
                String date = mapValue.get("date").toString();
                holidayEntry.setHoliday(holiday);
                holidayEntry.setName(name);
                holidayEntry.setWage(wage);
                holidayEntry.setDate(date);
                list.add(holidayEntry);
                //这里就是存入数据库的操作了
//            holidayMapper.insert(holidayEntry)holidayEntry;
            }
            //只取节假日和周末
            list = list.stream().filter(e -> e.isHoliday()).collect(Collectors.toList());
            System.out.println(JSONObject.toJSONString(list));

            List<String> dates = list.stream().map(HoliDTO::getDate).collect(Collectors.toList());
            System.out.println(JSONObject.toJSONString(dates));

            List<String> weekends = new ArrayList<>();
            dates.forEach(e -> {
                weekends.add(e.substring(5, e.length()));
            });
            System.out.println(JSONObject.toJSONString(weekends));

            System.out.println(weekends.toString());
            System.out.println(weekends.toString().replaceAll("(?:\\[|null|\\]| +)", ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


//    //定义两个List，一个存放节假日日期，另一个存放调休的工作日期
//    private static List<String> HOLIDAY_LIST = new ArrayList<>();
//    private static List<String> SPECIAL_WORKDAY_LIST = new ArrayList<>();
//
//    //静态代码块内调用第三方接口拿到数据存进List中
//    static {
//        Map<String, Object> param = new HashMap<String, Object>() {{
//            put("key", "");//这里key值是注册天行API账号是给的
//            put("type", 1);
//        }};
//
//        //获取当前年份，循环调用3次，拿到3年的数据
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        for (int i=0; i<3; i++) {
//            param.put("date", currentYear - i);
//            String url = "http://api.tianapi.com/jiejiari/index";
////            String response = HttpUtil.get(url, param);
//            OkHttpClient client = new OkHttpClient();
//            Response response;
//            //解密数据
//            String rsa = null;
//            Request request = new Request.Builder()
//                    .url(url)
//                    .get()
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                    .build();
//            try {
//                response = client.newCall(request).execute();
//                rsa = response.body().string();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            JSONObject resObj = JSONUtil.parseObjectj(response);
////            JSONObject resObj = JSONObject.parseObject(response);
//            int code = (int) resObj.get("code");
//            if (code == 200) {
//                JSONArray newslist = (JSONArray) resObj.get("newslist");
//                for (Object listObj : newslist) {
//                    JSONObject obj = (JSONObject) listObj;
//                    String holidays = (String) obj.get("vacation");
//                    String[] holidayArray = holidays.split("\\|");
//                    HOLIDAY_LIST.addAll(Arrays.asList(holidayArray));
//                    String remark = (String) obj.get("remark");
//                    if (StringUtils.isNotEmpty(remark)) {
//                        String[] special = remark.split("\\|");
//                        SPECIAL_WORKDAY_LIST.addAll(Arrays.asList(special));
//                    }
//                }
//            }
//        }
//    }
//
//    //计算工作日数的方法
//    public static int computeWorkingDays(Date start, Date end) {
//        Calendar startCal = Calendar.getInstance();
//        Calendar endCal = Calendar.getInstance();
//        startCal.setTime(start);
//        endCal.setTime(end);
//
//        int workDays = 0;
//
//        //如果没有严格按照起始结束时间传值，在这里纠正下，可以注释掉
//        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
//            startCal.setTime(end);
//            endCal.setTime(start);
//        }
//
//        while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
//            //控制台打印出来循环情况，方便查看
//            System.out.println(DateUtil.format(startCal.getTime(), "yyyy-MM-dd") + "   " + DateUtil.format(endCal.getTime(), "yyyy-MM-dd"));
//            String current = DateUtil.format(startCal.getTime(), "yyyy-MM-dd");
//            int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
//            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY)
//            {
//                if (!HOLIDAY_LIST.contains(current)) {
//                    System.out.println(true);
//                    workDays++;
//                }
//            }
//            if (SPECIAL_WORKDAY_LIST.contains(current)) {
//                System.out.println(true);
//                workDays++;
//            }
//            startCal.add(Calendar.DATE, 1);
//        }
//
//        return workDays;
//    }
}


