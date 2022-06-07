package algorithm;

import java.util.Calendar;

public class Person implements Comparable<Person> {

	private Calendar birthDate;

	public Person(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Calendar birthDate() {
		return this.birthDate;
	}

	@Override
	public int compareTo(Person other) {
		return Long.compare(
			this.birthDate().getTimeInMillis(),
			other.birthDate().getTimeInMillis()
		);
	}

}
