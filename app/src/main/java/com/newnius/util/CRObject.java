package com.newnius.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * present an object without creating a new class
 * note: unable to present list now
 *
 * @author Newnius
 * @version 0.1.0(General)
 * Dependencies
 *   com.newnius.util.CRLogger
 */
public class CRObject {
    private static final String TAG = "CRObject";
    private CRLogger logger;
    private ConcurrentHashMap<String, String> data;

    public CRObject() {
        logger = CRLogger.getLogger(TAG);
        data = new ConcurrentHashMap<>();
    }

    public void unset(String key) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else {
            logger.warn(key + " not exist.");
        }
    }

    public void set(String key, String value) {
        if (data.containsKey(key)) {
            data.remove(key);
            logger.info(key + " is overwritten.");
        }
        data.put(key, value);
    }

    public void set(String key, Integer value) {
        if (data.containsKey(key)) {
            data.remove(key);
            logger.info(key + " is overwritten.");
        }
        data.put(key, value + "");
    }

    public void set(String key, Float value) {
        if (data.containsKey(key)) {
            data.remove(key);
            logger.info(key + " is overwritten.");
        }
        data.put(key, value + "");
    }

    public String get(String key) {
        if (data.containsKey(key))
            return data.get(key);
        logger.warn(key + " not exist.");
        return null;
    }

    public Integer getInt(String key) {
        try {
            if (data.containsKey(key))
                return Integer.parseInt(data.get(key));
            logger.warn(key + " not exist.");
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public Long getLong(String key) {
        try {
            if (data.containsKey(key))
                return Long.parseLong(data.get(key));
            logger.warn(key + " not exist.");
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public Float getFloat(String key) {
        try {
            if (data.containsKey(key))
                return Float.parseFloat(data.get(key));
            logger.warn(key + " not exist.");
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean hasKey(String key) {
        return data.containsKey(key);
    }

    @Override
    public String toString() {
        String str = "CRObject{\n";
        for (Map.Entry<String, String> entry : data.entrySet()) {
            str += "    " + entry.getKey() + "==>" + entry.getValue() + "\n";
        }
        str += "}";
        return str;
    }
}
