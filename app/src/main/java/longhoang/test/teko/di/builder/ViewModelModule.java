package longhoang.test.teko.di.builder;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import longhoang.test.teko.screen.activity.MainViewModel;
import longhoang.test.teko.di.TekoViewModelFactory;
import longhoang.test.teko.di.ViewModelKey;
import longhoang.test.teko.screen.fragment.screen_detail.DetailViewModel;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.DescViewModel;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.InfoViewModel;
import longhoang.test.teko.screen.fragment.screen_image.SlideViewModel;
import longhoang.test.teko.screen.fragment.screen_search.SearchViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(TekoViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel bindSearchViewModel(SearchViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindDetailViewModel(DetailViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SlideViewModel.class)
    abstract ViewModel bindSlideViewModel(SlideViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DescViewModel.class)
    abstract ViewModel bindDescViewModel(DescViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(InfoViewModel.class)
    abstract ViewModel bindInfoViewModel(InfoViewModel viewModel);
}
