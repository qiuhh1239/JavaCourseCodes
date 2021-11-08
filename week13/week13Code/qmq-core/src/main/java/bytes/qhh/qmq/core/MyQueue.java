package bytes.qhh.qmq.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyQueue {

	//容量
	private int capacity = -1;
	//保存信息
	private KmqMessage[] message;
	
	private int rigthIndex = 0; //最后一位
	private int leftIndex = -1; //消费位置
	public MyQueue(int capacity) {
		super();
		this.capacity = capacity;
		this.message = new KmqMessage[capacity];
	}

	public boolean offer(KmqMessage e) {
	
		rigthIndex ++;
		message[rigthIndex] = e ;
		
		return true;
	}
	
	public KmqMessage poll() {
		leftIndex ++;
		return message[leftIndex];
	}
	
	public KmqMessage poll(long timeout, TimeUnit unit) {
		leftIndex ++;
		return message[leftIndex];
	}
}
