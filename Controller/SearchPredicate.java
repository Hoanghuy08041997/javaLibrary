package Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;

public class SearchPredicate<T> implements Predicate<T> {
    private final String property;
    private final String searchValue;

    public SearchPredicate(String property, String searchValue) {
        this.property = property;
        this.searchValue = searchValue;
    }

    @Override
    public boolean test(T obj) {
        try {
            Object propertyValue = obj.getClass().getMethod("get" + capitalize(property)).invoke(obj);
            return propertyValue != null && propertyValue.toString().contains(searchValue);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
                | InvocationTargetException e) {
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
