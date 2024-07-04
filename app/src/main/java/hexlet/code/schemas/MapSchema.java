package hexlet.code.schemas;

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

    public void shape(Map<String, BaseSchema<String>> map) {
        shapeStatus = true;
        super.addCondition(value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid(obj);
        }));
    }

}
