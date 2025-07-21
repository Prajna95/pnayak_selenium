package Api.endpoints;

import Api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {

//method to created for getting urls from the perporties file
    static ResourceBundle getURL()
{
    ResourceBundle routs= ResourceBundle.getBundle("Routs"); //load propertoes file
    return routs;
}

    public  static Response createuser(User payload)
    {
        String post_url = getURL().getString("post_url");
       Response response=  given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(payload).when().post(post_url);
       return response;
    }
    public  static Response getuser(String username)
    {
        String get_url = getURL().getString("get_url");
        Response response=  given().relaxedHTTPSValidation().pathParams("username",username)
                .when().get(get_url);
        return response;
    }
    public  static Response updateuser(String username, User payload)
    {
        String update_url = getURL().getString("update_url");
        Response response=  given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParams("username",username)
                .body(payload)
                .when().put(update_url);
        return response;
    }

    public  static Response deleteuser(String username)
    {
        String delete_url = getURL().getString("delete_url");
        Response response=  given().relaxedHTTPSValidation().pathParams("username",username)
                .when().delete(delete_url);
        return response;
    }




}
