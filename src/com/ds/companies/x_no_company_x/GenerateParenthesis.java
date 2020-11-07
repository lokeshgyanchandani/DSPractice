package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		char[] count = new char[6];
		helper("abc",new ArrayList<Character>(),0);

	}

	private static void helper(String str, List<Character> list, int index) {
//		if(leftrem <0 ||rightrem < leftrem)
//		{
//			return;
//		}
//		if(leftrem==0 && rightrem==0)
//		{
//			System.out.println(String.copyValueOf(count));
//		}
//		else
//		{
//			if(leftrem>0)
//			{
//				count[index]='(';
//				helper(leftrem-1,rightrem,count,index+1);
//			}
//			if(rightrem > leftrem)
//			{
//				count[index]=')';
//				helper(leftrem,rightrem-1,count,index+1);
//			}
//		}
//		if(list.size()==3)
//		{


			System.out.println(list);
//		}
//		else{
			for(int i =index;i<str.length();i++)
			{
//				if(list.contains(str.charAt(i)))
//					continue;
				list.add(str.charAt(i));
				helper(str,list,i+1);
				list.remove(list.size()-1);
//			}
		}
	}

}
