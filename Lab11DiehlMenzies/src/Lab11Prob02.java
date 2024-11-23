import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
/**
 * File: Lab11Prob02
 * Class: CSCI 1302
 * Author: Bailey Diehl, Tyler Menzies
 * Created on: 11/22/2024
 * Last Modified: 11/22/2024
 * Description: taking binary info an making a copy.
 */
public class Lab11Prob02 extends Person{
	public static void main(String[] args) {
		ArrayList<Person> personArr = new ArrayList<>();

		try( DataInputStream indata = new DataInputStream(new FileInputStream("people.dat"));
				//				DataOutputStream outdata = new DataOutputStream(new FileOutputStream("people-copy.dat"));
				){
			while (true) {
				int age = indata.readInt();
				String firstName = indata.readUTF();
				String lastName = indata.readUTF();
				int zipCode = indata.readInt();
				double salary = indata.readDouble();

				// Adding Person object to ArrayList
				personArr.add(new Person(age, firstName, lastName, zipCode, salary));

				//				 Read student test scores from the file
				//				System.out.printf("%d %s %s %d %.2f%n", age, firstName, lastName, zipCode, salary);

				//				outdata.writeInt(age);
				//				outdata.writeUTF(firstName);
				//				outdata.writeUTF(lastName);
				//				outdata.writeInt(zipCode);
				//				outdata.writeDouble(salary);	
			}

		}catch(EOFException ex) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sort all data from above.
		Collections.sort(personArr);

		// Write sorted data to File
		try (
				DataOutputStream outdata = new DataOutputStream(new FileOutputStream("people-salary-sorted.dat"));
				){
			
//			for (int i = 0; i < personArr.size(); i++) {
//				outdata.writeUTF(personArr.get(i).toString());
//				System.out.printf("%s", personArr.get(i).toString());
//			}
			
			for (Person person : personArr) {
				outdata.writeUTF(person.toString());
			}
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
