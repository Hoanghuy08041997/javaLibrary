package Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;

public class SearchPredicate<T> implements Predicate<T> {
    private String property;
    private Object value;

    public SearchPredicate(String property, Object value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public boolean test(T obj) {
        try {
            Object propertyValue = obj.getClass().getMethod("get" + capitalize(property)).invoke(obj);
            return propertyValue.equals(value);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            return false;
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
