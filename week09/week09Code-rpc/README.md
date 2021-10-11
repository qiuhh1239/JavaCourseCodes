注意：  
config-sharding.yaml 配置  
dataSourceCommon，password 后加密码，密码前需要有空格  

必做题 3 改造自定义 RPC 的程序，提交到 GitHub：

1、尝试将服务端写死查找接口实现类变成泛型和反射;  
[RpcfxServerApplication.java](rpcfx-demo-provider/src/main/java/io/qhh/rpcfx/demo/provider/RpcfxServerApplication.java)@Bean去掉了name  
[RpcfxResolver.java](rpcfx-core/src/main/java/io/qhh/rpcfx/api/RpcfxResolver.java)增加了新接口
<T> T resolveClass(Class<T> clazz);  
[RpcfxInvoker.java](rpcfx-core/src/main/java/io/qhh/rpcfx/server/RpcfxInvoker.java)调用resolveClass

2、尝试将客户端动态代理改成 AOP，添加异常处理；
[Rpcfx.java](rpcfx-core/src/main/java/io/qhh/rpcfx/client/Rpcfx.java)修改了create方法

3、尝试使用 Netty+HTTP 作为 client 端传输方式。



