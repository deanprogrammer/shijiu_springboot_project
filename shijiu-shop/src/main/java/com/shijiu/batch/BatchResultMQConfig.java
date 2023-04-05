/*
package com.shijiu.batch;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;

@Configuration
public class BatchResultMQConfig extends BaseMQConfig{

    Logger logger = LoggerFactory.getLogger(BatchResultMQConfig.class);

    @Autowired(required = false)
    public void setProducerId(@Value("${mq.resultProducerId:}") String producerId) {
        this.producerId = producerId;
    }

    @Autowired(required = false)
    public void setConsumerId(@Value("${mq.resultConsumerId:}") String consumerId) {
        this.consumerId = consumerId;
    }

    @Autowired(required = false)
    public void setAccessKey(@Value("${mq.accessKey:}") String accessKey) {
        this.accessKey = accessKey;
    }

    @Autowired(required = false)
    public void setSecretKey(@Value("${mq.secretKey:}") String secretKey) {
        this.secretKey = secretKey;
    }

    @Autowired(required = false)
    public void setOnsAddr(@Value("${mq.onsAddr:}") String onsAddr) {
        this.onsAddr = onsAddr;
    }

    @Autowired(required = false)
    public void setNamesrvAddr(@Value("${mq.namesrvAddr:}") String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    @Autowired(required = false)
    public void setProducerTopic(@Value("${mq.producerTopic:}") String producerTopic) {
        this.producerTopic = producerTopic;
    }

    @Autowired(required = false)
    public void setConsumerTopic(@Value("${mq.consumerTopic:}") String consumerTopic) {
        this.consumerTopic = consumerTopic;
    }

    @Autowired(required = false)
    public void setProducerTag(@Value("${mq.producerTag:}") String producerTag) {
        this.producerTag = producerTag;
    }

    @Autowired(required = false)
    public void setConsumerTag(@Value("${mq.consumerTag:}") String consumerTag) {
        this.consumerTag = consumerTag;
    }

//    @Resource(name = "transSendListener")
    private MessageListener transSendListener;

//    @Resource(name = "generateMaterialListener")
    private MessageListener generateMaterialListener;

//    @Resource(name = "syncErpContractInfoListenner")
    private MessageListener syncErpContractInfoListenner;

//    @Resource(name = "syncOaContractInfoListenner")
    private MessageListener syncOaContractInfoListenner;

//    @Resource(name = "statementSpecialListener")
    private MessageListener statementSpecialListener;

//    @Resource(name = "statementBatchListener")
    private MessageListener statementBatchListener;

//    @Resource(name = "transSendSignNotifyListener")
    private MessageListener transSendSignNotifyListener;

//    @Resource(name = "transSendOrderSignNotifyListener")
    private MessageListener transSendOrderSignNotifyListener;

//    @Resource(name = "djcSendPurchaserOrderSignNotifyListener")
    private MessageListener djcSendPurchaserOrderSignNotifyListener;

//    @Resource(name = "djcSendSupplierOrderSignNotifyListener")
    private MessageListener djcSendSupplierOrderSignNotifyListener;

//    @Resource(name = "djcSendBrokerOrderSignNotifyListener")
    private MessageListener djcSendBrokerOrderSignNotifyListener;

//    @Resource(name = "executionOaLaunchNotifyListener")
    private MessageListener executionOaLaunchNotifyListener;

//    @Resource(name = "executionOaFinanceConfirmNotifyListener")
    private MessageListener executionOaFinanceConfirmNotifyListener;

//    @Resource(name = "executionOaEngineerConfirmNotifyListener")
    private MessageListener executionOaEngineerConfirmNotifyListener;

//    @Resource(name = "executionOaVgmConfirmNotifyListener")
    private MessageListener executionOaVgmConfirmNotifyListener;

//    @Resource(name = "econtractEvidListener")
    private MessageListener econtractEvidListener;

//    @Resource(name = "contractExecAttachListener")
    private MessageListener contractExecAttachListener;

//    @Resource(name = "contractAttachSyncListener")
    private MessageListener contractAttachSyncListener;

//    @Resource(name = "transBorkerPaymentListener")
    private MessageListener transBorkerPaymentListener;

//    @Resource(name = "borkerPmtApproveNotifyListener")
    private MessageListener borkerPmtApproveNotifyListener;

//    @Resource(name = "contractSignEventManualListener")
    private MessageListener contractSignEventManualListener;

//    @Resource(name = "createContractOutSignListener")
    private MessageListener createContractOutSignListener;

//    @Resource(name = "greenlandRelatedOrderNotifyListener")
    private MessageListener greenlandRelatedOrderNotifyListener;

	*/
/*@Resource(name = "createDiffFileListenner")
	private MessageListener createDiffFileListenner;*//*


//    @Resource(name = "wordUnderlineContextListener")
    private MessageListener wordUnderlineContextListener;

//    @Resource(name = "contractSettlementApproveListener")
    private MessageListener contractSettlementApproveListener;

//    @Resource(name = "contractSettlementApproveNotifyListener")
    private MessageListener contractSettlementApproveNotifyListener;

//    @Resource(name = "resetStatementListener")
    private MessageListener resetStatementListener;

//    @Resource(name = "pmtSupplierSyncListener")
    private MessageListener pmtSupplierSyncListener;

//    @Resource(name = "paymentApplyBatchNotifyMertailListener")
//    private PaymentApplyBatchNotifyMertailListener paymentApplyBatchNotifyMertailListener;

//    @Resource(name = "paymentApplyBatchUpdateOaStatusListener")
//    private PaymentApplyBatchUpdateOaStatusListener paymentApplyBatchUpdateOaStatusListener;

//    @Resource(name = "contractBatchOaApproveStatusListener")
//    private ContractBatchOaApproveStatusListener contractBatchOaApproveStatusListener;
//    @Resource(name = "statementBatchNotifyListener")
//    private StatementBatchNotifyListener statementBatchNotifyListener;

    @Bean(initMethod = "start", destroyMethod = "shutdown", name = "taskResultProducer")
    public ProducerBean getTaskResultProducer() {
        return getProducer();
    }

    @Bean(initMethod = "start", destroyMethod = "shutdown", name = "taskConsumer")
    public ConsumerBean getTaskConsumer() {
        Map<String, MessageListener> mqListenerConfig = new HashMap<>();
//		mqListenerConfig.put("ETRADE_FILE_SEND_JOB", transSendListener);
//		mqListenerConfig.put("ETRADE_GENERATE_MATERIAL_JOB", generateMaterialListener);
//		//同步ERP、OA合同审批信息
//		mqListenerConfig.put("ETRADE_SYNC_ERP_CONTRACT_JOB", syncErpContractInfoListenner);
//		mqListenerConfig.put("ETRADE_SYNC_OA_CONTRACT_JOB", syncOaContractInfoListenner);
//		mqListenerConfig.put("ETRADE_STATEMENT_SPECIAL_JOB", statementSpecialListener);
//		mqListenerConfig.put("ETRADE_STATEMENT_BATCH_JOB", statementBatchListener);
//
//		// 发送法务签章提醒
//		mqListenerConfig.put("ETRADE_SIGN_NOTIFY_JOB", transSendSignNotifyListener);
//
//		// 发送采购商和供应商签章
//		mqListenerConfig.put("ETRADE_SIGN_ORDER_NOTIFY_JOB", transSendOrderSignNotifyListener);

        // 发送采购商签章
        mqListenerConfig.put("DJC_B_SIGN_ORDER_NOTIFY_JOB", djcSendPurchaserOrderSignNotifyListener);

        // 发送供应商签章
        mqListenerConfig.put("DJC_S_SIGN_ORDER_NOTIFY_JOB", djcSendSupplierOrderSignNotifyListener);

        // 发送供应商签章
        mqListenerConfig.put("DJC_BROKER_SIGN_ORDER_NOTIFY_JOB", djcSendBrokerOrderSignNotifyListener);

        // 发送付款申请审核通知
//        mqListenerConfig.put("DJC_APPLY_PAY_NOTIFY_JOB", paymentApplyBatchNotifyMertailListener);

        // 更新付款申请oa审核状态
//        mqListenerConfig.put("DJC_UPDATE_PAY_OA_RESULT_JOB", paymentApplyBatchUpdateOaStatusListener);

        //查询OA合同审批状态
//        mqListenerConfig.put("DJC_GET_CONTRACT_OA_STATUS_JOB", contractBatchOaApproveStatusListener);
        //预付款-对账单批量通知
//        mqListenerConfig.put("DJC_STATEMENT_BATCH_NOTIFY", statementBatchNotifyListener);

//
//		//批量通知OA流程发起邮件发送
//		mqListenerConfig.put("ETRADE_CONTRACT_LAUNCH_JOB", executionOaLaunchNotifyListener);
//
//		//批量通知OA流程财务部邮件发送
//		mqListenerConfig.put("ETRADE_CONTRACT_FINANCE_JOB", executionOaFinanceConfirmNotifyListener);
//
//		//批量通知OA流程工程部邮件发送
//		mqListenerConfig.put("ETRADE_CONTRACT_ENGINEER_JOB", executionOaEngineerConfirmNotifyListener);
//
//		//批量通知OA副总经理审批通知邮件发送
//		mqListenerConfig.put("ETRADE_CONTRACT_VGM_JOB", executionOaVgmConfirmNotifyListener);
//
//		//批量存证
//		mqListenerConfig.put("ETRADE_ECONTRACT_EVID_JOB",econtractEvidListener);
//
//		//批量同步流程附件（手动）
//		mqListenerConfig.put("ETRADE_EXECUTION_ATTACH_JOB",contractExecAttachListener);
//
//		//批量同步流程附件（定时）
//		mqListenerConfig.put("ETRADE_EXEC_ATTACH_SYNC_JOB",contractAttachSyncListener);
//
//		//批处理创建博置请款流程
//		mqListenerConfig.put("ETRADE_BORKER_PAYMENT_JOB",transBorkerPaymentListener);
//		//通知工程部审批请款任务
//		mqListenerConfig.put("ETRADE_PMT_OPERATION_APPROVE_JOB",borkerPmtApproveNotifyListener);
//		//通知合约部审批请款任务
//		mqListenerConfig.put("ETRADE_PMT_CONTRACT_APPROVE_JOB",borkerPmtApproveNotifyListener);
//		//通知财务部审批请款任务
//		mqListenerConfig.put("ETRADE_PMT_FINANCE_APPROVE_JOB",borkerPmtApproveNotifyListener);
//		//通知副总经理审批请款任务
//		mqListenerConfig.put("ETRADE_PMT_VGM_APPROVE_JOB",borkerPmtApproveNotifyListener);
//		//生成签章合同事件手动处理批处理
//		mqListenerConfig.put("CONTRACT_SIGN_EVENT_MANUAL_JOB",contractSignEventManualListener);
//		//生成外部签章合同事件手动处理批处理
//		mqListenerConfig.put("OUTCONTRACT_SIGN_EVENT_JOB",createContractOutSignListener);
//		// 绿地相关企业订单提醒定时任务
//		mqListenerConfig.put("ETRADE_GK_RELATED_ORDER_JOB", greenlandRelatedOrderNotifyListener);
//		// 明源合同文档生成差异文件
//		// mqListenerConfig.put("ETRADE_CREATE_DIFF_FILE_JOB", createDiffFileListenner);
//		// 下划线锚点生成
//		mqListenerConfig.put("ETRADE_WORD_UNDERLINE_JOB", wordUnderlineContextListener);
//		// 同步ERP合同结算审批
//		mqListenerConfig.put("ETRADE_CONTRACT_SETTLEMENT_JOB", contractSettlementApproveListener);
//		//合约部发起合同结算审批任务
//		mqListenerConfig.put("ETRADE_SETTLEMENT_APPLY_JOB", contractSettlementApproveNotifyListener);
//		//通知工程部合同结算审批任务
//		mqListenerConfig.put("ETRADE_SETTLEMENT_CONFIRM_JOB", contractSettlementApproveNotifyListener);
//		//通知合约部合同结算审批任务
//		mqListenerConfig.put("ETRADE_SETTLEMENT_CONTRACT_JOB", contractSettlementApproveNotifyListener);
//		//通知财务部合同结算审批任务
//		mqListenerConfig.put("ETRADE_SETTLEMENT_FINANCE_JOB", contractSettlementApproveNotifyListener);
//		//通知副总经理合同结算审批任务
//		mqListenerConfig.put("ETRADE_SETTLEMENT_VGM_JOB", contractSettlementApproveNotifyListener);
//		//重置对账单
//		mqListenerConfig.put("ETRADE_RESETSTATEMENT_JOB", resetStatementListener);
//		//供应商请款同步到材料公司请款审批
//		mqListenerConfig.put("ETRADE_PMT_SUPPLIER_SYNC_JOB", pmtSupplierSyncListener);
//        BatchMQConsumerFactoryListener batchMQConsumerFactoryListener = new BatchMQConsumerFactoryListener();
//        batchMQConsumerFactoryListener.setMqListenerConfig(mqListenerConfig);
        Subscription subscription = new Subscription();
        subscription.setTopic(producerTopic);

        StringJoiner tagJoin = new StringJoiner("||");
        for (String tag : mqListenerConfig.keySet()) {
            tagJoin.add(tag);
        }

        subscription.setExpression(tagJoin.toString());
        Map<Subscription, MessageListener> map = new HashMap<>();
//        map.put(subscription, batchMQConsumerFactoryListener);

        return getConsumer(map);
    }

}
*/
