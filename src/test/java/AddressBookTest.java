import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class AddressBookTest {
    @Test
    public void connectingToDataBaseShouldReturnCorrectNoOfRecordsFromDB() throws SQLException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Person> personList = addressBookDB.readAddressBookData();
        Assert.assertEquals(6,personList.size());
    }
}

