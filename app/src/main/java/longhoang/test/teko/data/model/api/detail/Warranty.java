package longhoang.test.teko.data.model.api.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Warranty {
    @SerializedName("months")
    @Expose
    private Integer months;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
