package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Color {
    @SerializedName("code")
    private Object code;
    @SerializedName("name")
    private Object name;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }
}
