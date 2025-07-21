package Api2.utilities;

import Api.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders1 {


    @DataProvider( name = "Data1")
    public String[][] getAllData() throws IOException
    {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";
        ExcelUtil xl = new ExcelUtil(path);
        int rownum = xl.getrowcount("StoreData");
        int colnum = xl.getcellcount("StoreData",1);
        String apidata[][] =new String[rownum][colnum];
        for (int i =1;i<=rownum;i++)
        {
            for (int j=0; j<colnum;j++)
            {
                apidata[i-1][j]=xl.getcelldata("StoreData",i,j);

            }
        }

        return apidata;
    }

    @DataProvider(name = "OrderId")
    public Object[][] getUserName() throws IOException
    {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";
        ExcelUtil xl= new ExcelUtil(path);
        int rownum = xl.getrowcount("StoreData");
        Object[][] apidata = new Object[rownum][1];
        for (int i =1;i<=rownum;i++) {
            apidata[i-1][0] = Integer.parseInt(xl.getcelldata("StoreData",i,0));
        }
        return apidata;


    }

}
