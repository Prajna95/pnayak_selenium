package Api.test;

import Api.endpoints.UserEndPoints;
import Api.payloads.User;
import Api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTest {





@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostUser(String id,String Username, String fname, String lname,
                             String email, String password, String phone)


{
    User payload = new User();
    payload.setId(Integer.parseInt(id));
    payload.setUsername(Username);
    payload.setFirstName(fname);
    payload.setLastName(lname);
    payload.setEmail(email);
    payload.setPhone(phone);
    payload.setPassword(password);

    Response response = UserEndPoints.createuser(payload);
    response.then().log().all().extract().asPrettyString();
    Assert.assertEquals(response.getStatusCode(),200);

}
    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testGetUserDetails(String username)
    {
        Response response =UserEndPoints.getuser(username);
        response.then().log().all().extract().asPrettyString();
        Assert.assertEquals(response.getStatusCode(),200);
    }



@Test(priority = 3,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteUserDetails(String username)
{
    Response response =UserEndPoints.deleteuser(username);
    Assert.assertEquals(response.getStatusCode(),200);
}


}
