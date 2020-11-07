package listjava;

public class divide {

public static void main(String args[])
{
int x = dividek(23,43);
System.out.println(x);
}
public static int dividek(int a, int b) {
	int result=0;
	int rem =0;
	while (a >= 0) {
		if(a<b)
		{
			rem = a;
			break;
		}
        a -= b;
        result++;
    }
	System.out.println(rem);
	return result;
}
}