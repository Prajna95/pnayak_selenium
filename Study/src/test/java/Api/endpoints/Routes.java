package Api.endpoints;


/* swagger url: https://petstore.swagger.io/
post api :https://petstore.swagger.io/v2/user
get api: https://petstore.swagger.io/v2/user/{username}
delete api: https://petstore.swagger.io/v2//user/{username}
put api: https://petstore.swagger.io/v2//user/{username}
 */
public class Routes {



    public static String base_url= "https://petstore.swagger.io/v2";
    //user_model

    public static  String post_url = base_url + "/user";
    public  static String get_url = base_url +"/user/{username}";
    public  static  String  update_url = base_url + "/user/{username}";
    public  static  String delete_url = base_url + "/user/{username}";


    //store module
       // here we can add the urls

    // pet module
      //  here we can add the urls





}
