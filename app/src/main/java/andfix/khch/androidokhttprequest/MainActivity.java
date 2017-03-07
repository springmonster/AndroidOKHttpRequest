package andfix.khch.androidokhttprequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wisetv.networklibrary.WTNetworkManager;
import com.wisetv.networklibrary.builder.WTNetworkConfig;
import com.wisetv.networklibrary.callback.WTStringResponseCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WTNetworkConfig.Builder builder =
                        new WTNetworkConfig.Builder()
                                .setContext(MainActivity.this)
                                .setLoggable(true);

                WTNetworkManager.initNetwork(builder.create())
                        .get()
                        .url("http://www.163.com")
                        .create()
                        .execute(new WTStringResponseCallback() {
                            @Override
                            protected void onStringResponseSuccess(String s) {
                                Log.d("khch", s);
                            }

                            @Override
                            protected void onStringResponseError(Throwable throwable) {

                            }
                        });
            }
        });
    }
}
