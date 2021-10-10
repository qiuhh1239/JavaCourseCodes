package io.qhh.rpcfx.api;

public interface RpcfxResolver {

    Object resolve(String serviceClass);

	<T> T resolveClass(Class<T> clazz);
}
