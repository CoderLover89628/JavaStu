package com.zs.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射
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
			// 通过调用Class的静态方法forName，获得类名对应的Class对象，相当于实例化一个Class对象
			Class c1 = Class.forName(name);
			
			// 获得Class对象的超类
			Class superC1 = c1.getSuperclass();
			
			// 获得Class对象的修饰，即该类的修饰器是什么：e.g. public 还是 public static
			// 此处modifiers = public,即，该类是公共类
			String modifiers = Modifier.toString(c1.getModifiers());
			if(modifiers.length() > 0) System.out.print("modifiers are :" + modifiers + " ");
			System.out.print("class " + name);
			// 如果存在父类，则拼接上
			if(superC1 != null && superC1 != Object.class) System.out.print(" extends" + superC1.getName());
			System.out.println("\n{\n");
			
			// 获得该对象的构造器
			printConstructors(c1);
			System.out.println();
			
			// 获得该对象的方法
			printMethods(c1);
			System.out.println();
			
			//获得该对象的域
			printFields(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印该对象拥有的域
	 * 说明:
	 * Class类中getFields()和getDeclaredFields()的区别
	 * getFields():返回该类提供的public域，包括超类的公有成员
	 * getDeclaredFields():返回该类声明的全部域，包含受保护和私有成员，但不包括超类成员
	 * 
	 * @param c1
	 */
	private static void printFields(Class c1) {

		Field[] fields = c1.getDeclaredFields();
		for(Field f : fields) {
			Class type = f.getType();// 获得属性类型，例，int ,long ,double ....
			String name = f.getName();// 获得属性名
			System.out.print(" ");
			// 获得域的修饰，此处多为：private static final
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}

	/**
	 * 打印该对象拥有的方法
	 * 说明：
	 * Class类中getMethods()和getDeclaredMethods()的区别
	 * getMethods():返回该类提供的public方法，包括超类的public方法
	 * getDeclaredMethods():返回该类声明的全部方法，包含受保护和私有方法，但不包括超类方法
	 * 
	 * @param c1
	 */
	private static void printMethods(Class c1) {

		Method[] methods = c1.getDeclaredMethods();
		for(Method m : methods) {
			Class retType = m.getReturnType();// 获得方法的返回类型 
			String name = m.getName();// 获得方法名字，例toString()、equal()、clone()
			
			System.out.print(" ");
			
			// 获得方法的修饰，即， 是公共方法还是私有方法，对应的是public和private
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.print(retType.getName() + " " +name + "(");
			
			Class[] paramTypes = m.getParameterTypes();// 获得方法参数的类型
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());// 获得参数类型的名字
			}
			
			System.out.println(");");
		}
	}

	private ReflectionTest() {}
	
	/**
	 * 打印该对象拥有的构造器
	 * 说明：
	 * Class类中getConstructors()和getDeclaredConstructors()的区别
	 * getConstructors():返回该类提供的public构造器，包括超类的public构造器
	 * getDeclaredConstructors():返回该类声明的全部构造器，包含受保护和私有构造器，但不包括超类构造器
	 * @param c1
	 */
	private static void printConstructors(Class c1) {

		Constructor[] constructor = c1.getDeclaredConstructors();
		for(Constructor c : constructor) {
			String name = c.getName();// 获得构造器方法名
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) System.out.println(modifiers + " ");
			System.out.print(name + "(");
			
			Class[] paramTypes = c.getParameterTypes();// 构造器方法参数类型
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());// 类型名
			}
			
			System.out.println(");");
		}
	}

}
