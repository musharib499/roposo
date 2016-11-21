package roposo.musharib.com.roposomusharib.util;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import roposo.musharib.com.roposomusharib.R;

/**
 * Created by gaadi on 19/11/16.
 */

public class Util {

    public static void loadImage(Context context,String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .dontTransform()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
    public static JSONArray loadJSONFromAsset(Context context, String fileName) throws JSONException {
        String json = null;
        JSONArray jsonArray=null;

        try {
            InputStream is = context.getAssets().open(fileName+".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
         jsonArray=new JSONArray(json);
        return jsonArray;
    }


    public static RecyclerView recyclerView(RecyclerView recyclerView, Context context, boolean orientation) {
        LinearLayoutManager recycler_layout = new LinearLayoutManager(context);
        if (orientation)
            recycler_layout.setOrientation(LinearLayout.VERTICAL);
        else
            recycler_layout.setOrientation(LinearLayout.HORIZONTAL);

        recyclerView.setLayoutManager(recycler_layout);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }
}
