package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
     int start;
     int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class FruitNameComparatorSol {
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new FruitNameComparator());
//        for(Interval interval:intervals)
//        {
//        System.out.println(interval.start);
//        System.out.println(interval.end);
//        }
        List<Interval> result = new ArrayList<>();
        int j =0 ;

        for(int i =j+1;i<intervals.size();i++)
        {
        	if( intervals.get(i).start<=intervals.get(i-1).end)
        	{
        		continue;
        	}
        	else
        	{
        		Interval x = new Interval();
        		x.start=intervals.get(j).start;
        		x.end=intervals.get(i-1).end;
        		result.add(x);
        		j =i;
        	}
        }
        Interval x = new Interval();
		x.start=intervals.get(j).start;
		x.end=intervals.get(intervals.size()-1).end;
		result.add(x);

        for(Interval interval:result)
        {
        System.out.println(interval.start);
        System.out.println(interval.end);
        }
        return intervals;
    }

    public static void main(String[] args) {
    	List<Interval> intervals=new ArrayList<Interval>();
    	Interval interval1 = new Interval(1,3);
    	Interval interval2 = new Interval(8,10);
    	Interval interval3 = new Interval(2,6);
    	Interval interval4 = new Interval(15,18);
    	intervals.add(interval1);
    	intervals.add(interval2);
    	intervals.add(interval3);
    	intervals.add(interval4);
    	merge(intervals);
    }
}

class FruitNameComparator implements Comparator<Interval>
                          {

	    public int compare(Interval fruit1, Interval fruit2) {


	      if(fruit1.start==fruit2.start)
	         return fruit1.end - fruit2.end;
	      else
	         return fruit1.start - fruit2.start;
	    }

	}