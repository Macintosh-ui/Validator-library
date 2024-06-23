package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private static boolean nRequiredStatus;
    private static boolean nPositiveStatus;
    private static boolean nRangeStatus;
    private static int min;
    private static int max;

    public static boolean getCondition(Integer number) {
        boolean condition1 = requiredCheck(number);
        boolean condition2 = positiveCheck(number);
        boolean condition3 = rangeCheck(number);
        return condition1 && condition2 && condition3;
    }
    @Override
    public boolean isValid(int number) {
        return super.isValid(number);
    }

    public void required() {
        this.nRequiredStatus = true;
    }

    public static boolean requiredCheck(Integer number) {
        if (nRequiredStatus && number != null) {
            return true;
        } else if (!nRequiredStatus) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean positiveCheck(Integer number) {
        return !nPositiveStatus || number >= 0 && number != null;
    }
    public static boolean rangeCheck(Integer number) {
        return !nRangeStatus || number < max;
    }
    public void positive() {
        this.nPositiveStatus = true;
    }

    public void range(int min, int max) {
        this.min = min;
        this.max = max;
        this.nRangeStatus = true;
    }
}
