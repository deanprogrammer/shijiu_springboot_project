package com.shijiu.batch;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

//批处理类继承AbstractBatchMQConsumerListener ，重写execute方法
public abstract class AbstractBatchMQConsumerListener implements MessageListener {

    @Value("${mq.consumerTopic:}")
    public String resultTopic;
    @Value("${mq.consumerTag:}")
    public String resultTag;
    @Autowired(required = false)
    @Qualifier("objectMapper")
    private ObjectMapper objectMapper;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Action consume(Message message, ConsumeContext context) {
//        (new EventThreadHandler()).execute(new 1(this, message, context));
        return Action.CommitMessage;
    }

    public abstract ProcessExecuteInfo execute(Message arg0, ConsumeContext arg1);
}
