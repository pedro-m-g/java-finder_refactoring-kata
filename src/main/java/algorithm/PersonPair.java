package algorithm;

public class PersonPair {

	private Person younger;
	public Person older;
	public long ageDiff;

	public Person younger() {
		return this.younger;
	}

	public void younger(Person younger) {
		this.younger = younger;
	}

}
