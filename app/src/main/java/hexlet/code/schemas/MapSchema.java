package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public boolean requiredStatus;
    public boolean sizeOfStatus;
    public boolean shapeStatus;

    public void required() {
        requiredStatus = true;
        super.addCondition(value -> value != null || !requiredStatus);
    }

    public void sizeOf(int size) {
        sizeOfStatus = true;
        super.addCondition(value -> value.size() >= size || !sizeOfStatus);
    }

    public boolean shape(Map<?, BaseSchema<?>> map) {
        shapeStatus = true;
        List<Boolean> checks = new ArrayList<>();
        map.forEach((k, v) -> {
            checks.add(super.isValid(k));
        });

        for (Boolean check : checks) {
            if (!check) {
                return false;
            }
        }
        return true;
    }

}
