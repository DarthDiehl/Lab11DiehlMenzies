import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
/**
 * File: Lab11Prob03
 * Class: CSCI 1302
 * Author: Bailey Diehl, Tyler Menzies
 * Created on: 11/22/2024
 * Last Modified: 11/26/2024
 * Description: taking binary info an making a copy.
 */
public class Lab11Prob03 extends Person{
	public static void main(String[] args) {
		ArrayList<Person> personArr = new ArrayList<>();

		try( DataInputStream indata = new DataInputStream(new FileInputStream("people.dat"));
				//DataOutputStream outdata = new DataOutputStream(new FileOutputStream("people-copy.dat"));
				){
			while (true) {
				int age = indata.readInt();
				String firstName = indata.readUTF();
				String lastName = indata.readUTF();
				int zipCode = indata.readInt();
				double salary = indata.readDouble();

				// Adding Person object to ArrayList
				personArr.add(new Person(age, firstName, lastName, zipCode, salary));
			}

		}catch(EOFException ex) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sort all data from above.
		Collections.sort(personArr);
		
		// Person Object to a new Binary File - Prob03
		try(ObjectOutputStream objData = new ObjectOutputStream(new FileOutputStream("people-salary-sorted-objects.dat"))
				){
			for(Person person : personArr) {
				objData.writeObject(person); // Serialize toward a object.
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Write sorted data to new binary file - Prob02
		try (
				DataOutputStream outdata = new DataOutputStream(new FileOutputStream("people-salary-sorted.dat"));
				){
			for (Person person : personArr) {
				outdata.writeUTF(person.toString());
			}
		} catch (EOFException e2) {
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
