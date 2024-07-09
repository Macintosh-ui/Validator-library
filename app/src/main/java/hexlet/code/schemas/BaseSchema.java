package hexlet.code.schemas;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected List<Predicate<T>> conditions = new ArrayList<>();
    @Setter
    protected boolean requiredStatus;
    public void addCondition(Predicate<T> predicate) {
        conditions.add(predicate);
    }

    public boolean isValid(T obj) {
        if (obj == null) {
            return !requiredStatus;
        } else {
            return conditions.stream().allMatch(condition -> condition.test(obj));
        }
    }
}
