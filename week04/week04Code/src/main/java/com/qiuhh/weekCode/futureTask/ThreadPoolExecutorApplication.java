package com.qiuhh.weekCode.futureTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.qiuhh.weekCode.CallalbeImpl;
import com.qiuhh.weekCode.CustomThreadFactory;

public class ThreadPoolExecutorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callable<Integer> call = new  CallalbeImpl();
		ExecutorService executorService = initThreadPoolExecutor();
		FutureTask task = new FutureTask(call);
		
		executorService.submit(task);
		
		try {
			//Integer result = future.get();
			int	result =  (Integer) task.get(1, TimeUnit.SECONDS);
			System.out.println("执行结果==》"+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	
	public static ThreadPoolExecutor initThreadPoolExecutor() {
		int coreSize = Runtime.getRuntime().availableProcessors();
		int maxSize = Runtime.getRuntime().availableProcessors() * 2;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(500);
		CustomThreadFactory threadFactory = new CustomThreadFactory();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maxSize,
		1, TimeUnit.MINUTES, workQueue, threadFactory);
		return executor;
	}
}
