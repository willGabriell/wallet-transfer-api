package com.desafio_picpay.arq.util;

import java.util.Collection;
import java.util.Map;

public class ValidatorUtil {

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String) value).trim().isEmpty();
        } else if (value instanceof Collection<?>) {
            return ((Collection<?>) value).isEmpty();
        } else if (value instanceof Map<?,?>) {
            return ((Map<?, ?>) value).isEmpty();
        } else if (value instanceof Object[]) {
            return ((Object[]) value).length == 0;
        }
        return false;
    }

    public static boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

}
