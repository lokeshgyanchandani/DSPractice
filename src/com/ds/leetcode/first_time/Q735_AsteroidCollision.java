package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.Stack;

public class Q735_AsteroidCollision {

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid: asteroids) {
			stack.push(asteroid);
			while (!stack.isEmpty() && stack.size() >= 2 && stack.peek() < 0) {
				int first = stack.pop();
				if (first < 0 && !stack.isEmpty() && stack.peek() > 0) {
					int second = stack.pop();
					if (first + second == 0) continue;
					int max = Math.abs(first) > Math.abs(second) ? first : second;
					stack.push(max);
				} else
					stack.push(first);
			}
		}
		return stack.isEmpty() ? new int[]{} : stack.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] asteroids = new int[] {-2,-1,1,2};
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}
}
