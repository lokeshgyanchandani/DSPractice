package interview;

import java.util.Arrays;

public class JavaComparable implements Comparable<JavaComparable>{
	String firstName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String lastName;

	public static void main(String[] args) {
		JavaComparable p1 = new JavaComparable();
		p1.setFirstName("ashish");
		p1.setLastName("goel");

		JavaComparable p2 = new JavaComparable();
		p2.setFirstName("ashish");
		p2.setLastName("g");

		JavaComparable p3 = new JavaComparable();
		p3.setFirstName("ahish");
		p3.setLastName("g");
		JavaComparable[] x = new JavaComparable[3];
		x[0] = p1;
		x[1] = p2;
		x[2] = p3;

		Arrays.sort(x);
		for(int i=0;i<3;i++)
		{
			System.out.println(x[i].firstName);
			System.out.println(x[i].lastName);
		}
	}

	@Override
	public int compareTo(JavaComparable o) {
		if (this.firstName.equalsIgnoreCase(o.firstName)) {
			return (this.lastName.compareTo(o.lastName));
		}
		return (this.firstName.compareTo(o.firstName));
	}

}
