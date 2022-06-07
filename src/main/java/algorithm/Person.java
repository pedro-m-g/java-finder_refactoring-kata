package algorithm;

import java.util.Calendar;

public class Person {
	private Calendar birthDate;

	public Person(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Calendar birthDate() {
		return this.birthDate;
	}

}
