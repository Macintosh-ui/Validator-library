package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> value != null || !super.requiredStatus);
        return MapSchema.this;
    }

    public MapSchema sizeof(int size) {
        super.addCondition(value -> value.size() >= size);
        return MapSchema.this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> map) {
        super.addCondition(value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid((String) obj);
        }));
        return MapSchema.this;
    }

}
