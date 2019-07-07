package longhoang.test.teko.data.network;


import java.io.IOException;

import javax.inject.Inject;

import longhoang.test.teko.utils.ConfigManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Inject
    ConfigManager mConfigManager;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
