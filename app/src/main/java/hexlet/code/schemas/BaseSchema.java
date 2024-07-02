package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected List<Predicate> conditions = new ArrayList<>();

    public void addCondition(Predicate<T> predicate) {
        conditions.add(predicate);
    }

    public boolean isValid(Object obj) {
        return conditions.stream().allMatch(condition -> condition.test(obj));
    }
}
