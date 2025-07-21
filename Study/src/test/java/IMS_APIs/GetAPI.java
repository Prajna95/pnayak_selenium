package IMS_APIs;

import Pojo.LoginAPI_IMS;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class GetAPI {


     static String accessToken;

    public static String getAccessToken() {
        if (accessToken == null) {
            accessToken = fetchToken();
        }
        return accessToken;
    }

@Test


public static String fetchToken()
{
    LoginAPI_IMS loginpage = new LoginAPI_IMS();
    loginpage.setUsername("sterling_uat");
    loginpage.setPassword("sterling_uat");
    loginpage.setTenantId("AJIO");

    RestAssured.baseURI = "http://10.166.181.73:30120";
    Response loginresponse = given().header("X-Client-Type", "STOS")
        .header("Accept", "application/json")
        .header("Content-Type", "application/json")
        .header("Source", "HYBRIS")
        .body(loginpage).when().post("/inventory/auth/login").
            then().log().all().statusCode(200).extract().response();

    return loginresponse.jsonPath().getString("accessToken");



}


}
