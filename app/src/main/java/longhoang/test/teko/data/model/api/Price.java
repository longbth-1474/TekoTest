package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Price {
    @SerializedName("supplierSalePrice")
    private Object supplierSalePrice;
    @SerializedName("sellPrice")
    private Object sellPrice;

    public Price() {
    }

    public Object getSupplierSalePrice() {
        return supplierSalePrice;
    }

    public void setSupplierSalePrice(Object supplierSalePrice) {
        this.supplierSalePrice = supplierSalePrice;
    }

    public Object getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Object sellPrice) {
        this.sellPrice = sellPrice;
    }
}
