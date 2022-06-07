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

		if (peopleSetProduct.size() < 1) {
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
				if (people.get(i).birthDate().getTimeInMillis() < people.get(j).birthDate().getTimeInMillis()) {
					r.P1 = people.get(i);
					r.P2 = people.get(j);
				} else {
					r.P1 = people.get(j);
					r.P2 = people.get(i);
				}
				r.D = r.P2.birthDate().getTimeInMillis() - r.P1.birthDate().getTimeInMillis();
				tr.add(r);
			}
		}
		return tr;
	}
}
