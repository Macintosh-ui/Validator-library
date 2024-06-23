package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<T> {
    public static boolean requiredStatus;
    public static boolean sizeOfStatus;
    public static boolean shapeStatus;
    public static Map<?, ?> value;
    public static int size;

    public static boolean getCondition(Map<?, ?> value) {
        MapSchema.value = value;
        boolean condition1 = requiredCheck();
        boolean condition2 = sizeOfCheck();
        return condition1 && condition2;
    }
    public static boolean requiredCheck() {
        if (requiredStatus && value != null) {
            return true;
        } else if (!requiredStatus) {
            return true;
        } else {
            return false;
        }
    }
    public void shape() {
        shapeStatus = true;
    }
    public void required() {
        requiredStatus = true;
    }

    public void sizeOf(int size) {
        MapSchema.size = size;
        sizeOfStatus = true;
    }
    public static boolean sizeOfCheck() {
        if (sizeOfStatus && value.size() >= size) {
            return true;
        } else if (!sizeOfStatus) {
            return true;
        } else {
            return false;
        }
    }
}
