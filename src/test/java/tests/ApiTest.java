import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    String userApiBaseUrl = "https://bookstore.toolsqa.com/Account/v1/User";
    String  booksApiBaseUrl = "https://bookstore.toolsqa.com/BookStore/v1/Books";
    String bookApiBaseUrl = "https://bookstore.toolsqa.com/BookStore/v1/Book";

    @org.testng.annotations.Test
    public void createNewUserTest() {
        String userName = "tuhin.mitra" + java.time.LocalTime.now();
        JsonObject requestBody = getRequestBody(String.format("{'userName':'%s', 'password':'Subhra123!'}", userName));

        given().
                contentType("application/json").
                body(requestBody).
                when().
                post(userApiBaseUrl).
                then().
                assertThat().
                statusCode(201).
                and().
                body("username", equalTo(userName));
    }

    @org.testng.annotations.Test
    public void getUsersBooksTest() {
        String userId = "140cf9c6-cb81-42d4-81c0-2d9532a033ef";

        given().
                auth().preemptive().basic("get.user1", "Password123!").
                when().
                get(String.format("%s/%s", userApiBaseUrl, userId)).
                then().
                assertThat().
                statusCode(200).
                and().
                body("books.size()", equalTo(2));
    }

    @org.testng.annotations.Test
    public void deleteBooksTest() {
        String userName = "add.collectionuser1";
        String password = "Password123!";
        String userId = "e891fa77-a426-445f-8057-49fe3e29edde";
        JsonObject requestBody = getRequestBody("{'collectionOfIsbns':[{'isbn':'9781449325862'}, {'isbn':'9781449331818'}], 'userId':'e891fa77-a426-445f-8057-49fe3e29edde'}");

        given().
                auth().preemptive().basic(userName, password).
                contentType("application/json").
                body(requestBody).
                when().
                post(booksApiBaseUrl).
                then().
                assertThat().
                statusCode(201).
                and().
                body("books.size()", equalTo(2));


        given().
                auth().preemptive().basic(userName, password).
                contentType("application/json").
                when().
                delete(String.format("%s?UserId=%s", booksApiBaseUrl, userId)).
                then().
                assertThat().
                statusCode(204).
                and().
                body(equalTo(""));
    }

    @org.testng.annotations.Test
    public void deleteUserNoAuthNegativeTest() {
        String userId = "e891fa77-a426-445f-8057-49fe3e29edde";

        given().
                when().
                delete(String.format("%s/%s", userApiBaseUrl, userId)).
                then().
                assertThat().
                statusCode(401).
                and().
                body("message", equalTo("User not authorized!"));
    }

    @org.testng.annotations.Test
    public void createNewUserExistingDetailsNegativeTest() {
        JsonObject requestBody = getRequestBody("{'userName':'tuhin.mitra', 'password':'Subhra123!'}");

        given().
                contentType("application/json").
                body(requestBody).
                when().
                post(userApiBaseUrl).
                then().
                assertThat().
                statusCode(406).
                and().
                body("message", equalTo("User exists!"));
    }

    @org.testng.annotations.Test
    public void getBookInvalidIsbnNegativeTest() {
        String invalidIsbn = "123456";

        given().
                when().
                get(String.format("%s?ISBN=%s", bookApiBaseUrl, invalidIsbn)).
                then().
                assertThat().
                statusCode(400).
                and().
                body("message", equalTo("ISBN supplied is not available in Books Collection!"));

    }

    public JsonObject getRequestBody(String body){
        return (JsonObject) JsonParser.parseString(body);
    }
}
