package org.alvin.opsdev.center.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/20.
 */
@Component
public class RestfulClient {

    public <T> T getClient(String ip, int port, Class<T> clazz) {
        String endpoint = "http://%s:%d";
        endpoint = String.format(endpoint, ip, port);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging).retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(endpoint)
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(clazz);
    }
}
