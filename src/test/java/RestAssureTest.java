import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssureTest {
    @Before
    public void setUp(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3000;
    }

    @Test
    public void givenAddressbookDetailsShouldSaveToJsonServer() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3000;
        Person person = new Person("Sai","pampatwar","wadi","nanded","mah",4316,23456,"pam@gmail","friends");
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("firstname",person.firstname);
        jsonObject.addProperty("lastname",person.lastname);
        jsonObject.addProperty("address",person.address);
        jsonObject.addProperty("city",person.city);
        jsonObject.addProperty("state",person.state);
        jsonObject.addProperty("zip",person.zip);
        jsonObject.addProperty("phoneno",person.phoneno);
        jsonObject.addProperty("email",person.email);
        jsonObject.addProperty("type",person.type);

        System.out.println(jsonObject.toString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toString()).
                when().
                post("/Person");

    }

    @Test
    public void readDataFromJsonServer() {
        given().
                get("/Person").
                then().
                statusCode(200).
                and().
                log().all();
    }
}
