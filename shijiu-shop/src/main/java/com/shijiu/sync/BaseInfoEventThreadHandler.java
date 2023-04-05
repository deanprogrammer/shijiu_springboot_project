package com.shijiu.sync;

public class BaseInfoEventThreadHandler implements IEventHandler{
    @Override
    public void execute(IEventTask paramIEventTask) {
        BaseInfoThreadExecutor.getInstance().execute(paramIEventTask);
    }
}
