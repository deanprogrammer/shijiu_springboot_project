package com.shijiu.sync;

import org.springframework.core.task.TaskDecorator;

public class BaseInfoThreadExecutor {

    private static ContextThreadExecutor singleton;

    public static ContextThreadExecutor getInstance() {
        if(singleton == null) {
            Class arg = BaseInfoThreadExecutor.class;
            synchronized(BaseInfoThreadExecutor.class) {
                if(singleton == null) {
                    singleton = new ContextThreadExecutor(new TaskDecorator() {
                        @Override
                        public Runnable decorate(Runnable runnable) {
                            return null;
                        }
                    });
                }
            }
        }

        return singleton;
    }
}
