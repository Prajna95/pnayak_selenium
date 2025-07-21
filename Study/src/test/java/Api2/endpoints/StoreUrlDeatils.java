package Api2.endpoints;

import Api2.playload.StoreData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StoreUrlDeatils {

  static ResourceBundle getURL()
  {
      ResourceBundle urls = ResourceBundle.getBundle("Routs");
      return urls;
  }

  public  static Response placeOrder(StoreData payload)
  {
      String posturl = getURL().getString("post_url_store");
      Response response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
              .body(payload).when().post(posturl);
      return response;
  }

  public static Response getStoreDta(int id)
  {
      String geturl = getURL().getString("get_url_store");
      Response response = given().relaxedHTTPSValidation().pathParam("orderId",id)
              .when().get(geturl);
      return response;

  }

  public  static Response deleteStoreData(int id)
  {
      String deleteurl = getURL().getString("delete_url_store");
      Response response = given().relaxedHTTPSValidation().pathParam("orderId",id)
              .when().delete(deleteurl);
      return response;
  }

}
