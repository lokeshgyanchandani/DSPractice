package listjava;

import java.util.HashMap;
import java.util.Set;

class data
{
	int count;
	int index;
}
public class firstuniquearray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={1,3,3,3,4,4,1,3,4};
		HashMap<Integer,data> h = new HashMap<Integer,data>();
		for(int i=0;i<a.length;i++)
		{
			if(h.containsKey(a[i]))
			{
				data d = h.get(a[i]);
				d.count = d.count+1;
				h.put(a[i], d);
			}
			else
			{
				data d1 = new data();
				d1.count = 1;
				d1.index = i;
				h.put(a[i], d1);
			}
		}
		Set<Integer> s = h.keySet();
		for(Integer k : s)
			if(h.get(k).count==1)
			{
				System.out.println(k + " " +h.get(k).index);
				return;
			}
			System.out.println(" no unique element");
	}

}
