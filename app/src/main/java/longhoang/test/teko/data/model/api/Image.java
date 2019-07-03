package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("url")
    private String url;
    @SerializedName("priority")
    private int priority;

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
