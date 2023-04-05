package com.shijiu.batch;

public class ProcessExecuteInfo {
    private String executeFlowNo = "";
    private long startTime;
    private long endTime;
    private String processId;
    private String processName;
    private String executeResult;
    private String message;
    private int totalCount;
    private int successCount;
    private int failCount;
    private String tenantId;
    private String jobParam;
    public static final String EXECUTE_RUNNING = "RUNNING";
    public static final String EXECUTE_SUCCESS = "SUCCESS";
    public static final String EXECUTE_PART_SUCCESS = "PART_SUCC";
    public static final String EXECUTE_FAIL = "FAIL";
    public static final String EXECUTE_EXCEPTION = "EXCEPTION";
    public static final String SEND_SUCCESS = "SEND_SUCCESS";

    public void init(String processId, String processName) {
        this.startTime = System.currentTimeMillis();
        this.processId = processId;
        this.processName = processName;
        this.executeFlowNo = processId + this.createFlowNo();
    }

    public void copyInitInfo(ProcessExecuteInfo info) {
        this.startTime = info.getStartTime();
        this.processId = info.getProcessId();
        this.processName = info.getProcessName();
        this.executeFlowNo = info.getExecuteFlowNo();
    }

    private String createFlowNo() {
        return String.valueOf(System.currentTimeMillis());
    }

    private long calExecuteTime() {
        return this.startTime != 0L && this.endTime != 0L ? (this.endTime - this.startTime) / 1000L : 0L;
    }

    public String getExecuteFlowNo() {
        return this.executeFlowNo;
    }

    public void setExecuteFlowNo(String executeFlowNo) {
        this.executeFlowNo = executeFlowNo;
    }

    public long getExecuteTime() {
        return this.calExecuteTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getProcessId() {
        return this.processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getExecuteResult() {
        return this.executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return this.failCount > 0 ? this.failCount : this.totalCount - this.successCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getJobParam() {
        return this.jobParam;
    }

    public void setJobParam(String jobParam) {
        this.jobParam = jobParam;
    }
}
