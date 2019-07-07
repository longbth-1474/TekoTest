package longhoang.test.teko.screen.fragment.screen_detail;

public interface DetailListener {
    void addItemInCart(DetailViewModel detailViewModel);

    void deleteItemInCart(DetailViewModel detailViewModel);

    void submitCart();

    void showCart();

    void onClickBack();
}
