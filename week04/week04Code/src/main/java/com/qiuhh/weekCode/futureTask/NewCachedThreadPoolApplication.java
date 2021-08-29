package com.qiuhh.weekCode.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.qiuhh.weekCode.CallalbeImpl;

public class NewCachedThreadPoolApplication {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Integer> call = new CallalbeImpl();
		
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		 executor.submit(task);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			int	sum = task.get(1, TimeUnit.SECONDS);
			executor.shutdown();
			System.out.println("线程执行结果："+sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exit");
	}
	
	
	
}
