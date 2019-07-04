package longhoang.test.teko.data.model.api.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attribute {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("values")
    @Expose
    private List<Object> values = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}
