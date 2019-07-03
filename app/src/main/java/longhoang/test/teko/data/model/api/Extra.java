package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Extra {
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("page")
    private int page;
    @SerializedName("pageSize")
    private int pageSize;

    public Extra() {
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "totalItems=" + totalItems +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
