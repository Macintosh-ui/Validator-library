package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    private static boolean requiredStatus;
    private static boolean minLengthStatus;
    private static boolean containsStatus;
    private static int minLength;
    private static String subString;

    public StringSchema() { }

    public boolean isValid(String text) {
        return super.isValid(text);
    }

    public static Boolean getCondition(String text) {
        boolean condition1 = requiredCheck(text);
        boolean condition2 = minLengthCheck(text);
        boolean condition3 = containsCheck(text);
        return condition1 && condition2 && condition3;
    }

    public void required() {
        super.sRequiredStatus = true;
        this.requiredStatus = true;
    }

    public void minLength(int length) {
        if (length <= 0) {
            super.sMinLengthStatus = false;
            this.minLengthStatus = false;
        } else {
            super.sMinLengthStatus = true;
            this.minLengthStatus = true;
            this.minLength = length;
        }
    }

    public void contains(String search) {
        this.subString = search;
        super.sContainsStatus = true;
        this.containsStatus = true;
    }

    private static boolean containsCheck(String text) {
        return !containsStatus || text.contains(subString);
    }

    private static boolean minLengthCheck(String text) {
        return !minLengthStatus || text.length() > minLength;
    }

    private static boolean requiredCheck(String text) {
        return !requiredStatus || !(text == null || text == (""));
    }
}
