package Pojo;

import java.util.List;

public class Demand_POSTAPI_IMS {


   Boolean allowPartialDemand;
   String referenceId;
    String tenantId;

    List<SkuRequestlist> skuRequestList;
   String requestId;

    public Boolean getAllowPartialDemand() {
        return allowPartialDemand;
    }

    public void setAllowPartialDemand(Boolean allowPartialDemand) {
        this.allowPartialDemand = allowPartialDemand;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<SkuRequestlist> getSkuRequestList() {
        return skuRequestList;
    }

    public void setSkuRequestList(List<SkuRequestlist> skuRequestList) {
        this.skuRequestList = skuRequestList;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public  static class SkuRequestlist
    {
       String nodeId;
       String skuId;
       int quantity;
       String imsBatch;

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getImsBatch() {
            return imsBatch;
        }

        public void setImsBatch(String imsBatch) {
            this.imsBatch = imsBatch;
        }
    }
}
