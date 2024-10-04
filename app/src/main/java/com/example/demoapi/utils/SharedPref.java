package com.example.demoapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPref {


//public class SharedPref {
//    private static SharedPref instance;
//    private static SharedPreferences sharedPreferences;
//    private static SharedPreferences.Editor editor;
//    private static final String PREF_NAME = "OnBoarding"; // Change this to match your preference name
//
//    // Private constructor to restrict instantiation
//    private SharedPref(Context context) {
//        sharedPreferences = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//    }
//
//    // Singleton instance
//    public static  SharedPref getInstance(Context context) {
//        if (instance == null) {
//            instance = new SharedPref(context);
//        }
//        return instance;
//    }
//
//    // Method to save a boolean value
//    public void saveBoolean(String key, boolean value) {
//        editor.putBoolean(key, value);
//        editor.apply();
//    }
//
//    // Method to retrieve a boolean value
//    public boolean getBoolean(String key, boolean defaultValue) {
//        return sharedPreferences.getBoolean(key, defaultValue);
//    }
//
//    // Method to save a string value
//    public void saveString(String key, String value) {
//        editor.putString(key, value);
//        editor.apply();
//    }
//
//    // Method to retrieve a string value
//    public String getString(String key, String defaultValue) {
//        return sharedPreferences.getString(key, defaultValue);
//    }
//
//    // Method to save an integer value
//    public void saveInt(String key, int value) {
//        editor.putInt(key, value);
//        editor.apply();
//    }
//
//    // Method to retrieve an integer value
//    public int getInt(String key, int defaultValue) {
//        return sharedPreferences.getInt(key, defaultValue);
//    }
//
//    // Method to save a float value
//    public void saveFloat(String key, float value) {
//        editor.putFloat(key, value);
//        editor.apply();
//    }
//
//    // Method to retrieve a float value
//    public float getFloat(String key, float defaultValue) {
//        return sharedPreferences.getFloat(key, defaultValue);
//    }
//
//    // Method to save a long value
//    public void saveLong(String key, long value) {
//        editor.putLong(key, value);
//        editor.apply();
//    }
//
//    // Method to retrieve a long value
//    public long getLong(String key, long defaultValue) {
//        return sharedPreferences.getLong(key, defaultValue);
//    }
//
//    // Method to clear all preferences
//    public void clear() {
//        editor.clear();
//        editor.apply();
//    }
//
//    // Method to remove a specific key
//    public void remove(String key) {
//        editor.remove(key);
//        editor.apply();
//    }
//

        private static final String PREFERENCES_NAME = "OnBoarding";

        private static SharedPreferences getPrefs(Context context) {
            return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        }

        public static <T> void saveObject(Context context, String key, T value) {
            SharedPreferences prefs = getPrefs(context);
            SharedPreferences.Editor editor = prefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(value);
            editor.putString(key, json);
            editor.apply();
        }

        public static <T> T getObject(Context context, String key, Class<T> clazz) {
            SharedPreferences prefs = getPrefs(context);
            String value = prefs.getString(key, null);
            Gson gson = new Gson();
            if (value != null) {
                return gson.fromJson(value, clazz);
            } else {
                return null;
            }
        }

        public static void saveString(Context context, String key, String value) {
            SharedPreferences prefs = getPrefs(context);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(key, value);
            editor.apply();
        }

        public static String getString(Context context, String key, String defaultValue) {
            SharedPreferences prefs = getPrefs(context);
            return prefs.getString(key, defaultValue);
        }

        public static void saveBoolean(Context context, String key, boolean value) {
            SharedPreferences prefs = getPrefs(context);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }

        public static boolean getBoolean(Context context, String key, boolean defaultValue) {
            SharedPreferences prefs = getPrefs(context);
            return prefs.getBoolean(key, defaultValue);
        }

        public static void removeObject(Context context, String key) {
            SharedPreferences prefs = getPrefs(context);
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove(key);
            editor.apply();
        }
    }

