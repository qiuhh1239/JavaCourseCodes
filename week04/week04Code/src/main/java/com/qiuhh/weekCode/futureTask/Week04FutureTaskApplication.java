package com.qiuhh.weekCode.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.qiuhh.weekCode.CallalbeImpl;

public class Week04FutureTaskApplication {

	public static void main(String[] args) {
		
		Callable<Integer> call = new CallalbeImpl();
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		Thread thread = new Thread(task);
		
		thread.start();
		
		try {
			int sum = task.get();
			System.out.println("线程执行结果："+sum);
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
