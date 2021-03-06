package com.wisetv.networklibrary.builder;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/**
 * Created by kuanghaochuan on 2017/2/17.
 */

public class WTNetworkConfig {
    private boolean isLoggable;
    private Context mContext;
    private Map<String, String> mHeaders = new HashMap<>();
    private int mTimeout = 5000;
    private HostnameVerifier mHostnameVerifier;
    private SSLSocketFactory mSSLSocketFactory;

    private WTNetworkConfig() {
    }

    public boolean isLoggable() {
        return isLoggable;
    }

    public Context getContext() {
        return mContext;
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public int getTimeout() {
        return mTimeout;
    }

    public HostnameVerifier getHostnameVerifier() {
        return mHostnameVerifier;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return mSSLSocketFactory;
    }

    public static class Builder {
        Context mContext = null;
        boolean isLoggable = false;
        Map<String, String> mHeaders;
        int mTimeout;
        HostnameVerifier mHostnameVerifier;
        SSLSocketFactory mSSLSocketFactory;

        public Builder setContext(Context context) {
            if (context == null) {
                throw new NullPointerException();
            }
            mContext = context;
            return this;
        }

        public Builder setLoggable(boolean loggable) {
            isLoggable = loggable;
            return this;
        }

        public Builder setHeaders(Map<String, String> headers) {
            mHeaders = headers;
            return this;
        }

        public Builder setTimeout(int timeout) {
            mTimeout = timeout;
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            mHostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory SSLSocketFactory) {
            mSSLSocketFactory = SSLSocketFactory;
            return this;
        }

        public WTNetworkConfig create() {
            WTNetworkConfig WTNetworkConfig = new WTNetworkConfig();
            applyConfig(WTNetworkConfig);
            return WTNetworkConfig;
        }

        private void applyConfig(WTNetworkConfig wtNetworkConfig) {
            wtNetworkConfig.mContext = this.mContext;
            wtNetworkConfig.isLoggable = this.isLoggable;
            wtNetworkConfig.mHeaders = this.mHeaders;
            wtNetworkConfig.mTimeout = this.mTimeout;
            wtNetworkConfig.mHostnameVerifier = this.mHostnameVerifier;
            wtNetworkConfig.mSSLSocketFactory = this.mSSLSocketFactory;
        }
    }
}
