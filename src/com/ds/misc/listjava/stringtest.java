package listjava;

public class stringtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = "defg";
		String s = mixString(a,b);
		System.out.println(s);
	}
		
		public static String mixString(String a, String b) {
			 
			    if(a.isEmpty())
			    return b;
			    else if(b.isEmpty()) 
			    return a ;
			    else
			    return
			    a.substring(0, 1) + b.substring(0, 1)
			      + mixString(a.substring(1), b.substring(1));
			}


}
