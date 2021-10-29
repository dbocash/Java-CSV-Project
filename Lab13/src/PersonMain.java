import java.io.IOException;

public class PersonMain {

	public static void main(String[] args) throws IOException {
		int maxSize = 2000;	// array size
		DataController dc; 		// reference to array
		
		//Create an instance of DataController (that has person array)
		dc = new DataController(maxSize);
		
		System.out.println("Number of persons in the database is: " + Person.getCount());
		System.out.println();
		
		System.out.println("\nfindByFirstName - Listing all person with first name: Dylan");
		String searchKey = "Dylan"; // search for item
		System.out.println(dc.findByFirstName(searchKey));
		System.out.println(dc.findByFirstName(searchKey));
		
		System.out.println("\nfindByLastName - Listing all persons with last name: Hall");
		searchKey = "Hall";
		System.out.println(dc.findByLastName(searchKey));
		System.out.println(dc.findByLastName(searchKey));
		
		dc.Sort();
		System.out.println("\nWriting to file after sort");
		dc.writeToFile("Person2000Address2.csv");

    /* Fill in the code */

	}
}