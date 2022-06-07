package algorithm;

import java.util.Calendar;

public class Person {
	private String name;
	private Calendar birthDate;

	public Person(String name, Calendar birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public Calendar birthDate() {
		return this.birthDate;
	}

}
