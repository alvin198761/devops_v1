package org.alvin.opsdev.center.client;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public interface FileClient {

    @Multipart
    @POST("/upload")
    Call<Void> upload(@Part() MultipartBody.Part file);
//    @POST("/bigfile")
//    Call<Void> uploadFile (@Body BigFileRequest request);
}
