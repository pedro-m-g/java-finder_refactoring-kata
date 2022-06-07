package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public F Find(FT ft) {
		List<F> peopleSetProduct = peopleSetProduct();

		if (peopleSetProduct.isEmpty()) {
			return new F();
		}

		F answer = peopleSetProduct.get(0);
		for (F result : peopleSetProduct) {
			switch (ft) {
				case One:
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two:
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}

	private List<F> peopleSetProduct() {
		List<F> tr = new ArrayList<F>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				F r = new F();
				Person person1 = people.get(i);
				Person person2 = people.get(j);
				if (person1.compareTo(person2) < 0) {
					r.P1 = person1;
					r.P2 = person2;
				} else {
					r.P1 = person2;
					r.P2 = person1;
				}
				r.D = r.P2.birthDate().getTimeInMillis() - r.P1.birthDate().getTimeInMillis();
				tr.add(r);
			}
		}
		return tr;
	}
}
