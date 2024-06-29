package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public boolean requiredStatus;
    public boolean sizeOfStatus;
    public boolean shapeStatus;
    public Map<?, ?> value;
    public int size;

    public boolean getCondition(Map<?, ?> value) {
        this.value = value;
        boolean condition1 = requiredCheck();
        boolean condition2 = sizeOfCheck();
        return condition1 && condition2;
    }
    public boolean requiredCheck() {
        if (requiredStatus && value != null) {
            return true;
        } else if (!requiredStatus) {
            return true;
        } else {
            return false;
        }
    }


    public boolean shape(Map<String, BaseSchema<?>> map) {
        shapeStatus = true;
        List<Boolean> conditions = new ArrayList<>();
        map.forEach((k, v) -> {
            var schema = map.get(k);
            var condition = schema.isValid(k);
            conditions.add(condition);
        });
         for (var cond : conditions) {
             if (cond == false) {
                 return false;
             }
         }
        return true;
    }

    public void required() {
        requiredStatus = true;
    }

    public void sizeOf(int size) {
        this.size = size;
        sizeOfStatus = true;
    }
    public boolean sizeOfCheck() {
        if (sizeOfStatus && value.size() >= size) {
            return true;
        } else if (!sizeOfStatus) {
            return true;
        } else {
            return false;
        }
    }
}
