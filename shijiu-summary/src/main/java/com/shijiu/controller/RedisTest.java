package com.shijiu.controller;


import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.154.128", 6379);
//        Jedis jedis = new Jedis("192.168.154.129", 6379);
        Jedis jedis = new Jedis("192.168.154.130", 6379);
        String ping = jedis.ping();
        System.out.println(ping);

//        jedis.set("dex", "你好,redis");

//        System.out.println(jedis.get("dex"));
//        System.out.println(jedis.get("test"));
        System.out.println(jedis.get("k1"));
    }
}
