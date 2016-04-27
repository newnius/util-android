package com.newnius.util;

import android.os.AsyncTask;


/**
 * Do {@code whatToDo} in background and call {@code callback} when finished
 * Callback is called in UI thread
 *
 * @author Newnius
 * @version 0.1.0(Android)
 *
 * Dependencies:
 * com.newnius.util.CRLogger
 * com.newnius.util.CRWhatToDo
 * com.newnius.util.CRCallback
 */
public class CRBackgroundTask {
    private static final String TAG = "CRBackgroundTask";
    private static CRLogger logger = CRLogger.getLogger(TAG);
    private CRWhatToDo whatToDo;
    private CRCallback callback;

    public CRBackgroundTask(CRWhatToDo whatToDo, CRCallback callback) {
        this.whatToDo = whatToDo;
        this.callback = callback;
    }

    public void doInBackground() {
        new AsyncTask<Void, Void, CRMsg>() {
            @Override
            protected CRMsg doInBackground(Void... params) {
                try {
                    return whatToDo.doThis();
                } catch (Exception ex) {
                    logger.error(ex);
                    //@// FIXME: 16-4-23 should add this into a CRMsg and return CRMsg
                    return null;
                }
            }

            @Override
            protected void onPostExecute(CRMsg msg) {
                if (callback != null) {
                    callback.callback(msg);
                } else {
                    logger.warn("Callback not assigned!");
                }
            }
        }.execute();
    }

}
