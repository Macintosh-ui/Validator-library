package hexlet.code.schemas;

import java.util.Map;

public class BaseSchema {
    private static boolean stringSchemaExist;
    private static boolean numberSchemaExist;
    private static boolean mapSchemaExist;
    protected boolean sRequiredStatus;
    protected boolean sMinLengthStatus;
    protected boolean sContainsStatus;
    protected boolean nRequiredStatus;
    protected boolean nPositiveStatus;
    protected boolean rRangeStatus;

    public static void setStringSchemaExist(boolean status) {
        BaseSchema.stringSchemaExist = status;
    }
    public static void setMapSchemaExist(boolean status) {
        BaseSchema.mapSchemaExist = status;
    }
    public static void setNumberSchemaExist(boolean condition) {
        BaseSchema.numberSchemaExist = condition;
    }

    public boolean isValid(Map<?, ?> value) {
        if (mapSchemaExist) {
            return MapSchema.getCondition(value);
        } else {
            return false;
        }
    }

    public boolean isValid(String text) {
        if (stringSchemaExist) {
            return StringSchema.getCondition(text);
        } else
            return false;
    }

    public boolean isValid(int number) {
        if (numberSchemaExist) {
            return NumberSchema.getCondition(number);
        } else {
            return false;
        }
    }
}
