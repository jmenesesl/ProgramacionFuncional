/**
 * 
 */
package org.escoladeltreball.redsocial;

import java.util.List;

import org.escoladeltreball.redsocial.Person.Sex;
import org.escoladeltreball.redsocial.RoasterTest.CheckPerson;

/**
 * @author iaw26068632
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) { // Esta clase Main llamara a la clase roasterTest
		List<Person> roster = Person.createRoster();

		for (Person p : roster) {
			p.printPerson();
		}

		System.out.println("\n\nPersons Olders Than 20\n-------------------------");
		RoasterTest.printPersonsOlderThan(roster, 20);
		// Para cada tipo de filtrado, hemos de crear metodos distintos en la clase
		// RoasterTest

		System.out.println("\npersonas mayores de 18 y menores de 30");
		RoasterTest.printPersonsBetween(roster, 18, 30);

		System.out.println("\nMujeres mayores de 18 y menores de 30");
		RoasterTest.printPersonsBetweenAndSex(roster, 18, 30, Sex.FEMALE);

		// INTERFAZ EN ROASTERTEST
		class CheckPersonEligibleForSelectiveService implements CheckPerson {
			public boolean test(Person p) {
				// System.out.println("test");
				return (p.getGender() == Person.Sex.MALE) && (p.getAge() >= 18 && p.getAge() <= 30);

			}
		}

		// Tercera aproximacion

		System.out.println("\nPasamos el TEST personas entre 18 y 30 años hombres");
		RoasterTest.printPersons(roster, new CheckPersonEligibleForSelectiveService());

		System.out.println();

		// Cuarta aproximacion // interfaz anonima
		RoasterTest.printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return (p.getGender() == Person.Sex.FEMALE) && (p.getAge() >= 18 && p.getAge() <= 30);
			}
		});

		// Quinta aproximación // Interfaz blanda
		System.out.println("\n\nPersons who are eligible for selective service, llambda expression"); // Recibirá una
																										// funcion
																										// pasada como
																										// parametro

		RoasterTest.printPersons(roster,
				(Person p) -> p.getGender() == Person.Sex.MALE && (p.getAge() >= 18 && p.getAge() <= 30));
		
		
		System.out.println("\n\nSexta aproximación, interfaz Predicate<Person>");
		RoasterTest.printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 30);
		
		// Septima aproximación
		System.out.println("\n\nSeptima generación");
		RoasterTest.processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 30, p -> p.printPerson());
	}
	
	

}
