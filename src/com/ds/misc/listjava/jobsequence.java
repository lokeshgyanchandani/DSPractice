package listjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class job
{
	char name;
	int profit;
	int deadline;
	
	job(char name,int profit,int deadline)
	{
		this.name= name;
		this.profit = profit;
		this.deadline = deadline;
	}
}
class clcomparator implements Comparator<job>{
	
		 public int compare(job j1, job j2) {
		 return(j2.profit - j1.profit);
		
		 }

}
public class jobsequence {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<job> list = new ArrayList<job>();
		list.add(new job('a',100,2));
		list.add(new job('b',19,1));
		list.add(new job('c',27,2));
		list.add(new job('d',25,1));
		list.add(new job('e',15,3));
		
		Collections.sort(list,new clcomparator());
		for(job j : list)
		{
			System.out.println(j.name + " "+j.deadline+" "+j.profit);
		}
		
		char[] result = new char[5];
		boolean[] b = new boolean[5];
		for(boolean s:b)
		{
			s= false;
		}
		
		for(job j : list)
		{
			for(int i =j.deadline-1;i>=0;i--)
			{
				if (b[i]==false)
						{
						result[i] = j.name;	
						b[i]= true;
						break;
						}
			}
		}
		for(int i=0;i<5;i++)
		{
			if (b[i]==true)
			{
				System.out.println(result[i]);
			}
		}
		
		
	}

}
