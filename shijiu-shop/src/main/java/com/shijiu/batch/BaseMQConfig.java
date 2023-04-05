package com.shijiu.batch;

import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseMQConfig {
    public String producerId;
    public String consumerId;
    public String accessKey;
    public String secretKey;
    public String producerTopic;
    public String consumerTopic;
    public String producerTag;
    public String consumerTag;
    public String onsAddr;
    public String namesrvAddr;

    public ProducerBean getProducer() {
        ProducerBean producerBean = new ProducerBean();
        Properties properties = new Properties();
        properties.put("ProducerId", this.producerId);
        properties.put("AccessKey", this.accessKey);
        properties.put("SecretKey", this.secretKey);
        if (StringUtils.isNotBlank(this.onsAddr)) {
            properties.put("ONSAddr", this.onsAddr);
        } else {
            properties.put("NAMESRV_ADDR", this.namesrvAddr);
        }

        producerBean.setProperties(properties);
        return producerBean;
    }

    public ConsumerBean getConsumer() {
        HashMap map = new HashMap();
        return this.getConsumer(map);
    }

    public ConsumerBean getConsumer(Map<Subscription, MessageListener> map) {
        ConsumerBean consumerBean = new ConsumerBean();
        Properties properties = new Properties();
        properties.put("ConsumerId", this.consumerId);
        properties.put("AccessKey", this.accessKey);
        properties.put("SecretKey", this.secretKey);
        if (StringUtils.isNotBlank(this.onsAddr)) {
            properties.put("ONSAddr", this.onsAddr);
        } else {
            properties.put("NAMESRV_ADDR", this.namesrvAddr);
        }

        consumerBean.setProperties(properties);
        consumerBean.setSubscriptionTable(map);
        return consumerBean;
    }

}
