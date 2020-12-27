import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookTest {
    @Test
    public void connectingToDataBaseShouldReturnCorrectNoOfRecordsFromDB() throws SQLException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Person> personList = addressBookDB.readAddressBookData();
        Assert.assertEquals(6,personList.size());
    }

    @Test
    public void givenUpdatedContactShouldSincWithDB() {
        AddressBookDB addressBookDB = new AddressBookDB();
        addressBookDB.readAddressBookData();
        addressBookDB.addPersonToAddressBookDB("dnyanesh","patil","vannali","nanded","maharashtra",431602,8987654,"dny@gmail","friends");
        boolean result = addressBookDB.checkPersonInSyncWithAddressBook("dnyanesh");
        Assert.assertTrue(result);
    }

    @Test
    public void givenUpdatedAddressShouldSincWithDB() {
        AddressBookDB addressBookDB = new AddressBookDB();
        addressBookDB.updateAddress("sai","wadi bk");
        List<Person> personList = addressBookDB.readAddressBookData();
        List<Person> person = personList.stream().filter(p->p.firstname.equals("sai")).collect(Collectors.toList());
        Assert.assertEquals("wadi bk",person.get(0).address);
    }

    @Test
    public void givenDateRangeShouldReturnNumberOfPersonsAddedInThatRange() {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Person> personList = addressBookDB.retrivePersondAddedInDateRange("2018-01-01","2018-05-05");
        Assert.assertEquals(4,personList.size());
    }

    @Test
    public void givenCityOrStateNameShouldRetriveNumberofContactsFromDB() {
        AddressBookDB addressBookDB = new AddressBookDB();
        int noOfContactsCity = addressBookDB.getHeadCountByCity("nanded");
        int noOfContactsState = addressBookDB.getHeadCountByState("maharashtra");
        Assert.assertEquals(4,noOfContactsState);
        Assert.assertEquals(2,noOfContactsCity);
    }

    @Test
    public void given3Persons_whenAddedToDB_shouldMatchEmployeeEntries() {

        Person[] personsData = {
                new Person("kishan","chouhan","kali","dehri","bihar",87567,98987,"kishan@gmail","friends"),
                new Person("neeraj","aadwani","sasi","bhopal","MP",12354,6785,"neeraj@hjkd","friends"),
                new Person("shishir","kumud","darya","bilaspur","chattisgadh",16783,77788,"shishir@wweed","friends")
        };

        AddressBookDB addressBookDB = new AddressBookDB();
        addressBookDB.readPersonsWithThreads(Arrays.asList(personsData));
        List<Person> personList = addressBookDB.readAddressBookData();
        Assert.assertEquals(10,personList.size());

    }
}

