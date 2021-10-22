package com.mo.sms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2021/10/22
 */
public class BaseContextHandler {
    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal();

    public BaseContextHandler() {
    }

    public static void set(String key, Long value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "0" : String.valueOf(value));
    }

    public static void set(String key, String value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "" : value);
    }

    public static void set(String key, Boolean value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "false" : value.toString());
    }

    public static Map<String, String> getLocalMap() {
        Map<String, String> map = (Map)THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap(10);
            THREAD_LOCAL.set(map);
        }

        return (Map)map;
    }

    public static void setLocalMap(Map<String, String> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static String get(String key) {
        Map<String, String> map = getLocalMap();
        return (String)map.getOrDefault(key, "");
    }

    public static Long getUserId() {
        Object value = get("userid");
        return NumberHelper.longValueOf0(value);
    }

    public static void setUserId(Long userId) {
        set("userid", userId);
    }

    public static void setUserId(String userId) {
        setUserId(NumberHelper.longValueOf0(userId));
    }

    public static String getAccount() {
        Object value = get("account");
        return returnObjectValue(value);
    }

    public static void setAccount(String name) {
        set("account", name);
    }

    public static String getName() {
        Object value = get("name");
        return returnObjectValue(value);
    }

    public static void setName(String account) {
        set("name", account);
    }

    public static String getToken() {
        Object value = get("token");
        return StrHelper.getObjectValue(value);
    }

    public static void setToken(String token) {
        set("token", token);
    }

    public static Long getOrgId() {
        Object value = get("orgid");
        return NumberHelper.longValueOf0(value);
    }

    public static void setOrgId(String val) {
        set("orgid", val);
    }

    public static Long getStationId() {
        Object value = get("stationid");
        return NumberHelper.longValueOf0(value);
    }

    public static void setStationId(String val) {
        set("stationid", val);
    }

    public static String getDatabase() {
        Object value = get("database_name");
        return StrHelper.getObjectValue(value);
    }

    public static void setDatabase(String val) {
        set("database_name", val);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? "" : value.toString();
    }

    public static void remove() {
        if (THREAD_LOCAL != null) {
            THREAD_LOCAL.remove();
        }

    }
}
