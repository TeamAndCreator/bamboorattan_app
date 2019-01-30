package com.library.http.okhttp.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author kongminghui
 */
public abstract class BaseCallback<T> {
    /**
     * UI Thread
     *
     * @param request
     */
    public void onBefore(Request request, int id) {
    }

    /**
     * UI Thread
     *
     * @param
     */
    public void onAfter(int id) {
    }

    /**
     * UI Thread
     *
     * @param progress
     */
    public void inProgress(float progress, long total, int id) {

    }

    /**
     * if you parse reponse code in parseNetworkResponse, you should make this method return true.
     *
     * @param response
     * @return
     */
    public boolean validateReponse(Response response, int id) {
        return response.isSuccessful();
    }

    /**
     * Thread Pool Thread
     *
     * @param response
     * @param id
     * @return
     * @throws Exception
     */
    public abstract T parseNetworkResponse(Response response, int id) throws Exception;

    /**
     * @param call
     * @param e
     * @param id
     */
    public abstract void onError(Call call, Exception e, int id);

    /**
     * @param response
     * @param id
     */
    public abstract void onResponse(T response, int id);


    public static BaseCallback CALLBACK_DEFAULT = new BaseCallback() {

        @Override
        public Object parseNetworkResponse(Response response, int id) throws Exception {
            return null;
        }

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(Object response, int id) {

        }
    };

}