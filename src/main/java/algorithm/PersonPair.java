package algorithm;

public class PersonPair {

	private Person younger;
	private Person older;
	private long ageDiff;

	public PersonPair(Person younger, Person older) {
		this.younger = younger;
		this.older = older;
		this.ageDiff = older.birthDate().getTimeInMillis()
			- younger.birthDate().getTimeInMillis();
	}

	public Person younger() {
		return this.younger;
	}

	public Person older() {
		return this.older;
	}

	public long ageDiff() {
		return this.ageDiff;
	}

	@Override
	public String toString() {
		return String.format(
			"(%s, %s)",
			this.younger.toString(),
			this.older.toString()
		);
	}

}
