package io.qhh.rpcfx.demo.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import io.qhh.rpcfx.api.RpcfxResolver;

public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }
    
	@Override
    public <T> T resolveClass(Class<T> clazz) {
        return this.applicationContext.getBean(clazz);
    }
}
