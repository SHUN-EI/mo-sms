package com.mo.sms.utils;

import java.util.function.Function;

/**
 * Created by mo on 2021/10/22
 */
public class NumberHelper {
    public NumberHelper() {
    }

    private static <T, R> R valueOfDef(T t, Function<T, R> function, R def) {
        try {
            return function.apply(t);
        } catch (Exception var4) {
            return def;
        }
    }

    public static Long longValueOfNil(String value) {
        return (Long)valueOfDef(value, (val) -> {
            return Long.valueOf(val);
        }, (Object)null);
    }

    public static Long longValueOf0(String value) {
        return (Long)valueOfDef(value, (val) -> {
            return Long.valueOf(val);
        }, 0L);
    }

    public static Long longValueOfNil(Object value) {
        return (Long)valueOfDef(value, (val) -> {
            return Long.valueOf(val.toString());
        }, (Object)null);
    }

    public static Long longValueOf0(Object value) {
        return (Long)valueOfDef(value, (val) -> {
            return Long.valueOf(val.toString());
        }, 0L);
    }

    public static Boolean boolValueOf0(Object value) {
        return (Boolean)valueOfDef(value, (val) -> {
            return Boolean.valueOf(val.toString());
        }, false);
    }

    public static Integer intValueOfNil(String value) {
        return (Integer)valueOfDef(value, (val) -> {
            return Integer.valueOf(val);
        }, (Object)null);
    }

    public static Integer intValueOf0(String value) {
        return intValueOf(value, 0);
    }

    public static Integer intValueOf(String value, Integer def) {
        return (Integer)valueOfDef(value, (val) -> {
            return Integer.valueOf(val);
        }, def);
    }

    public static Integer intValueOfNil(Object value) {
        return (Integer)valueOfDef(value, (val) -> {
            return Integer.valueOf(val.toString());
        }, (Object)null);
    }

    public static Integer intValueOf0(Object value) {
        return (Integer)valueOfDef(value, (val) -> {
            return Integer.valueOf(val.toString());
        }, 0);
    }

    public static Integer getOrDef(Integer val, Integer def) {
        return val == null ? def : val;
    }

    public static Long getOrDef(Long val, Long def) {
        return val == null ? def : val;
    }

    public static Boolean getOrDef(Boolean val, Boolean def) {
        return val == null ? def : val;
    }
}
