package listjava;
class node {
 int value;
 node next;
   public node(int data)
	{
	this.value = data;
	}
    public node(int data , node next)
    {
	this.value = data;
	this.next = next;
    }
}



public class list1
{
public static void main(String[] args)
{

	node start1 = new node(1);
	node temp = start1;
	int x= 1;
	while(x<5)
	{
		temp.next = new node(x*2);
		temp = temp.next;
		x=x+1;
	}
	temp = start1;
	while(temp!= null)
	{
	   System.out.print(temp.value);
	   System.out.print("->");
	   temp=temp.next;
	}
	
	System.out.print("null");
    System.out.println("");
	node start2 = new node(1);
	temp = start2;
	x= 1;
	while(x<5)
	{
		temp.next = new node(x*3);
		temp = temp.next;
		x=x+1;
	}
	temp = start2;
	while(temp!= null)
	{
	   System.out.print(temp.value);
	   System.out.print("->");
	   temp=temp.next;
	}
	System.out.print("null");
	
	node temp1 = start1;
	node temp2 =start2;
	node temp3 = null;
	node start3 = null;
	temp=null;
	while((temp1!=null)&&(temp2!= null))
	{
		if(temp1.value < temp2.value)
		{
			temp = temp1;
			temp1 = temp1.next;
		}
		else
		{
			temp= temp2;
		    temp2 = temp2.next;
		}
		if (start3 == null)
				{
					start3 = temp;
					temp3 = temp;
				}
		else 
			{
			temp3.next = temp;
			temp3 = temp3.next;
			}
	}
	if (temp1==null)
	{
		while(temp2!=null)
		{
			temp = temp2;
			temp2 = temp2.next;
			if (start3 == null)
			{
				start3 = temp;
				temp3 = temp;	
				}
	        else
	        	{temp3.next = temp;
			     temp3 = temp3.next;}
		}
	}
	if(temp2==null)
	{
		while(temp1!=null)
		{
			temp = temp1;
			temp1=temp1.next;
			if (start3 == null)
			{
				start3 = temp;
				temp3 = temp;
			}
	     else temp3.next=temp;
		}
	}
	
/*	node prev= null;
	node current = start; 
	
	while(current!= null)
	{
		temp = current.next;
		current.next = prev;
		prev=current;
		current = temp;
	}
	start = prev;*/
	temp = start3;
	while(temp!= null)
	{
	   System.out.print(temp.value);
	   System.out.print("->");
	   temp=temp.next;
	}
	
	System.out.print("null");


	
	 
}
}
