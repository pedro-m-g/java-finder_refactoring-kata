package algorithm;

import java.util.Calendar;

public class Person implements Comparable<Person> {

	private String name;
	private Calendar birthDate;

	public Person(String name, Calendar birthDate) {
		this.name = name;
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

	@Override
	public String toString() {
		return this.name;
	}

}
