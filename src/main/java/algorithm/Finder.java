package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<PersonPair> closestAgeDiff() {
		return peopleSetProduct()
			.stream()
			.min((personPair1, personPair2) ->
				Long.compare(personPair1.ageDiff(), personPair2.ageDiff()));
	}

	public Optional<PersonPair> furthestAgeDiff() {
		return peopleSetProduct()
			.stream()
			.max((personPair1, personPair2) ->
				Long.compare(personPair1.ageDiff(), personPair2.ageDiff()));
	}

	private List<PersonPair> peopleSetProduct() {
		List<PersonPair> peopleSetProduct = new ArrayList<PersonPair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Person person1 = people.get(i);
				Person person2 = people.get(j);
				PersonPair personPair = person1.compareTo(person2) < 0
					? new PersonPair(person1, person2)
					: new PersonPair(person2, person1);
				peopleSetProduct.add(personPair);
			}
		}
		return peopleSetProduct;
	}
}
