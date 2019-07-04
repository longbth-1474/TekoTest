package longhoang.test.teko.data.model.api.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDetail {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("result")
    @Expose
    private Result result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "code='" + code + '\'' +
                ", result=" + result +
                '}';
    }
}
