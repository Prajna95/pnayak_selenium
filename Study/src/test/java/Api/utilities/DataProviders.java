package Api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


 @DataProvider(name ="Data")
    public String[][] getAllData() throws IOException
 {
     String path = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";
     ExcelUtil xl = new ExcelUtil(path);
     int rownum = xl.getrowcount("UserData");
     int colnum = xl.getcellcount("UserData",1);
     String apidata[][] =new String[rownum][colnum];
     for (int i =1;i<=rownum;i++)
     {
         for (int j=0; j<colnum;j++)
         {
             apidata[i-1][j]=xl.getcelldata("Userdata",i,j);

         }
     }

     return apidata;
 }

    @DataProvider(name ="UserNames")
    public String[] getUserName() throws IOException
    {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";
        ExcelUtil xl= new ExcelUtil(path);
        int rownum = xl.getrowcount("UserData");
        String apidata[] =new String[rownum];
        for (int i =1;i<=rownum;i++)
        {
            apidata[i-1]=xl.getcelldata("Userdata",i,1);
        }

       return apidata;
    }



}
