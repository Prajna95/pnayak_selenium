package Api3.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PetData
{
    int id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;
    String status;

 @Data
 public  static  class Category
 {
     int id;
     String name;

 }

 @Data
    public static class Tag
 {
     int id;
     String name;
 }


}
