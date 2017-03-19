package com.hybridappzone.dailynews;

/**
 * Created by Vasanth on 17-03-2017.
 */
import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class NewsController extends Application {

    public static final String TAG = NewsController.class.getSimpleName();

    private RequestQueue queue;
    private ImageLoader ImageLoader;

    private static NewsController controller;

    @Override
    public void onCreate() {
        super.onCreate();
        controller = this;
    }

    public static synchronized NewsController getPermission() {
        return controller;
    }

    public RequestQueue getRequestQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(getApplicationContext());
        }

        return queue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (ImageLoader == null) {
            ImageLoader = new ImageLoader(this.queue,
                    new BitmapCache());
        }
        return this.ImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (queue != null) {
            queue.cancelAll(tag);
        }
    }

}
