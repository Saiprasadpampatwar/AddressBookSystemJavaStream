import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookDB {

    public Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSl=false";
        String userName = "root";
        String password = "Sai@mysql";
        Connection connection;
        System.out.println("connecting to the database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("connection is successful!!!!" + connection);
        return connection;
    }

    public List<Person> readAddressBookData() {
        String sql = "select * from address_book";
        List<Person> personList = new ArrayList<>();
        try{
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                int phoneno = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String type = resultSet.getString("type");
                personList.add(new Person(firstname,lastname,address,city,state,zip,phoneno,email,type));
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return personList;
    }

    public void addPersonToAddressBookDB(String firstname, String lastname, String address, String city, String state, int zip, int phone, String email, String type) {
        List<Person> personList = new ArrayList<>();
        String sql = String.format("insert into address_book (firstname,lastname,address,city,state,zip,phone_number,email,type) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",firstname,
                lastname,address,city,state,zip,phone,email,type);
        Person person = new Person();
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            person.firstname = firstname;
            person.lastname = lastname;
            person.address = address;
            person.city = city;
            person.state = state;
            person.zip = zip;
            person.phoneno = phone;
            person.email = email;
            person.type = type;
            personList.add(person);

            /*ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                person.firstname = resultSet.getString("firstname");
                person.lastname = resultSet.getString("lastname");
                person.address = resultSet.getString("address");
                person.city = resultSet.getString("city");
                person.state = resultSet.getString("state");
                person.zip = resultSet.getInt("zip");
                person.phoneno = resultSet.getInt("phone_number");
                person.email = resultSet.getString("email");
                person.type = resultSet.getString("type");
                personList.add(person);
            }*/

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public boolean checkPersonInSyncWithAddressBook(String firstname) {
        List<Person> personsList = this.readAddressBookData();
        List<Person> namelist = personsList.stream().filter(person -> person.firstname.equals(firstname)).collect(Collectors.toList());
        if(namelist.get(0).firstname.equals(firstname))
            return true;
        return false;
    }

    public void updateAddress(String firstname, String address) {
        String sql = String.format("update address_book set address = '%s' where firstname = '%s'",address,firstname);
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            if(i>0){
                System.out.println("updated address successfully");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Person> retrivePersondAddedInDateRange(String startDate, String endDate) {
        List<Person> personList = new ArrayList<>();
        String sql = String.format("select * from address_book where date_added between cast('%s' as date) and cast('%s' as date)",startDate,endDate);
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Person person = new Person();
                person.firstname = resultSet.getString("firstname");
                person.lastname = resultSet.getString("lastname");
                person.address = resultSet.getString("address");
                person.city = resultSet.getString("city");
                person.state = resultSet.getString("state");
                person.zip = resultSet.getInt("zip");
                person.phoneno = resultSet.getInt("phone_number");
                person.email = resultSet.getString("email");
                person.type = resultSet.getString("type");
                personList.add(person);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return personList;
    }
}
