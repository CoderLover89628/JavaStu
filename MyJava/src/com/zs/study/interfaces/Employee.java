package com.zs.study.interfaces;

public class Employee implements Comparable<Employee>{

	private String name;
	private double salary;
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Employee() {
		
	}
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.salary);
	}

}
