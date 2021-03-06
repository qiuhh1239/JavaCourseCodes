package com.qiuhh.weekCode;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactory implements ThreadFactory {

	private AtomicInteger serial = new AtomicInteger(0);
	public Thread newThread(Runnable r) {
	Thread thread = new Thread(r);
	thread.setDaemon(true); // 根据需要，设置守护线程
	thread.setName("CustomeThread-" + serial.getAndIncrement());
	return thread;
	}
}
