/*
 * V3
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataController {
	private List<Person> personList; // reference to array
	private static final String filePath = "Person2000Address2.csv";
	
	public DataController(int max) throws IOException { // constructor
		personList = new ArrayList<Person>(); // create the array
		loadData(filePath);
	}

	private int loadData(String path) throws IOException {
	    Path personPath = Paths.get(filePath);
	    File personFile = personPath.toFile();
	    
	    try {
	    	StringTokenizer token = null;
	    	FileReader fileReader = new FileReader(personFile);
	    	BufferedReader buffReader = new BufferedReader(fileReader);
	    	String line = null;
	    	while((line = buffReader.readLine()) != null) {
	    		token = new StringTokenizer(line, ",");
	    		Person person = new Person(token.nextToken(), token.nextToken(), token.nextToken(),
	    				token.nextToken(), token.nextToken(), Integer.parseInt(token.nextToken()));
	    		personList.add(person);
	    	}
	    } catch (FileNotFoundException e) {
	    	System.out.println("File not found");
	    	return (0);
	    }
	    return getCount();
	}
	private int getCount() {
		// TODO Auto-generated method stub
		return personList.size();
	}

	/***
	 * search - Search a person by the lastname.
	 * 
	 * @param last name to search
	 * @return a Person object
	 */
	public List<Person> findByLastName(String lastName) { // find specified value
		List<Person> lastNames;
		lastNames = new ArrayList<Person>();
		for (int j = 0; j < personList.size(); j++) { // curly bracket unneccessary here
			/*
			 * for each element in the array of object, compare current obj's lastname
			 * string with string that is passed
			 */
			if (personList.get(j).getLastName().equalsIgnoreCase(lastName)) { // found item?
				lastNames.add(personList.get(j)); // return the index
			}
		}
		return lastNames;
	} // end search()

	/***
	 * search - Search a person by person object.
	 * 
	 * @param last name to search
	 * @return a Person object
	 */

	public List<Person> findByFirstName(String firstName) { // find specified value
		List<Person> firstNames;
		firstNames = new ArrayList<Person>();
		for (int j = 0; j < personList.size(); j++) {
			if (personList.get(j).getFirstName().equalsIgnoreCase(firstName)) { // found item?
				firstNames.add(personList.get(j));
			} // end if
		} // end for loop
		return firstNames;
	} // end search()

	public List<Person> Sort() {
	Collections.sort(personList);
	return personList;
				}
	public void writeToFile(String fName) throws IOException {
		Path txtPath = Paths.get("SortedOutput.txt");
		File txtFile = txtPath.toFile();
		PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new FileWriter(txtFile)));
		out.print(personList + "\t");
		out.close();
	}
	}

	