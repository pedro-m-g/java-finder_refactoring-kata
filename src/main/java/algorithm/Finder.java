package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public PersonPair Find(FT ft) {
		List<PersonPair> peopleSetProduct = peopleSetProduct();

		if (peopleSetProduct.isEmpty()) {
			return new PersonPair();
		}

		PersonPair answer = peopleSetProduct.get(0);
		for (PersonPair result : peopleSetProduct) {
			switch (ft) {
				case One:
					if (result.ageDiff() < answer.ageDiff()) {
						answer = result;
					}
					break;

				case Two:
					if (result.ageDiff() > answer.ageDiff()) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}

	private List<PersonPair> peopleSetProduct() {
		List<PersonPair> tr = new ArrayList<PersonPair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				PersonPair personPair = new PersonPair();
				Person person1 = people.get(i);
				Person person2 = people.get(j);
				if (person1.compareTo(person2) < 0) {
					personPair.younger(person1);
					personPair.older(person2);
				} else {
					personPair.younger(person2);
					personPair.older(person1);
				}
				personPair.ageDiff(personPair.older().birthDate().getTimeInMillis()
						- personPair.younger().birthDate().getTimeInMillis());
				tr.add(personPair);
			}
		}
		return tr;
	}
}
