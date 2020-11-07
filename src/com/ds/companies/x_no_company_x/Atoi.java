package com.ds.companies.x_no_company_x;

public class Atoi {

    public static void main(String[] args) {
        String x = "12345";
        int sum = 0;
        for (int i = 0; i < x.length(); i++) {
            int a = x.charAt(i) - '0';
            sum = sum * 10 + a;
        }
        System.out.println(sum);
        System.out.println(Integer.parseInt(x));
    }

}
