package Api.test;

import Api.endpoints.UserEndPoints;
import Api.payloads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static Api.endpoints.UserEndPoints.createuser;

public class UserTests {


    public Logger logger;
  User payload;
    @BeforeTest
    public void Datasetup()
    {
        payload = new User();
        payload.setId(0);
        payload.setUsername("prajna11");
        payload.setFirstName("prajna");
        payload.setLastName("nayak");
        payload.setEmail("prajna@test.com");
        payload.setPassword("lipa11");
        payload.setPhone("9677778888");
        payload.setUserStatus(0);
        io.restassured.RestAssured.useRelaxedHTTPSValidation();

        logger= LogManager.getLogManager().getLogger(String.valueOf(this.getClass()));

    }

//create user by using post api
@Test(priority = 1)
    public void testPostUser()
{
  Response response = createuser(payload);
  response.then().log().all();
    Assert.assertEquals(response.getStatusCode(),200);


}
//get user details by using get api
@Test(priority = 2)
    public  void testGetUsername()
{
    logger.info("*****creating user details*****");
  Response response = UserEndPoints.getuser(this.payload.getUsername());
  response.then().log().all().extract().asPrettyString();
  Assert.assertEquals(response.getStatusCode(),200);
  logger.info("*** user is created *****");

}

//update some fields by using put api
 @Test(priority = 3)
 public  void testUpdateUserdetails()
 {

     payload.setFirstName("prajna11");


     Response response = UserEndPoints.updateuser(this.payload.getUsername(),payload);
     response.then().log().all().extract().asPrettyString();
     Assert.assertEquals(response.getStatusCode(),200);

     //checking data after updation
     Response responseAfterupdate = UserEndPoints.getuser(this.payload.getUsername());
     responseAfterupdate.then().log().body();
     Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
 }

 //delete the user
    @Test(priority = 4)
    public  void testDeleteUser()
    {
        Response response = UserEndPoints.deleteuser(this.payload.getUsername());
        response.then().log().all().extract().asPrettyString();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
