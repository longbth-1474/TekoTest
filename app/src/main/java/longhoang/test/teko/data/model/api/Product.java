package longhoang.test.teko.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("displayName")
    private String displayName;
    @SerializedName("color")
    private Color color;
    @SerializedName("tags")
    private List<Object> tags = null;
    @SerializedName("promotionPrices")
    private Object promotionPrices;
    @SerializedName("promotions")
    private Object promotions;
    @SerializedName("flashSales")
    private Object flashSales;
    @SerializedName("attributeSet")
    private AttributeSet attributeSet;
    @SerializedName("magentoId")
    private Object magentoId;
    @SerializedName("seoInfo")
    private SeoInfo seoInfo;
    @SerializedName("rating")
    private Rating rating;
    @SerializedName("allActiveFlashSales")
    private Object allActiveFlashSales;
    @SerializedName("sku")
    private String sku;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("brand")
    private Brand brand;
    @SerializedName("status")
    private Status status;
    @SerializedName("images")
    private List<Image> images = null;
    @SerializedName("price")
    private Price price;
    @SerializedName("productLine")
    private ProductLine productLine;
    @SerializedName("stocks")
    private Object stocks;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getPromotionPrices() {
        return promotionPrices;
    }

    public void setPromotionPrices(Object promotionPrices) {
        this.promotionPrices = promotionPrices;
    }

    public Object getPromotions() {
        return promotions;
    }

    public void setPromotions(Object promotions) {
        this.promotions = promotions;
    }

    public Object getFlashSales() {
        return flashSales;
    }

    public void setFlashSales(Object flashSales) {
        this.flashSales = flashSales;
    }

    public AttributeSet getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        this.attributeSet = attributeSet;
    }

    public Object getMagentoId() {
        return magentoId;
    }

    public void setMagentoId(Object magentoId) {
        this.magentoId = magentoId;
    }

    public SeoInfo getSeoInfo() {
        return seoInfo;
    }

    public void setSeoInfo(SeoInfo seoInfo) {
        this.seoInfo = seoInfo;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Object getAllActiveFlashSales() {
        return allActiveFlashSales;
    }

    public void setAllActiveFlashSales(Object allActiveFlashSales) {
        this.allActiveFlashSales = allActiveFlashSales;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Object getStocks() {
        return stocks;
    }

    public void setStocks(Object stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "displayName='" + displayName + '\'' +
                ", color=" + color +
                ", tags=" + tags +
                ", promotionPrices=" + promotionPrices +
                ", promotions=" + promotions +
                ", flashSales=" + flashSales +
                ", attributeSet=" + attributeSet +
                ", magentoId=" + magentoId +
                ", seoInfo=" + seoInfo +
                ", rating=" + rating +
                ", allActiveFlashSales=" + allActiveFlashSales +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", brand=" + brand +
                ", status=" + status +
                ", images=" + images +
                ", price=" + price +
                ", productLine=" + productLine +
                ", stocks=" + stocks +
                '}';
    }
}
