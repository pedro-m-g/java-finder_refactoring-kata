package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import algorithm.PersonPair;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	Person sue;
	Person greg;
	Person sarah;
	Person mike;

	@Before
	public void setup() {
		sue = new Person("Sue", new GregorianCalendar(1950, 0, 1));
		greg = new Person("Greg", new GregorianCalendar(1952, 5, 1));
		sarah = new Person("Sarah", new GregorianCalendar(1982, 0, 1));
		mike = new Person("Mike", new GregorianCalendar(1979, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		Optional<PersonPair> result = finder.closestAgeDiff();
		assertEquals(true, result.isEmpty());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		Optional<PersonPair> result = finder.closestAgeDiff();

		assertEquals(true, result.isEmpty());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonPair result = finder.closestAgeDiff().get();

		assertEquals(sue, result.younger());
		assertEquals(greg, result.older());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.Two).get();

		assertEquals(greg, result.younger());
		assertEquals(mike, result.older());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.Two).get();

		assertEquals(sue, result.younger());
		assertEquals(sarah, result.older());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonPair result = finder.closestAgeDiff().get();

		assertEquals(sue, result.younger());
		assertEquals(greg, result.older());
	}

}
