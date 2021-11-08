package bytes.qhh.qmq.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

public final class Kmq {

	private MyQueue queue;
	
    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
     //  this.queue1 = new LinkedBlockingQueue(capacity);
        this.queue = new MyQueue(capacity);
    }

    private String topic;

    private int capacity;

    //private LinkedBlockingQueue<KmqMessage> queue1;

    public boolean send(KmqMessage message) {
        return queue.offer(message);
    }

    public KmqMessage poll() {
        return queue.poll();
    }

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

}
