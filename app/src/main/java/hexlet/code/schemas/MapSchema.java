package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public BaseSchema<Map> required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> value != null || !super.requiredStatus);
        return MapSchema.this;
    }

    public BaseSchema<Map> sizeOf(int size) {
        super.addCondition(value -> value.size() >= size);
        return MapSchema.this;
    }

    public BaseSchema<Map> shape(Map<String, BaseSchema<String>> map) {
        super.addCondition(value -> map.entrySet().stream().allMatch(k -> {
            Object obj = value.get(k.getKey());
            return k.getValue().isValid((String) obj);
        }));
        return MapSchema.this;
    }

}
