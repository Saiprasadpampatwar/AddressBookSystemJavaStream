package addressbook.javastream;
import java.util.*;

public class AddressBookMainStream {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		HashMap<String, ArrayList> DifferentAddressBook= new HashMap<>();
		AddressBook abook1 = new AddressBook();
		Scanner sc = new Scanner(System.in);
		int next = 1;
		while(next == 1)
		{
			System.out.println("Choose \n 1. New AddressBook\n 2. Exit");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("Enter the name of address book ");
				String nameOfAddressBook = sc.next();
						
				System.out.println("How many persons do you want to enter:");
				int noOfPerson = sc.nextInt();
				//AddressBook abook1 = new AddressBook();
				for(int i=0;i<noOfPerson;i++)
				{
				Person p1 = new Person();
				System.out.println("Enter First Name:");
				p1.firstname = sc.next();
				
		//Implemented stream to check any duplicates available
				boolean result = abook1.viewAllPerson().stream().anyMatch(s -> s.firstname.equals(p1.firstname));
				while(result) {
					System.out.println("Entered First name already exist please enter another name");
					p1.firstname = sc.next();
					
					result = abook1.viewAllPerson().stream().anyMatch(s -> s.firstname.equals(p1.firstname));
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
				
				abook1.addPerson(p1);
				}
				DifferentAddressBook.put(nameOfAddressBook, abook1.viewAllPerson());
				for(int i=0;i<abook1.viewAllPerson().size();i++)
				{
				System.out.println(abook1.viewAllPerson().get(i).firstname);
				}
				int ip =1;
				while(ip == 1)
				{
				System.out.println("Choose 1.Edit\n 2.Delete\n 3.Exit");
				int option = sc.nextInt();
				String nameofperson;
				switch (option) {
				case 1: 
					System.out.println("Enter fname");
					nameofperson = sc.next();
					
					for(int i=0;i<abook1.viewAllPerson().size();i++)
					{
						if(nameofperson.equalsIgnoreCase(abook1.viewAllPerson().get(i).firstname))
						{
							System.out.println("Which detail you want to change\n 1.First Name\n 2.Last Name\n"
									+ "3.Address\n 4. City\n 5.State \n 6. zip \n 7. phone no\n 8.email");
							int choose = sc.nextInt();
							switch(choose) {
							case 1:
								System.out.println("New First Name:");
								abook1.viewAllPerson().get(i).firstname = sc.next();
								break;
							case 2:
								System.out.println("New Last Name:");
								abook1.viewAllPerson().get(i).lastname = sc.next();
								break;
							case 3:
								System.out.println("New Address:");
								abook1.viewAllPerson().get(i).address = sc.next();
								break;
							case 4:
								System.out.println("New City:");
								abook1.viewAllPerson().get(i).city = sc.next();
								break;
							case 5:
								System.out.println("New State:");
								abook1.viewAllPerson().get(i).state = sc.next();
								break;
							case 6:
								System.out.println("New zip:");
								abook1.viewAllPerson().get(i).zip = sc.nextInt();
								break;
							case 7:
								System.out.println("New phone no:");
								abook1.viewAllPerson().get(i).phoneno = sc.nextInt();
								break;
							case 8:
								System.out.println("New Email:");
								abook1.viewAllPerson().get(i).email = sc.next();
								break;
							}
						}
					}
					ip = 1;
					break;
					case 2 :
						System.out.println("Enter fname");
						nameofperson = sc.next();
						for(int i=0;i<abook1.viewAllPerson().size();i++)
						{
							if(nameofperson.equalsIgnoreCase(abook1.viewAllPerson().get(i).firstname))
							{
								abook1.viewAllPerson().remove(i);
							}
						}
						ip = 1;
						break;
						
					case 3 :
						ip = 0;
						break;
					
				}
				}
				for(int i=0;i<abook1.viewAllPerson().size();i++)
				{
					System.out.println("Details of "+(i+1)+" Person");
					System.out.println("First Name: "+abook1.viewAllPerson().get(i).firstname);
					System.out.println("Last Name: "+abook1.viewAllPerson().get(i).lastname);
					System.out.println("Address: "+abook1.viewAllPerson().get(i).address);
					System.out.println("City: "+abook1.viewAllPerson().get(i).city);
					System.out.println("State: "+abook1.viewAllPerson().get(i).state);
					System.out.println("ZIP: "+abook1.viewAllPerson().get(i).zip);
					System.out.println("Phone No: "+abook1.viewAllPerson().get(i).phoneno);
					System.out.println("Email: "+abook1.viewAllPerson().get(i).email);
				}
				next = 1;
				break;
				
			case 2:
				System.out.println("Thank You");
				next = 0;
				break;
			}
		}

		
}
	
}
 class Person{
	String firstname;
	String lastname;
	String address;
	String city;
	String state;
	int zip;
	int phoneno;
	String email;	
}
 
 class AddressBook{
	 ArrayList<Person> contactDetails = new ArrayList<Person>();
	 
	 public void addPerson(Person pobj) {
		 contactDetails.add(pobj);
	 }
	 
	 public ArrayList<Person> viewAllPerson(){
		 return contactDetails;
	 }
 }