import java.io.Serializable;

/**
 * File: Lab11Prob01
 * Class: CSCI 1302
 * Author: Bailey Diehl, Tyler Menzies
 * Created on: 11/22/2024
 * Last Modified: 11/22/2024
 * Description: 
 */
 
public class Person implements Comparable<Person>, Serializable{
	private int age;
	private String firstName;
	private String lastName;
	private int zipCode;
	private double salary;
	
	public Person() {
		
	}
	
	public Person(int age, String firstName, String lastName, int zipCode, double salary) {
		setAge(age);
		setFirstName(firstName);
		setLastName(lastName);
		setZipCode(zipCode);
		setSalary(salary);
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d $%,.2f%n", age, firstName, lastName, zipCode, salary);
	}
	
	@Override
	public int compareTo(Person o) {
		if(this.getSalary()> o.getSalary()) {
			return -1;
		} else if(this.getSalary()< o.getSalary()) {
			return 1;
		} else {
			return 0;			
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
