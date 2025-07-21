package Files;

import io.restassured.path.json.JsonPath;

public class ComplexJson {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(payload.CourseDetails());

            //print no of courses in the api
           int count = js.getInt(("courses.size()"));
           System.out.println(count);

           //print the purchase amount

      int amount=  js.getInt("dashboard.purchaseAmount");
      System.out.println(amount);

      //print title of the 2nd course

        String titlename = js.getString("courses[2].title");
        System.out.println(titlename);

        //print all course with price

        for (int i =0; i<count; i ++)
        {
          String courseTitele=  js.get("courses["+i+"].title");
          System.out.println(js.get("courses["+i+"].price").toString());
          System.out.println(courseTitele);
        }

        System.out.println("print no of sold RPA Courses");
        for (int i =0; i<count; i ++) {
            String courseTitle = js.get("courses[" + i + "].title");
            if (courseTitle.equalsIgnoreCase("RPA")) {
               int copiesCount = js.get("courses[" + i + "].copies");
                System.out.println(copiesCount);
                break;
            }
        }


    }
}
