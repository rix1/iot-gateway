package xyz.rix1.iot_gateway.DDP;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import im.delight.android.ddp.MeteorCallback;
import im.delight.android.ddp.MeteorSingleton;
import im.delight.android.ddp.ResultListener;

/**
 * Created by rikardeide on 12/02/16.
 *
 */

public class MeteorHandler extends ContextWrapper implements MeteorCallback {


    public MeteorHandler(Context base, String url) {
        super(base);

        MeteorSingleton.createInstance(this, url);
//        MeteorSingleton.getInstance().setCallback(this);
    }

    @Override
    public void onConnect(boolean signedIn) {

        MeteorSingleton.getInstance().call("helloMeteor", new Object[]{"frank!"}, new ResultListener() {
            @Override
            public void onSuccess(String s) {
                Log.d("DDP", "Result: " + s);
            }

            @Override
            public void onError(String s, String s1, String s2) {
                Log.e("DDP", "ERR");
                Log.e("DDP", s);
            }
        });
    }


    @Override
    public void onDisconnect() {
        Log.d("DDP", "DISCONNECTING NOW");
    }

    @Override
    public void onException(Exception e) {
        Log.e("DDP", e.toString());
//        Log.e("DDP", e.getStackTrace().toString());

    }

    @Override
    public void onDataAdded(String s, String s1, String s2) {

    }

    @Override
    public void onDataChanged(String s, String s1, String s2, String s3) {

    }

    @Override
    public void onDataRemoved(String s, String s1) {

    }

}
