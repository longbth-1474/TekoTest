package longhoang.test.teko.data.model.api.detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SeoInfo implements Parcelable {
    @SerializedName("metaKeyword")
    private Object metaKeyword;
    @SerializedName("metaTitle")
    private Object metaTitle;
    @SerializedName("metaDescription")
    private Object metaDescription;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("description")
    private String description;

    public SeoInfo() {
    }

    public SeoInfo(Object metaKeyword, Object metaTitle, Object metaDescription, String shortDescription, String description) {
        this.metaKeyword = metaKeyword;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    protected SeoInfo(Parcel in) {
        shortDescription = in.readString();
        description = in.readString();
    }

    public static final Creator<SeoInfo> CREATOR = new Creator<SeoInfo>() {
        @Override
        public SeoInfo createFromParcel(Parcel in) {
            return new SeoInfo(in);
        }

        @Override
        public SeoInfo[] newArray(int size) {
            return new SeoInfo[size];
        }
    };

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(shortDescription);
        parcel.writeString(description);
    }
}
