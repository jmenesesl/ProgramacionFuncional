/**
 * 
 */
package org.escoladeltreball.redsocial;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
/**
 * @author iaw26068632
 *
 */
public class Person {

	public enum Sex {
		MALE, FEMALE;
	}
	
	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	/**
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param emailAddress
	 */
	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @return the gender
	 */
	public Sex getGender() {
		return gender;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public int getAge() {
		return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	
	
	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}
	
	public void printPerson() {
		System.out.println(name + " " + this.getAge());
	}
	
	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<>();
		roster.add(new Person ("Fred", IsoChronology.INSTANCE.date(1988, 6, 20), Person.Sex.MALE, "fred@example.com"));
		roster.add(new Person ("Jane", IsoChronology.INSTANCE.date(1990, 7, 15), Person.Sex.FEMALE, "jane@example.com"));
		roster.add(new Person ("George", IsoChronology.INSTANCE.date(1991, 8, 13), Person.Sex.MALE, "george@example.com"));
		roster.add(new Person ("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com"));
		return roster;
	}
}
