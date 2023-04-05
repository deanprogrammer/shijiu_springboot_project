package com.shijiu.sync;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract interface IExecutor extends Executor {

    public abstract <T> Future<T> submit(Callable<T> paramCallable);

    public abstract <T> List<Future<T>> submitAll(Collection<? extends Callable<T>> paramCollection);

    public abstract <T> List<Future<T>> submitAll(Collection<? extends Callable<T>> paramCollection, long paramLong);
}
