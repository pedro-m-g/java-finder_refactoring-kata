package algorithm;

public class PersonPair {

	private Person younger;
	private Person older;
	private long ageDiff;

	public static PersonPair create(Person younger, Person older) {
		PersonPair personPair = new PersonPair();
		personPair.younger(younger);
		personPair.older(older);
		personPair.ageDiff(older.birthDate().getTimeInMillis()
				- younger.birthDate().getTimeInMillis());
		return personPair;
	}

	public Person younger() {
		return this.younger;
	}

	public void younger(Person younger) {
		this.younger = younger;
	}

	public Person older() {
		return this.older;
	}

	public void older(Person older) {
		this.older = older;
	}

	public long ageDiff() {
		return this.ageDiff;
	}

	public void ageDiff(long ageDiff) {
		this.ageDiff = ageDiff;
	}

}
