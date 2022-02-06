package com.junit5;

public class MathUtils {
	public int add(int a, int b) {
		return a+b;
	}
	public int subtract(int a, int b) {
		return a-b;
	}
	public int multiply(int a, int b) {
		return a*b;
	}
	public int division(int a, int b) {
		return a/b;
	}
	
	public double computeCirleArea(double radius) {
		return Math.PI * radius * radius;
	}
}
