package org.escoladeltreball.redsocial;

import java.util.List;
import java.util.function.Consumer;

import org.escoladeltreball.redsocial.Person.Sex;

public class RoasterTest { // Esta clase utiliza los metodos de la clase Person

	interface CheckPerson {
		boolean test(Person p);
	}
	
	// Sexta aproximación, interficies funcionales con expresiones lambda
	interface Predicate<Person> {
		boolean test(Person t);
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {

		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
		
	}
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
		
	}
	
	//Septima aproximación
	public static void processPersons (
		List<Person> roster,
		Predicate<Person> tester,
		Consumer<Person> block) {
		
		for (Person p: roster) {
			
			if(tester.test(p)) {
				block.accept(p);
			}
			
		}
	}

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() > age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsBetween(List<Person> roster, int minAge, int maxAge) {
		for (Person p : roster) {
			if (p.getAge() > minAge && p.getAge() < maxAge) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsBetweenAndSex(List<Person> roster, int minAge, int maxAge, Sex sex) {
		for (Person p : roster) {
			if (p.getGender().equals(sex)) {
				if (p.getAge() > minAge && p.getAge() < maxAge)
					p.printPerson();
			}
		}
	}

	
}
