package IMS_APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetDemandApi {


   String accresstoken = GetAPI.getAccessToken();

  @Test

  public void getDemandApi()
  {
      RestAssured.baseURI = "http://10.166.181.73:30120";

      Response response = given()
              .header("accept", "application/json")
              .header("Authorization", "Bearer " + accresstoken)
              .header("X-Client-Type", "STOS")
              .queryParam("referenceId", "Ref-14392005")
              .queryParam("reservationId", "9d4908fa-c71f-4df7-ad3e-cae9a8222ce4")
              .queryParam("tenantId", "AJIO")
              .when()
              .get("/inventory/demand/get")
              .then()
              .statusCode(200)
              .extract().response();

      System.out.println("Status code "+ response.getStatusCode());
      System.out.println("Response Body" + response.asPrettyString());



  }


}
