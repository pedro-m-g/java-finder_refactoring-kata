package algorithm;

public class PersonPair {

	private Person younger;
	private Person older;
	public long ageDiff;

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

}
