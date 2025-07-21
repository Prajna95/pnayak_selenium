package Api.endpoints;

import Api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {



    public  static Response createuser(User payload)
    {
       Response response=  given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(payload).when().post(Routes.post_url);
       return response;
    }
    public  static Response getuser(String username)
    {
        Response response=  given().relaxedHTTPSValidation().pathParams("username",username)
                .when().get(Routes.get_url);

        return response;
    }
    public  static Response updateuser(String username, User payload)
    {
        Response response=  given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParams("username",username)
                .body(payload)
                .when().put(Routes.update_url);
        return response;
    }

    public  static Response deleteuser(String username)
    {
        Response response= given().relaxedHTTPSValidation().pathParams("username",username)
                .when().delete(Routes.delete_url);
        return response;
    }




}
