package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("averagePoint")
    private Object averagePoint;
    @SerializedName("voteCount")
    private Object voteCount;

    public Rating() {
    }

    public Rating(Object averagePoint, Object voteCount) {
        this.averagePoint = averagePoint;
        this.voteCount = voteCount;
    }

    public Object getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(Object averagePoint) {
        this.averagePoint = averagePoint;
    }

    public Object getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Object voteCount) {
        this.voteCount = voteCount;
    }
}
