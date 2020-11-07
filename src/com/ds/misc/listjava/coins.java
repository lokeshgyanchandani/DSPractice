package listjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class coins {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> preres = new ArrayList<String>();
        res.add("");

        for(int i=0;i<digits.length();i++){
            for(String str: res)
            {
                String letters = map.get(digits.charAt(i));
                for(int j=0;j<letters.length();j++)
                    preres.add(str+letters.charAt(j));
            }
            res = preres;
            preres = new ArrayList<String>();
        }      
        return res;
    }
        public static void main(String[] args){
        	coins c = new coins();
        	ArrayList<String> res1 = new ArrayList<String>();
        	res1 = c.letterCombinations("123");
        	for(String str1: res1)
                System.out.println(str1);
    }

    HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;
}


