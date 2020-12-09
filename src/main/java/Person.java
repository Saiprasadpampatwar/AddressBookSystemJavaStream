import com.opencsv.bean.CsvBindByName;

public class Person {
    @CsvBindByName
    public String firstname;

    @CsvBindByName
    public String lastname;

    @CsvBindByName
    public String address;

    @CsvBindByName
    public String city;

    @CsvBindByName
    public String state;

    @CsvBindByName
    public int zip;

    @CsvBindByName
    public int phoneno;

    @CsvBindByName
    public String email;

    @Override
    public String toString() {
        return "ContactDetails [firstName=" + firstname + ", lastName=" + lastname + ", address=" + address + ", city="
                + city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneno
                + "]";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
