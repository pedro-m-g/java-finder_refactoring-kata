package algorithm;

import java.util.Calendar;

public class Person {
	public String name;
	public Calendar birthDate;

	public Person(String name, Calendar birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
}
