/*
 * Person - V3 from V1 to V2
 */

public class Person implements Comparable <Person> {
	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private static int count = 0;

	// Constructor
	public Person(String first, String last, String address, String city,
	        String state, int zip) { // constructor
		lastName = last;
		firstName = first;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
		count++;
	}

	public Person(String string, String string2, String string3, String string4, String string5, int i, String string6) {
	    this("", "","","","",0);
	}
	

	// displayPerson
	public void displayPerson() {
		System.out.format("%12s %-12s %-25s %-12s %-5s %d", 
				firstName, lastName, address, city, state, zipCode);
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    // **** Getters and Setters ********
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result	+ ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;

        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;

        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        
        if (zipCode != other.zipCode)
            return false;
        
		return true;
	}

	@Override
	public String toString() {
		return String.format("%12s %-12s %-25s %-12s %-5s %d", 
                firstName, lastName, address, city, state, zipCode);
	}

	@Override
	public int compareTo(Person other) {
        // if last names are the same compare first names
        if(this.getLastName().equals(other.getLastName()))
        {
            return this.getFirstName().compareTo(other.getFirstName());
        }
            
        return this.getLastName().compareTo(other.getLastName());
	}
	
	public static int getCount() {
	    return count;
	}
		
} // end class Person
