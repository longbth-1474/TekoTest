package longhoang.test.teko.di.builder;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import longhoang.test.teko.MainViewModel;
import longhoang.test.teko.di.TekoViewModelFactory;
import longhoang.test.teko.di.ViewModelKey;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(TekoViewModelFactory factory);
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}
