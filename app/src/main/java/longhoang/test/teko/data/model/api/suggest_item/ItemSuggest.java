package longhoang.test.teko.data.model.api.suggest_item;

public class ItemSuggest {
    private String image;
    private String name;
    private String newPrice;
    private String oldPrice;
    private String sale;

    public ItemSuggest(String image, String name, String newPrice, String oldPrice, String sale) {
        this.image = image;
        this.name = name;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
