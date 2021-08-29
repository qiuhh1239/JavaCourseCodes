package com.qiuhh.weekCode;

import java.util.concurrent.Callable;

public class CallalbeImpl implements Callable<Integer> {

	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return sum();
	}

	  private static int sum() {
	        return fibo(36);
	    }
	    
	    private static int fibo(int a) {
	        if ( a < 2) 
	            return 1;
	        return fibo(a-1) + fibo(a-2);
	    }
	
}
