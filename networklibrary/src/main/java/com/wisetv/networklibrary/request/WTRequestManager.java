package com.wisetv.networklibrary.request;

import com.wisetv.networklibrary.builder.WTNetworkConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by kuanghaochuan on 2017/2/23.
 */

public class WTRequestManager {
    private static OkHttpClient sOkHttpClient;

    public WTRequestManager(WTNetworkConfig networkConfig) {
        createOkHttpClient(networkConfig);
    }

    public static OkHttpClient getOkHttpClient() {
        return sOkHttpClient;
    }

    private void createOkHttpClient(WTNetworkConfig networkConfig) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (networkConfig.getSSLSocketFactory() != null) {
            builder.sslSocketFactory(networkConfig.getSSLSocketFactory());
        }
        if (networkConfig.getHostnameVerifier() != null) {
            builder.hostnameVerifier(networkConfig.getHostnameVerifier());
        }

        sOkHttpClient = builder.connectTimeout(networkConfig.getTimeout(), TimeUnit.MILLISECONDS).build();
    }
}
