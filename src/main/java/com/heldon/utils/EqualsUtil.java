package com.heldon.utils;

import java.util.Objects;

/**
 * @author hcl
 * @version 1.0
 */
public class EqualsUtil {

    public static boolean eqFalse(Object obj) {
        return Boolean.FALSE.equals(obj);
    }

    public static boolean eqTrue(Object obj) {
        return Boolean.TRUE.equals(obj);
    }

    public static <T> boolean eq(T o1, T o2) {
        return Objects.equals(o1, o2);
    }

    public static <T> boolean notEq(T o1, T o2) {
        return !eq(o1, o2);
    }
}

