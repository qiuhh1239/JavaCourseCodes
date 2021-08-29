package com.qiuhh.weekCode.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.qiuhh.weekCode.CallalbeImpl;

public class NewScheduledThreadPoolApplication {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newScheduledThreadPool(0);
		Callable<Integer> call = new CallalbeImpl();
		
		Future<Integer> task = executor.submit(call);
		
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
