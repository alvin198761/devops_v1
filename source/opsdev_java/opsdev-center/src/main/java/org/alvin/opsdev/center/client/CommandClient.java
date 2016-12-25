package org.alvin.opsdev.center.client;

import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.cmd.CmdRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public interface CommandClient {

    @POST("/api/cmd")
    Call<RunTask> exec(@Body CmdRequest request);

    @GET("/api/cmd/cancel")
    Call<RunTask> cancel(@Query("id") String id);

    @GET("/api/cmd/get")
    Call<RunTask> get(@Query("id") String id);
}
