package Ecommerce_Prgm;

import Pojo.LoaginResp;
import Pojo.LoginPage;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EcommerceAPITest {

   @Test

   public void LogInPage()
   {
      //login page
       RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
               setContentType(ContentType.JSON).build();
      LoginPage login = new LoginPage();
      login.setUserEmail("prajna@gmail.com");
      login.setUserPassword("Lipa@0811");
       RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification reqlogin =  given().log().all().spec(req).body(login);


       LoaginResp loginresp = reqlogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoaginResp.class);
       String token =loginresp.getToken();
       System.out.println(loginresp.getUserId());
       System.out.println(loginresp.getMessage());

       //add product to cart
       RequestSpecification addtocartBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
               addHeader("Authorization",token).setContentType(ContentType.JSON).build();
       given().log().all().spec(addtocartBaseReq).param("productname","laptop");

   }
}
