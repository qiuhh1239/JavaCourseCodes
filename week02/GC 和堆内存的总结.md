## 串行GC(UseSerialGC)
三种GC方式


1. GC (Allocation Failure) DefNew 进行Young Generation，如果Young区空间不足，内存分配失败，对象会分配到老年代，查看日志进行了Tenured，也会进行老年代的回收
```

2021-08-15T13:13:38.046+0800: 0.405: [GC (Allocation Failure) 2021-08-15T13:13:38.046+0800: 0.405: [DefNew: 139776K->17472K(157248K), 0.0455740 secs] 139776K->43573K(506816K), 0.0457387 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 



2021-08-15T13:13:38.648+0800: 1.007: [GC (Allocation Failure) 2021-08-15T13:13:38.648+0800: 1.007: [DefNew: 157247K->157247K(157248K), 0.0000172 secs]
2021-08-15T13:13:38.648+0800: 1.007: [Tenured: 335480K->281491K(349568K), 0.0651386 secs] 492728K->281491K(506816K), [Metaspace: 2702K->2702K(1056768K)], 0.0655887 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 


```
2. Full GC (Metadata GC Threshold) Metaspace（元数据区）进行扩容。JDK8中，如果未设置-XX：MetaspaceSize=size -XX：MaxMetaspaceSize=size，Metaspace空间可以无限大，但是Metaspace有一个初始的阈值，大约20.8M ，这个是Metaspace扩容时触发FullGC的初始阈值
使用java -jar -XX:+UseSerialGC -Xms512m -Xmx512m -XX:-UseAdaptiveSizePolicy -Xloggc:gc.UseSerialGC.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar
sb -u http://localhost:8088/api/hello -c 20 -N 60
开始执行时，出现了两次Full GC (Metadata GC Threshold)，开始配置JVM时，需要配置-XX：MetaspaceSize=size
在串行GC中，非堆内存的扩容，也会造成GC暂停
```
2021-08-14T21:23:20.212+0800: 5.034: [Full GC (Metadata GC Threshold) 2021-08-14T21:23:20.212+0800: 5.034: [Tenured: 10049K->24504K(349568K), 0.1127763 secs] 128267K->24504K(506816K),
 [Metaspace: 33786K->33786K(1079296K)], 0.1128560 secs] [Times: user=0.28 sys=0.00, real=0.11 secs] 
```
3. Full GC (Allocation Failure) 进行老年代的回收
```
2021-08-14T21:30:26.134+0800: 0.385: [Full GC (Allocation Failure) 2021-08-14T21:30:26.134+0800: 0.385: [Tenured: 87362K->86973K(87424K), 0.0147479 secs] 126581K->105577K(126720K), [Metaspace: 2702K->2702K(1056768K)], 0.0148477 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
```




## 并行GC



1. GC (Allocation Failure)  PSYoungGen  进行Young Generation
```
2021-08-15T14:17:19.541+0800: 0.251: [GC (Allocation Failure) [PSYoungGen: 131500K->21498K(153088K)] 131500K->41691K(502784K), 0.0117325 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 
```
2. Full GC (Metadata GC Threshold) Metaspace（元数据区）进行扩容。JDK8中，
使用java -jar -XX:+UseParallelGC -Xms512m -Xmx512m -XX:-UseAdaptiveSizePolicy -Xloggc:gc.UseParallelGC.server.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar

sb -u http://localhost:8088/api/hello -c 20 -N 60
开始执行时，出现了两次Full GC (Metadata GC Threshold)，开始配置JVM时，需要配置-XX：MetaspaceSize=size 非堆内存的扩容，会造成GC暂停
```
2021-08-15T13:37:36.504+0800: 1.727: [Full GC (Metadata GC Threshold) [PSYoungGen: 11040K->0K(153088K)] [ParOldGen: 24K->10513K(349696K)] 11064K->10513K(502784K), [Metaspace: 20460K->20460K(1067008K)], 0.0288063 secs] [Times: user=0.08 sys=0.00, real=0.03 secs] 
```
3. Full GC (Ergonomics)  进行老年代的回收
```
2021-08-15T14:09:02.296+0800: 0.607: [Full GC (Ergonomics) [PSYoungGen: 21489K->0K(153088K)] [ParOldGen: 324119K->248819K(349696K)] 345608K->248819K(502784K), [Metaspace: 2702K->2702K(1056768K)], 0.0578698 secs] [Times: user=0.17 sys=0.01, real=0.06 secs] 
```


### CMS
1.年轻代回收  ParNew 回收
```

2021-08-15T15:33:03.777+0800: 2.110: [GC (Allocation Failure) 2021-08-15T15:33:03.777+0800: 2.110: [ParNew: 148193K->13660K(157248K), 0.0141405 secs] 148193K->13660K(506816K), 0.0142182 secs] [Times: user=0.03 sys=0.01, real=0.02 secs] 


```

2.老年代回收 两次GC暂停    GC (CMS Initial Mark) ，  GC (CMS Final Remark)
```
2021-08-15T15:33:03.792+0800: 2.125: [GC (CMS Initial Mark) [1 CMS-initial-mark: 0K(349568K)] 13660K(506816K), 0.0022888 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-08-15T15:33:03.794+0800: 2.127: [CMS-concurrent-mark-start]
2021-08-15T15:33:03.799+0800: 2.132: [CMS-concurrent-mark: 0.005/0.005 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-08-15T15:33:03.799+0800: 2.132: [CMS-concurrent-preclean-start]
2021-08-15T15:33:03.800+0800: 2.133: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-08-15T15:33:03.807+0800: 2.140: [GC (CMS Final Remark) [YG occupancy: 17224 K (157248 K)]2021-08-15T15:33:03.807+0800: 2.140: [Rescan (parallel) , 0.0030302 secs]2021-08-15T15:33:03.810+0800: 2.143: [weak refs processing, 0.0000221 secs]2021-08-15T15:33:03.810+0800: 2.143: [class unloading, 0.0041451 secs]2021-08-15T15:33:03.814+0800: 2.147: [scrub symbol table, 0.0037930 secs]2021-08-15T15:33:03.818+0800: 2.151: [scrub string table, 0.0003298 secs][1 CMS-remark: 0K(349568K)] 17224K(506816K), 0.0123195 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2021-08-15T15:33:03.821+0800: 2.154: [CMS-concurrent-sweep-start]
2021-08-15T15:33:03.821+0800: 2.154: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-08-15T15:33:03.821+0800: 2.154: [CMS-concurrent-reset-start]
2021-08-15T15:33:03.822+0800: 2.154: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
```

## G1
1、年轻代模式转移暂停（Evacuation Pause）
```
2021-08-15T15:56:28.156+0800: 0.181: [GC pause (G1 Evacuation Pause) (young) 33M->16M(512M), 0.0044696 secs]
```
2、Full GC
```

2021-08-15T16:21:47.981+0800: 0.399: [Full GC (Allocation Failure)  103M->100M(128M), 0.0138228 secs]


```
3、GC pause (G1 Humongous Allocation)
```

2021-08-15T15:56:28.552+0800: 0.577: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 250M->250M(512M), 0.0012676 secs]
2021-08-15T15:56:28.553+0800: 0.578: [GC concurrent-root-region-scan-start]
2021-08-15T15:56:28.554+0800: 0.579: [GC concurrent-root-region-scan-end, 0.0002369 secs]
2021-08-15T15:56:28.554+0800: 0.579: [GC concurrent-mark-start]
2021-08-15T15:56:28.558+0800: 0.583: [GC concurrent-mark-end, 0.0043633 secs]
2021-08-15T15:56:28.558+0800: 0.583: [GC remark, 0.0018985 secs]
2021-08-15T15:56:28.561+0800: 0.585: [GC cleanup 276M->275M(512M), 0.0008876 secs]
2021-08-15T15:56:28.561+0800: 0.586: [GC concurrent-cleanup-start]
2021-08-15T15:56:28.561+0800: 0.586: [GC concurrent-cleanup-end, 0.0000119 secs]


```

-Xms512m -Xmx512m

| GC | 吞吐量 | 请求数  |  平均响应时间| 最大响应时间 |
| --- | --- | --- | --- | --- |
| SerialGC | 2473.5 | 151501 |0.5ms  |290ms  | 
| ParallelGC | 2546.8 | 155633 |0.5ms  | 293ms | 
| CMS | 2403.1 |146990  |  0.7ms | 1166ms | 
| G1 | 2311.5 | 141467 | 0.6ms |528ms  |

配置512内存，进行压测，并行GC效率最高