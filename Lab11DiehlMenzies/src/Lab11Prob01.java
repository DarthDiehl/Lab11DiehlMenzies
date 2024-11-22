import java.io.*;
/**
 * File: Lab11Prob01
 * Class: CSCI 1302
 * Author: Bailey Diehl, Tyler Menzies
 * Created on: 11/22/2024
 * Last Modified: 11/22/2024
 * Description: taking binary info an making a copy.
 */
public class Lab11Prob01 {
	public static void main(String[] args) {
		try( DataInputStream indata = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream outdata = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
				){
				
			// Variables
				int age = indata.readInt();
				String firstName = indata.readUTF();
				String lastName = indata.readUTF();
				int zipCode = indata.readInt();
				double salary = indata.readDouble();
				
				while (true) {
				// Read student test scores from the file
				System.out.printf("%d %s %s %d %.2f%n", age, firstName, lastName, zipCode, salary);
				
				outdata.writeInt(age);
				outdata.writeUTF(firstName);
				outdata.writeUTF(lastName);
				outdata.writeInt(zipCode);
				outdata.writeDouble(salary);	
			}
		}catch(EOFException ex) {
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

