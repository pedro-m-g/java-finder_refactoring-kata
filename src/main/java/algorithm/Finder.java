package algorithm;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		if (people.isEmpty())
			return Collections.emptyList();

		List<Person> firstElements = people.subList(0, people.size() - 1);
		List<Person> secondElements = people.subList(1, people.size());

		return firstElements.stream()
			.flatMap(firstPerson ->
				secondElements.stream()
					.filter(secondPerson ->
						people.indexOf(secondPerson) > people.indexOf(firstPerson))
					.map(secondPerson ->
						firstPerson.compareTo(secondPerson) < 0
							? new PersonPair(firstPerson, secondPerson)
							: new PersonPair(secondPerson, firstPerson))
			).collect(Collectors.toList());
	}
}
