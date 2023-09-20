package com.helper.utils;

import net.serenitybdd.core.Serenity;

import java.util.ArrayList;
import java.util.List;

public class SerenitySessionUtils {
    public static <T> T getFromSession(String key) {
        return (T) Serenity.getCurrentSession().get(key);
    }

    public static void putOnSession(String key, Object object) {
        Serenity.getCurrentSession().put(key, object);
    }

    @SuppressWarnings("unchecked")
    public static void saveObjectInSerenityList(String key, Object obj) {
        if (!Serenity.getCurrentSession().containsKey(key)) {
            Serenity.getCurrentSession().put(key, new ArrayList<>());
        }
        ((List<Object>) Serenity.getCurrentSession().get(key)).add(obj);
    }
}
