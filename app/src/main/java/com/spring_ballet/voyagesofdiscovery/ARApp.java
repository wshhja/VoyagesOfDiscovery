package com.spring_ballet.voyagesofdiscovery;

import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.util.Res;

import android.app.Application;

public class ARApp extends Application {

    public static final String APP_ID = "11243342";

    public static final String APP_KEY = "mXIA8T3e8xW0NVAPBsvlKmsM";

    public static final String SECRET_KEY = "DIWqGyAwQ15em9N78rxGlIiyZmtqrkvN";

    @Override
    public void onCreate() {
        super.onCreate();

        Res.addResource(this);
        // 设置App Id
        DuMixARConfig.setAppId(APP_ID);
        // 设置API Key
        DuMixARConfig.setAPIKey(APP_KEY);
        // 设置Secret Key
        DuMixARConfig.setSecretKey(SECRET_KEY);
    }
}
