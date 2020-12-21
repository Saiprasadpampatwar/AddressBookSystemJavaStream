import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
