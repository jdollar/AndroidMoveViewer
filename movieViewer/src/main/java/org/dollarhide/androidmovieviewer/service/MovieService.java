package org.dollarhide.androidmovieviewer.service;

import android.app.Activity;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import org.dollarhide.androidmovieviewer.util.LoggingUtil;
import org.json.JSONObject;

public class MovieService extends BaseService {
    private static final String TAG = "MovieService";
    protected static String MOVIE_SERVICE_URL = "movie";

    public void getBasicInfo(Activity activity, int query, Response.Listener<JSONObject> basicInfoListener, Response.ErrorListener basicErrorListener) {
        Context baseContext = activity.getBaseContext();
        String url = getBaseUrl(baseContext) + MOVIE_SERVICE_URL + "/" + query + "?" + getApiKeyRequestParam(baseContext);

        LoggingUtil.logDebug(TAG, "Sending: " + url);

        JsonObjectRequest jsonObjectRequest;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, (String) null, basicInfoListener, basicErrorListener);

        getRequestQueue(activity).add(jsonObjectRequest);
    }
}
