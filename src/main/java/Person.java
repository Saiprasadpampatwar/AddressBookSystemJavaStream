import java.util.Objects;

public class Person {
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    int phoneno;
    String email;
    String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return zip == person.zip &&
                phoneno == person.phoneno &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(address, person.address) &&
                Objects.equals(city, person.city) &&
                Objects.equals(state, person.state) &&
                Objects.equals(email, person.email) &&
                Objects.equals(type, person.type);
    }

    public Person() {
    }

    public Person(String firstname, String lastname, String address, String city, String state, int zip, int phoneno, String email, String type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneno = phoneno;
        this.email = email;
        this.type = type;
    }
}
