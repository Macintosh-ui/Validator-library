package hexlet.code.schemas;

import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> conditions = new LinkedHashMap<>();
    @Setter
    protected boolean requiredStatus;

    public final void addCondition(String checkName, Predicate<T> predicate) {
        conditions.put(checkName, predicate);
    }

    public final boolean isValid(T obj) {
        if (obj == null) {
            return !requiredStatus;
        } else {
            return conditions.values().stream().allMatch(condition -> condition.test(obj));
        }
    }
}
