package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class ProductSearch {
    @SerializedName("code")
    private String code;
    @SerializedName("result")
    private Result result;
    @SerializedName("extra")
    private Extra extra;

    public ProductSearch() {
    }

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

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "ProductSearch{" +
                "code='" + code + '\'' +
                ", result=" + result +
                ", extra=" + extra +
                '}';
    }
}
