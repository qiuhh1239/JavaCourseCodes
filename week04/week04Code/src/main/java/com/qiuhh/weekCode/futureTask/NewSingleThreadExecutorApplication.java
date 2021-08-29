package com.qiuhh.weekCode.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.qiuhh.weekCode.CallalbeImpl;

public class NewSingleThreadExecutorApplication {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Callable<Integer> call = new CallalbeImpl();
		
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		
		executor.submit(task);
		
		try {
			
			int	sum = task.get();
			System.out.println("线程执行结果："+sum);
			executor.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("exit");
	}
	
	
	
}
