package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class SeoInfo {
    @SerializedName("metaKeyword")
    private Object metaKeyword;
    @SerializedName("metaTitle")
    private Object metaTitle;
    @SerializedName("metaDescription")
    private Object metaDescription;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("description")
    private Object description;

    public SeoInfo() {
    }

    public SeoInfo(Object metaKeyword, Object metaTitle, Object metaDescription, String shortDescription, Object description) {
        this.metaKeyword = metaKeyword;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public Object getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(Object metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public Object getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(Object metaTitle) {
        this.metaTitle = metaTitle;
    }

    public Object getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(Object metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }
}
