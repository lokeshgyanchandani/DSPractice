package interview;

import java.util.ArrayList;
import java.util.Comparator;

class IntComparator implements Comparator<person> {

	@Override
	public int compare(person o1, person o2) {

		if (o1.firstName.compareTo(o2.firstName) == 0) {
			return (o1.lastName.compareTo(o2.lastName));
		}
		return o1.firstName.compareTo(o2.firstName);
	}

}

class person {
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

}

public class JavaComparator {

	public static void main(String[] args) {

		person p1 = new person();
		p1.setFirstName("ashish");
		p1.setLastName("goel");

		person p2 = new person();
		p2.setFirstName("ashish");
		p2.setLastName("g");

		person p3 = new person();
		p3.setFirstName("ahish");
		p3.setLastName("g");

		ArrayList<person> x = new ArrayList<person>();
		x.add(p1);
		x.add(p2);
		x.add(p3);
		x.sort(new IntComparator());
		for(person p:x)
		{
		System.out.println(p.firstName);
		System.out.println(p.lastName);
		}

	}
}