package Api2.test;

import Api2.endpoints.StoreUrlDeatils;
import Api2.playload.StoreData;
import Api2.utilities.DataProviders1;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class StoreTest {

public static int createorderid;
    public Logger logger;
    @Test(priority = 1,dataProvider = "Data1", dataProviderClass = DataProviders1.class)

    public void storePostDetails(String id, String petId, String quantity, String shipDate, String status, String complete) {
        StoreData payload = new StoreData();
        payload.setId(Integer.parseInt(id));
        payload.setPetId(Integer.parseInt(petId));
        payload.setQuantity(Double.longBitsToDouble(Long.parseLong(quantity)));
        payload.setShipDate(shipDate);
        payload.setStatus(status);
        payload.setComplete(Boolean.valueOf(complete));

        Response response = StoreUrlDeatils.placeOrder(payload);
        response.then().log().all().extract().asPrettyString();
        Assert.assertEquals(response.getStatusCode(), 200);
        createorderid=response.jsonPath().getInt("id");
        System.out.println("Created order ID: " + createorderid);
    }

    @Test(priority = 2, dataProvider = "OrderId", dataProviderClass = DataProviders1.class)
    public  void storegetDeatils(int id)
    {

        Response response = StoreUrlDeatils.getStoreDta(id);
        response.then().log().all().extract().asPrettyString();
        System.out.println("Get order id: " + id);
        Assert.assertEquals(response.getStatusCode(),200);



    }

    @Test(priority = 3,dataProvider = "OrderId", dataProviderClass = DataProviders1.class)
    public void storedeleteDeatils(int  id)

    {

        Response response = StoreUrlDeatils.deleteStoreData(id);
        response.then().log().all().extract().asPrettyString();
        Assert.assertEquals(response.getStatusCode(),200);

    }

}
