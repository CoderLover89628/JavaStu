package com.zs.study.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TestHello implements TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(url);

		//HashMap�Ǹ���ɢ��ֵ�ֶδ洢�ģ�ͬ��Map��ͬ����ʱ����ס�����еĶΣ���ConcurrentHashMap������ʱ�����ɢ��ֵ��ס��ɢ��ֵ����Ӧ���ǶΣ��������˲������ܡ�
		//ConcurrentHashMapҲ�����˶Գ��ø��ϲ�����֧�֣�����"��û�������"��putIfAbsent()���滻��replace()����2����������ԭ�Ӳ�����
		Map<Object, Object> s = new ConcurrentHashMap<Object, Object>(new HashMap<Object, Object>());
	}

}
