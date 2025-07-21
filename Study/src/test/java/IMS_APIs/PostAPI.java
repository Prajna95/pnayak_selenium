package IMS_APIs;

import Pojo.Demand_POSTAPI_IMS;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;

import static IMS_APIs.GetAPI.accessToken;
import static io.restassured.RestAssured.given;

public class PostAPI {


 @Test

 public  void DemandApi()
 {
     Demand_POSTAPI_IMS.SkuRequestlist demandapi1 = new Demand_POSTAPI_IMS.SkuRequestlist();
     demandapi1.setNodeId("5958");
     demandapi1.setSkuId("460407276002");
     demandapi1.setQuantity(4);
     demandapi1.setImsBatch("");

     Demand_POSTAPI_IMS demandapi = new Demand_POSTAPI_IMS();
     demandapi.setAllowPartialDemand(false);
     demandapi.setReferenceId("FNA493511112");
     demandapi.setTenantId("AJIO");
     demandapi.setSkuRequestList(Arrays.asList(demandapi1));
     demandapi.setRequestId("TEST32-489111");

     RestAssured.baseURI ="http://10.166.181.73:30120";
     String token = GetAPI.getAccessToken();
     Response  response = given()
             .header("Accept", "application/json")
             .header("Source", "FS")
             .header("Authorization", "Bearer " + accessToken )
             .header("X-Client-Type", "STOS")
             .header("Content-Type", "application/json")
             .body(demandapi)
             .when()
             .post("/inventory/demand/create")
             .then()
             .statusCode(200)  // adjust if needed
             .extract().response();
     System.out.println("Response is " +response.asPrettyString());


 }
}
