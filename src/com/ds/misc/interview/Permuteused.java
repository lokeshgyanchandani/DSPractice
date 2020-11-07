package interview;

import java.util.ArrayList;
import java.util.List;

public class Permuteused {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
	        List<Integer> temp = new ArrayList<>();
	      
	        helper(0,list,temp,nums);
	        System.out.println(list);
			return list;
	    }
	    
	    public void helper(int index,List<List<Integer>> list,List<Integer> temp,int[] nums)
	    {
	        if(temp.size()==nums.length)
	        {
	            list.add(new ArrayList<Integer>(temp));
	            return;
	        }
	        
	        for(int i =index ;i<nums.length;i++)
	        {
	            temp.add(nums[index]);
	            helper(index+1,list,temp,nums);
	            temp.remove(temp.size()-1);
	        }
	    }
	    public static void main(String args[])
	    {
	    	Permuteused x = new Permuteused();
	    	int[] nums = {1,2,3};
	    	x.permute(nums);
	    }
}
