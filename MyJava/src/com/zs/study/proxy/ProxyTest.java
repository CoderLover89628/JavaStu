package com.zs.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Object[] elements = new Object[100];
		
		for(int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			/**
			 * 参数说明：
			 * new Class[]{Comparable.class}:代理Comparable对象
			 * handler:包装实际的对象
			 */
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		Integer key = new Random().nextInt(elements.length) + 1;// 从elements数组长度+1 随机一个int类型的数字
		System.out.println("key is:" + key);
		
		for(int j = 0; j < elements.length; j++)
		{
			System.out.println(elements[j]);
		}
		
		int result = Arrays.binarySearch(elements, key);
		System.out.println(elements[result]);
		if(result >= 0) System.out.println(elements[result]);
	}

}

class TraceHandler implements InvocationHandler {

	private Object target;
	
	public TraceHandler(Object t){
		target = t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.print(target);
		System.out.print("." + method.getName() + "(");
		
		if(args != null)
		{
			for(int i = 0; i < args.length; i++)
			{
				System.out.print(args[i]);
				if(i < args.length - 1) System.out.print(", ");
			}
		}
		
		System.out.print(")");
		return method.invoke(target, args);
	}
	
}
