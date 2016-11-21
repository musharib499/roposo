package roposo.musharib.com.roposomusharib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import roposo.musharib.com.roposomusharib.model.User;

/**
 * Created by gaadi on 21/11/16.
 */

public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if(extras.containsKey("position")){
               MainActivity mainActivity=new MainActivity();
                User user=(User) extras.getSerializable("db");
                mainActivity.followPosition=(int) extras.get("position");
                mainActivity.userData=user;//setFollow((int) extras.get("position"),user);
            }
        }
    }
}
