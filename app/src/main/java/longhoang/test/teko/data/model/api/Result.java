package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("products")
    private List<Product> products = null;
    @SerializedName("keywords")
    private List<Object> keywords = null;
    @SerializedName("filters")
    private List<Object> filters = null;

    public Result() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Object> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }

    public List<Object> getFilters() {
        return filters;
    }

    public void setFilters(List<Object> filters) {
        this.filters = filters;
    }

    public Result(List<Product> products, List<Object> keywords, List<Object> filters) {
        this.products = products;
        this.keywords = keywords;
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "Result{" +
                "products=" + products +
                ", keywords=" + keywords +
                ", filters=" + filters +
                '}';
    }
}
