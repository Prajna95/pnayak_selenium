package Api2.playload;

import lombok.Data;

@Data
public class StoreData {

    int id;
    int petId;
    Double quantity;
    String  shipDate;
    String status;
    Boolean complete;



}
