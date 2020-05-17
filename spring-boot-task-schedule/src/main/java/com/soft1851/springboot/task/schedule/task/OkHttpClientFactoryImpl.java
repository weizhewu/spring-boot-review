package com.soft1851.springboot.task.schedule.task;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;


/**
 * @Author: zw_w
 * @Date: 2020/5/17 19:43
 * @Description:
 */
public class OkHttpClientFactoryImpl implements OkHttpClientFactory {
    @Override
    public OkHttpClient.Builder createBuilder(boolean disableSslValidation) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        ConnectionPool okHttpConnectionPool = new ConnectionPool(50, 30, TimeUnit.SECONDS);
        builder.connectionPool(okHttpConnectionPool);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        return builder;
    }
}
