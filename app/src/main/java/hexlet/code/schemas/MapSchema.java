package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        super.addCondition("required", value -> value != null || !super.requiredStatus);
    }

    public MapSchema required() {
        super.setRequiredStatus(true);
        super.addCondition("required", value -> value != null || !super.requiredStatus);
        return MapSchema.this;
    }

    public MapSchema sizeof(int size) {
        super.addCondition("sizeof", value -> value.size() >= size);
        return MapSchema.this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> map) {
        super.addCondition("shape", value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid((String) obj);
        }));
        return MapSchema.this;
    }

}
