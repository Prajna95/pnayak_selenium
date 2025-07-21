import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class oAuth {


    @Test
    public void OauthTest()
    {
       String response = given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();
       System.out.println(response);
        JsonPath jsonpath =new JsonPath(response);
        String accesstoken = jsonpath.getString("access_token");


        GetCourse gc = given().queryParam("access_token", accesstoken)
                .when().log().all().get("\"https://rahulshettyacademy.com/oauthapi/getCourseDetails\"")
                .as(GetCourse.class);
       System.out.println(gc.getLinkdIn());
       System.out.println(gc.getInstructor());
       System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

        List<Api> apicourses = gc.getCourses().getApi();
        for (int i =0;i <apicourses.size();i++)
        {
            if (apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoupUI WebServices testing"))
            {
                System.out.println(apicourses.get(i).getCourseTitle());
            }
        }


        ///get the courses name of webautomation

       List <WebAutomation> wa =  gc.getCourses().getWebAutomation();
        for (int j= 0; j<wa.size();j++)
        {
            System.out.println(wa.get(j).getCourseTitle());
        }

    }
}
