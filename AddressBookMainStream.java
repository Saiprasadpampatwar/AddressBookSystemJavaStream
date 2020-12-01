package addressbook.javastream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookMainStream {

	static Scanner sc = new Scanner(System.in);

	public static void printAllDetails(Person p) {

		System.out.println("\nFirst Name: " + p.firstname);
		System.out.println("Last Name: " + p.lastname);
		System.out.println("Address: " + p.address);
		System.out.println("City: " + p.city);
		System.out.println("State: " + p.state);
		System.out.println("ZIP: " + p.zip);
		System.out.println("Phone No: " + p.phoneno);
		System.out.println("Email: " + p.email);
	}

	public static Person addPersons(AddressBook abook1) {
		Person p1 = new Person();
		System.out.println("Enter First Name:");
		p1.firstname = sc.next();
		boolean result = abook1.retuenAddressBook().stream().anyMatch(s -> s.firstname.equals(p1.firstname));
		while (result) {
			System.out.println("Entered First name already exist please enter another name");
			p1.firstname = sc.next();
			result = abook1.retuenAddressBook().stream().anyMatch(s -> s.firstname.equals(p1.firstname));
		}
		System.out.println("Enter the last name: ");
		p1.lastname = sc.next();
		System.out.println("Enter the address");
		p1.address = sc.next();
		System.out.println("Enter the City: ");
		p1.city = sc.next();
		System.out.println("Enter the State: ");
		p1.state = sc.next();
		System.out.println("Enter the zip: ");
		p1.zip = sc.nextInt();
		System.out.println("Enter the mob.no: ");

		p1.phoneno = sc.nextInt();
		System.out.println("Enter the email: ");
		p1.email = sc.next();

		System.out.println("Thank You");
		return p1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		HashMap<String, AddressBook> DifferentAddressBook = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		int next = 1;
		while (next == 1) {
			System.out.println("Choose \n 1. New AddressBook\n 2. Exit");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("Enter the name of address book ");
				String nameOfAddressBook = sc.next();

				System.out.println("How many persons do you want to enter:");
				int noOfPerson = sc.nextInt();
				// AddressBook abook1 = new AddressBook();
				AddressBook abook1 = new AddressBook();
				for (int i = 0; i < noOfPerson; i++) {

					abook1.addPerson(addPersons(abook1));

				}
				DifferentAddressBook.put(nameOfAddressBook, abook1);
				for (int i = 0; i < abook1.retuenAddressBook().size(); i++) {
					System.out.println(abook1.retuenAddressBook().get(i).firstname);
				}
				int ip = 1;
				while (ip == 1) {
					System.out.println("Choose 1.Edit\n 2.Delete\n 3.Exit");
					int option = sc.nextInt();
					String nameofperson;
					switch (option) {
					case 1:
						System.out.println("Enter fname");
						nameofperson = sc.next();

						for (int i = 0; i < abook1.retuenAddressBook().size(); i++) {
							if (nameofperson.equalsIgnoreCase(abook1.retuenAddressBook().get(i).firstname)) {
								System.out.println("Which detail you want to change\n 1.First Name\n 2.Last Name\n"
										+ "3.Address\n 4. City\n 5.State \n 6. zip \n 7. phone no\n 8.email");
								int choose = sc.nextInt();
								switch (choose) {
								case 1:
									System.out.println("New First Name:");
									abook1.retuenAddressBook().get(i).firstname = sc.next();
									break;
								case 2:
									System.out.println("New Last Name:");
									abook1.retuenAddressBook().get(i).lastname = sc.next();
									break;
								case 3:
									System.out.println("New Address:");
									abook1.retuenAddressBook().get(i).address = sc.next();
									break;
								case 4:
									System.out.println("New City:");
									abook1.retuenAddressBook().get(i).city = sc.next();
									break;
								case 5:
									System.out.println("New State:");
									abook1.retuenAddressBook().get(i).state = sc.next();
									break;
								case 6:
									System.out.println("New zip:");
									abook1.retuenAddressBook().get(i).zip = sc.nextInt();
									break;
								case 7:
									System.out.println("New phone no:");
									abook1.retuenAddressBook().get(i).phoneno = sc.nextInt();
									break;
								case 8:
									System.out.println("New Email:");
									abook1.retuenAddressBook().get(i).email = sc.next();
									break;
								}
							}
						}
						ip = 1;
						break;
					case 2:
						System.out.println("Enter fname");
						nameofperson = sc.next();
						for (int i = 0; i < abook1.retuenAddressBook().size(); i++) {
							if (nameofperson.equalsIgnoreCase(abook1.retuenAddressBook().get(i).firstname)) {
								abook1.retuenAddressBook().remove(i);
							}
						}
						ip = 1;
						break;

					case 3:
						ip = 0;
						break;

					}
				}
				for (int i = 0; i < abook1.retuenAddressBook().size(); i++) {
					System.out.println("Details of " + (i + 1) + " Person");
					System.out.println("First Name: " + abook1.retuenAddressBook().get(i).firstname);
					System.out.println("Last Name: " + abook1.retuenAddressBook().get(i).lastname);
					System.out.println("Address: " + abook1.retuenAddressBook().get(i).address);
					System.out.println("City: " + abook1.retuenAddressBook().get(i).city);
					System.out.println("State: " + abook1.retuenAddressBook().get(i).state);
					System.out.println("ZIP: " + abook1.retuenAddressBook().get(i).zip);
					System.out.println("Phone No: " + abook1.retuenAddressBook().get(i).phoneno);
					System.out.println("Email: " + abook1.retuenAddressBook().get(i).email);
				}
				next = 1;
				break;

			case 2:
				System.out.println("Thank You");
				next = 0;
				break;
			}
		}
		boolean nextOption = true;
		while (nextOption) {
			System.out.println(
					"Select 1. search a person by city\n 2.search a person by state\n 3. view person and cities\n 4. view person and states\n 5.find head count in city\n 6.find head count in state\n 7.Sorting of entries based on firstname\n 8.Sorting of entries based on city\n 9.Sorting of entries based on state\n 10.Sorting of entries based on zip\n 11.Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Which city you want to find out:");
				String cityName = sc.next();
				DifferentAddressBook.values().forEach(s -> {
					s.contactDetails.forEach(sm -> {
						if (sm.city.equals(cityName)) {
							System.out.println(sm.firstname);
						}
					});
				});
				nextOption = true;
				break;
			case 2:
				System.out.println("Which state you want to find out:");
				String stateName = sc.next();
				DifferentAddressBook.values().forEach(s -> {
					s.contactDetails.forEach(sm -> {
						if (sm.state.equals(stateName)) {
							System.out.println(sm.firstname);
						}
					});
				});
				nextOption = true;
				break;
			case 3:
				Map<String, String> cityVsPerson = new HashMap<>();
				DifferentAddressBook.values().forEach(s -> {
					s.contactDetails.forEach(sm -> {
						{
							cityVsPerson.put(sm.firstname, sm.city);
							System.out.println(sm.firstname + " : " + sm.city);
						}
					});
				});
				nextOption = true;
				break;
			case 4:
				Map<String, String> stateVsPerson = new HashMap<>();
				DifferentAddressBook.values().forEach(s -> {
					s.contactDetails.forEach(sm -> {
						{
							stateVsPerson.put(sm.firstname, sm.city);
							System.out.println(sm.firstname + " : " + sm.state);
						}
					});
				});
				nextOption = true;
				break;
			case 5:
				System.out.println("Which city you want to find out:");
				String cityName1 = sc.next();
				List<Person> personlList = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).collect(Collectors.toList());
				long count = personlList.stream().filter(s -> s.city.equals(cityName1)).count();
				System.out.println("Head count in " + cityName1 + " is " + count);
				nextOption = true;
				break;
			case 6:
				System.out.println("Which state you want to find out:");
				String stateName1 = sc.next();
				List<Person> personlList1 = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).collect(Collectors.toList());
				long count1 = personlList1.stream().filter(s -> s.state.equals(stateName1)).count();
				System.out.println("Head count in " + stateName1 + " is " + count1);
				nextOption = true;
				break;
			case 7:
				System.out.println("Sorting of entries based on firstname:");
				List<String> personlList2 = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).map(st -> st.firstname).sorted()
						.collect(Collectors.toList());
				for (String name : personlList2) {
					DifferentAddressBook.values().forEach(s -> {
						s.contactDetails.forEach(sm -> {
							if (sm.firstname.equals(name)) {
								printAllDetails(sm);
							}
						});
					});
				}
				nextOption = true;
				break;
			case 8:
				System.out.println("Sorting of entries based on city:");
				List<String> personlList3 = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).map(st -> st.city).sorted().distinct()
						.collect(Collectors.toList());
				for (String city : personlList3) {
					DifferentAddressBook.values().forEach(s -> {
						s.contactDetails.forEach(sm -> {
							if (sm.city.equals(city)) {
								printAllDetails(sm);
							}
						});
					});
				}
				nextOption = true;
				break;
			case 9:
				System.out.println("Sorting of entries based on state:");
				List<String> personlList4 = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).map(st -> st.state).sorted().distinct()
						.collect(Collectors.toList());
				System.out.println(personlList4);
				for (String state : personlList4) {
					DifferentAddressBook.values().forEach(s -> {
						s.contactDetails.forEach(sm -> {
							if (sm.state.equals(state)) {
								printAllDetails(sm);
							}
						});
					});
				}
				nextOption = true;
				break;
			case 10:
				System.out.println("Sorting of entries based on zip:");
				List<Integer> personlList5 = DifferentAddressBook.values().stream()
						.flatMap(s -> s.contactDetails.stream()).map(st -> st.zip).sorted().distinct()
						.collect(Collectors.toList());
				for (Integer zip : personlList5) {
					DifferentAddressBook.values().forEach(s -> {
						s.contactDetails.forEach(sm -> {
							if (sm.zip == zip) {
								printAllDetails(sm);
							}
						});
					});
				}
				nextOption = true;
				break;
			case 11:
				System.out.println("Thank You!!!!");
				nextOption = false;
				break;
			}

		}

	}

}

class Person {
	String firstname;
	String lastname;
	String address;
	String city;
	String state;
	int zip;
	int phoneno;
	String email;
}

class AddressBook {
	ArrayList<Person> contactDetails = new ArrayList<Person>();

	public void addPerson(Person pobj) {
		contactDetails.add(pobj);
	}

	public ArrayList<Person> retuenAddressBook() {
		return contactDetails;
	}
}