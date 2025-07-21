package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(dataProvider = "bookdata")
            public void addBook(String isbn, String aisle)
    {
        RestAssured.baseURI ="https://rahulshettyacademy.com";
        String response = given().log().all().header("Conten-Type", "application/json").
                body(payload.AddBook(isbn,aisle)).
                when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        System.out.println(id);

    }

   @DataProvider(name="bookdata")
   public Object[][] getData()
   {
       return new Object[][] {{"mbn","878"},{"ljj","099"},{"lkk","566"}};
   }


}
