package longhoang.test.teko.screen.fragment.screen_search;

import longhoang.test.teko.core.adapter.recycleview.BaseViewAdapter;
import longhoang.test.teko.data.model.api.Product;

public interface SearchNavigator extends BaseViewAdapter.Listener {
    void onClickProductListener(Product product);
}
