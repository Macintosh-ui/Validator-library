package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        addCondition("required", value -> value != null || !super.requiredStatus);
    }

    public MapSchema required() {
        setRequiredStatus(true);
        addCondition("required", value -> value != null || !super.requiredStatus);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition("sizeof", value -> value.size() >= size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> map) {
        addCondition("shape", value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid((String) obj);
        }));
        return this;
    }

}
