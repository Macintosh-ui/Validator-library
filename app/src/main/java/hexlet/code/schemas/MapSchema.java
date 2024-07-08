package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public void required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> value != null || !super.requiredStatus);
    }

    public void sizeOf(int size) {
        super.addCondition(value -> value.size() >= size);
    }

    public void shape(Map<String, BaseSchema<String>> map) {
        super.addCondition(value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid((String) obj);
        }));
    }

}
