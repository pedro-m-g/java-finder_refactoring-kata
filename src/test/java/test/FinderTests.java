package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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
		sue = new Person(new GregorianCalendar(1950, 0, 1));
		greg = new Person(new GregorianCalendar(1952, 5, 1));
		sarah = new Person(new GregorianCalendar(1982, 0, 1));
		mike = new Person(new GregorianCalendar(1979, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.One);
		assertEquals(null, result.younger());

		assertEquals(null, result.older());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.One);

		assertEquals(null, result.younger());
		assertEquals(null, result.older());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.One);

		assertEquals(sue, result.younger());
		assertEquals(greg, result.older());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(FT.Two);

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

		PersonPair result = finder.Find(FT.Two);

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

		PersonPair result = finder.Find(FT.One);

		assertEquals(sue, result.younger());
		assertEquals(greg, result.older());
	}

}
