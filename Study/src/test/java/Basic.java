import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic {

    public static void main(String[] args) {
        //create data:post call
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String resonse = given().log().all().queryParam("key", "qaclick123").header("Conten-Type", "application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println(resonse);

        JsonPath js = new JsonPath(resonse);// for parsing the json
        String placeid = js.getString("place_id");
        System.out.println(placeid);

        //update place:put call
        String  newaddress="abcdhgh";
        given().log().all().queryParam("key", "qaclick123").header("Conten-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeid + "\",\n" +
                        "\"address\":\""+newaddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));


        //get call: retive data
        String getplaceadress= given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeid)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(getplaceadress);
        String actualaddress= js1.getString("address");
        System.out.println(actualaddress);
        Assert.assertEquals(actualaddress,newaddress);




    }
}

