package com.zs.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * ����
 * 
 * @author JZ
 *
 */
public class ReflectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name; 
		if(args.length > 0) name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter a class name(e.g. java.util.Date):");
			name = in.next();
		}
		
		try {
			// ͨ������Class�ľ�̬����forName�����������Ӧ��Class�����൱��ʵ����һ��Class����
			Class c1 = Class.forName(name);
			
			// ���Class����ĳ���
			Class superC1 = c1.getSuperclass();
			
			// ���Class��������Σ����������������ʲô��e.g. public ���� public static
			// �˴�modifiers = public,���������ǹ�����
			String modifiers = Modifier.toString(c1.getModifiers());
			if(modifiers.length() > 0) System.out.print("modifiers are :" + modifiers + " ");
			System.out.print("class " + name);
			// ������ڸ��࣬��ƴ����
			if(superC1 != null && superC1 != Object.class) System.out.print(" extends" + superC1.getName());
			System.out.println("\n{\n");
			
			// ��øö���Ĺ�����
			printConstructors(c1);
			System.out.println();
			
			// ��øö���ķ���
			printMethods(c1);
			System.out.println();
			
			//��øö������
			printFields(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ӡ�ö���ӵ�е���
	 * ˵��:
	 * Class����getFields()��getDeclaredFields()������
	 * getFields():���ظ����ṩ��public�򣬰�������Ĺ��г�Ա
	 * getDeclaredFields():���ظ���������ȫ���򣬰����ܱ�����˽�г�Ա���������������Ա
	 * 
	 * @param c1
	 */
	private static void printFields(Class c1) {

		Field[] fields = c1.getDeclaredFields();
		for(Field f : fields) {
			Class type = f.getType();// ����������ͣ�����int ,long ,double ....
			String name = f.getName();// ���������
			System.out.print(" ");
			// ���������Σ��˴���Ϊ��private static final
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}

	/**
	 * ��ӡ�ö���ӵ�еķ���
	 * ˵����
	 * Class����getMethods()��getDeclaredMethods()������
	 * getMethods():���ظ����ṩ��public���������������public����
	 * getDeclaredMethods():���ظ���������ȫ�������������ܱ�����˽�з����������������෽��
	 * 
	 * @param c1
	 */
	private static void printMethods(Class c1) {

		Method[] methods = c1.getDeclaredMethods();
		for(Method m : methods) {
			Class retType = m.getReturnType();// ��÷����ķ������� 
			String name = m.getName();// ��÷������֣���toString()��equal()��clone()
			
			System.out.print(" ");
			
			// ��÷��������Σ����� �ǹ�����������˽�з�������Ӧ����public��private
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.print(retType.getName() + " " +name + "(");
			
			Class[] paramTypes = m.getParameterTypes();// ��÷�������������
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());// ��ò������͵�����
			}
			
			System.out.println(");");
		}
	}

	private ReflectionTest() {}
	
	/**
	 * ��ӡ�ö���ӵ�еĹ�����
	 * ˵����
	 * Class����getConstructors()��getDeclaredConstructors()������
	 * getConstructors():���ظ����ṩ��public�����������������public������
	 * getDeclaredConstructors():���ظ���������ȫ���������������ܱ�����˽�й������������������๹����
	 * @param c1
	 */
	private static void printConstructors(Class c1) {

		Constructor[] constructor = c1.getDeclaredConstructors();
		for(Constructor c : constructor) {
			String name = c.getName();// ��ù�����������
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.print(name + "(");
			
			Class[] paramTypes = c.getParameterTypes();// ������������������
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());// ������
			}
			
			System.out.println(");");
		}
	}

}
