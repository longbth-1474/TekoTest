package longhoang.test.teko.data.model.api.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import longhoang.test.teko.data.model.api.AttributeSet;
import longhoang.test.teko.data.model.api.Brand;
import longhoang.test.teko.data.model.api.Color;
import longhoang.test.teko.data.model.api.Image;
import longhoang.test.teko.data.model.api.Price;
import longhoang.test.teko.data.model.api.ProductLine;
import longhoang.test.teko.data.model.api.Rating;
import longhoang.test.teko.data.model.api.SeoInfo;
import longhoang.test.teko.data.model.api.Status;

public class Product {
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("taxOut")
    @Expose
    private Object taxOut;
    @SerializedName("attributeGroups")
    @Expose
    private List<AttributeGroup> attributeGroups = null;
    @SerializedName("warranty")
    @Expose
    private Warranty warranty;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("promotionPrices")
    @Expose
    private Object promotionPrices;
    @SerializedName("promotions")
    @Expose
    private Object promotions;
    @SerializedName("flashSales")
    @Expose
    private Object flashSales;
    @SerializedName("attributeSet")
    @Expose
    private AttributeSet attributeSet;
    @SerializedName("magentoId")
    @Expose
    private Object magentoId;
    @SerializedName("seoInfo")
    @Expose
    private SeoInfo seoInfo;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("allActiveFlashSales")
    @Expose
    private Object allActiveFlashSales;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("productLine")
    @Expose
    private ProductLine productLine;
    @SerializedName("stocks")
    @Expose
    private Object stocks;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Object getTaxOut() {
        return taxOut;
    }

    public void setTaxOut(Object taxOut) {
        this.taxOut = taxOut;
    }

    public List<AttributeGroup> getAttributeGroups() {
        return attributeGroups;
    }

    public void setAttributeGroups(List<AttributeGroup> attributeGroups) {
        this.attributeGroups = attributeGroups;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

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

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
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
                "attributes=" + attributes +
                ", taxOut=" + taxOut +
                ", attributeGroups=" + attributeGroups +
                ", warranty=" + warranty +
                ", createdAt='" + createdAt + '\'' +
                ", displayName='" + displayName + '\'' +
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
                ", url=" + url +
                ", brand=" + brand +
                ", status=" + status +
                ", images=" + images +
                ", price=" + price +
                ", productLine=" + productLine +
                ", stocks=" + stocks +
                '}';
    }
}
