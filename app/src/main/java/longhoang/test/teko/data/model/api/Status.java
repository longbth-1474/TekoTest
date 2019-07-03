package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("publish")
    private Boolean publish;
    @SerializedName("sale")
    private String sale;

    public Status() {
    }

    public Status(Boolean publish, String sale) {
        this.publish = publish;
        this.sale = sale;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
