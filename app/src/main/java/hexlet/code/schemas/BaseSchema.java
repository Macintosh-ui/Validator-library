package hexlet.code.schemas;

public class BaseSchema {
    private static boolean stringSchemaExist;
    private static boolean numberSchemaExist;
    protected boolean sRequiredStatus;
    protected boolean sMinLengthStatus;
    protected boolean sContainsStatus;
    protected boolean nRequiredStatus;
    protected boolean nPositiveStatus;
    protected boolean rRangeStatus;

    public static void setStringSchemaExist(boolean status) {
        BaseSchema.stringSchemaExist = status;
    }

    public static void setNumberSchemaExist(boolean condition) {
        BaseSchema.numberSchemaExist = condition;
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
