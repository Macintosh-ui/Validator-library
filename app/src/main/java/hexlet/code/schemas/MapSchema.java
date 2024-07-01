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

    public void getCondition(Map<?, ?> value) {
        this.value = value;
        super.conditions.add(requiredCheck());
        super.conditions.add(sizeOfCheck());
        super.conditions.add(shape(value));
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


    public boolean shape(Map<?, ?> map) {
        shapeStatus = true;
        map.forEach((k, v) -> {
            var schema = map.get(k);
            var class1 = String.valueOf(schema.getClass());
            switch (class1) {
                case "StringSchema" -> {
                    var sSchema = new StringSchema();
                    sSchema.validate((String) v);
                }
                case "NumberSchema" -> {
                    var nSchema = new NumberSchema();
                    nSchema.getCondition((Integer) v);
                }
                case "MapSchema" -> {
                    var mSchema = new MapSchema();
                    mSchema.getCondition((Map<?, ?>) v);
                }
            }
        });
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
