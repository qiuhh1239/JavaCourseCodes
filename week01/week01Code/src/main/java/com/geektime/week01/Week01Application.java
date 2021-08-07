package com.geektime.week01;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;


public class Week01Application extends ClassLoader {

	public static void main(String[] args) throws Exception {
		
		 // 相关参数
        final String className = "Hello";
        final String methodName = "hello";
        
        // 创建类加载器
        Week01Application classLoader = new Week01Application();
        
        // 加载相应的类
        Class<?> clazz = classLoader.loadClass(className);
        // 看看里面有些什么方法
        for (Method m : clazz.getDeclaredMethods()) {
            if(m.getName().equals(methodName)) {
            	   // 创建对象
                Object instance = clazz.newInstance();
                // 调用实例方法
                Method method = clazz.getMethod(methodName);
                method.invoke(instance);
                break;
            }
        }
     
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		String xlassPath = "/Hello.xlass";
		byte[] bytes = decode(xlassPath);
		return defineClass(name,bytes,0,bytes.length);
	}
	
	/**
	 * 获取文件二进制编码，并解码
	 * @param classPath
	 * @return
	 */
	private byte[] decode(String classPath) {
		 InputStream inputStream = Object.class.getResourceAsStream(classPath);
		 int len = 0;
		 byte[] btArray = null;
		try {
			len = inputStream.available();
			btArray = new byte[len];
			inputStream.read(btArray);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 if(btArray == null) {
			 return null;
		 }
		 for(int i=0;i<len;i++) {
			 btArray[i] = (byte) (255 -  btArray[i]);
		 }
		 
		return btArray;
	}
}
