package Files;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

 @Test
         public  void sumOfCourses() {

     int sum =0;
     JsonPath js = new JsonPath(payload.CourseDetails());
     int count = js.getInt(("courses.size()"));
     System.out.println(count);

     for (int i =0; i<count; i ++) {
         int price = js.get("courses[" + i + "].price");
         int copies = js.get("courses[" + i + "].copies");
         int amount = copies*price;
         System.out.println(amount);
         sum= sum + amount;

     }
     System.out.println(sum);

     int purchaseamount = js.getInt("dashboard.purchaseAmount");
     Assert.assertEquals(sum,purchaseamount);



 }
}
