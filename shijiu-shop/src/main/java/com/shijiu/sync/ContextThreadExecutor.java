package com.shijiu.sync;

import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ContextThreadExecutor implements IExecutor{
    protected static int maxThreads = 200;
    protected static int minSpareThreads = 25;
    protected static int maxIdleTime = '';
    protected static int maxQueues = 400;
    private static ThreadPoolTaskExecutor excutorService = null;

    protected ContextThreadExecutor(TaskDecorator taskDecorator) {
        this.init(taskDecorator);
    }

    private void init(TaskDecorator taskDecorator) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(minSpareThreads);
        threadPoolTaskExecutor.setMaxPoolSize(maxThreads);
        threadPoolTaskExecutor.setKeepAliveSeconds(maxIdleTime / 1000);
        threadPoolTaskExecutor.setQueueCapacity(maxQueues);
        threadPoolTaskExecutor.setThreadFactory(Executors.defaultThreadFactory());
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setTaskDecorator(taskDecorator);
        threadPoolTaskExecutor.initialize();
        excutorService = threadPoolTaskExecutor;
    }

    public void execute(Runnable command) {
        excutorService.execute(command);
    }

    public <T> Future<T> submit(Callable<T> task) {
        return excutorService.submit(task);
    }

    public <T> List<Future<T>> submitAll(Collection<? extends Callable<T>> tasks) {
        return this.submitAll(tasks, 0L);
    }

    public <T> List<Future<T>> submitAll(Collection<? extends Callable<T>> tasks, long interval) {
        if (tasks == null) {
            throw new NullPointerException();
        } else {
            ArrayList futures = new ArrayList(tasks.size());
            Iterator arg4 = tasks.iterator();

            while (arg4.hasNext()) {
                Callable t = (Callable) arg4.next();
                Future f = this.submit(t);
                futures.add(f);
                if (interval > 0L) {
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException arg8) {
                        arg8.printStackTrace();
                    }
                }
            }

            return futures;
        }
    }
}
