package longhoang.test.teko.screen.fragment.screen_detail.screen_info;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.core.adapter.recycleview.BaseViewAdapter;
import longhoang.test.teko.core.adapter.recycleview.BindingViewHolder;
import longhoang.test.teko.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.test.teko.data.model.api.detail.AttributeGroup;
import longhoang.test.teko.databinding.FragmentInfoBinding;
import longhoang.test.teko.databinding.ItemInfoBinding;

public class InfoFragment extends BaseFragment<FragmentInfoBinding, InfoViewModel> {


    private static final String ATTRIBUTE_GROUP = "ATTRIBUTE_GROUP";
    private List<AttributeGroup> attributeGroups = new ArrayList<>();

    public static InfoFragment newInstance(List<AttributeGroup> attributeGroups) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ATTRIBUTE_GROUP, (ArrayList<? extends Parcelable>) attributeGroups);
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_info;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) return;
        attributeGroups = getArguments().getParcelableArrayList(ATTRIBUTE_GROUP);
        initRecyclerView();
    }

    private void initRecyclerView() {
        SingleTypeAdapter<AttributeGroup> adapter =
                new SingleTypeAdapter<>(getContext(), R.layout.item_info);
        adapter.set(attributeGroups);
        getViewDataBinding().recyclerShortInfo.setAdapter(adapter);
        adapter.setDecorator((holder, position, viewType) -> {
            ItemInfoBinding binding = (ItemInfoBinding) holder.getBinding();
            if (position == 0) {
                binding.relativeItem.setBackgroundResource(R.drawable.custom_info_first_row);
            } else if (position % 2 == 0) {
                binding.relativeItem.setBackgroundResource(R.drawable.custom_info);
            }
        });
    }
}
