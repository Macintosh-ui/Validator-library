package hexlet.code.schemas;

public class StringSchema {

    private boolean requiredStatus;
    private boolean minLengthStatus;
    private int minLength;
    private boolean containsStatus;
    private String subString;

    public StringSchema() { }

    public Boolean isValid(String text) {
        boolean condition1 = requiredCheck(text);
        boolean condition2 = minLengthCheck(text);
        boolean condition3 = containsCheck(text);
        return condition1 && condition2 && condition3;
    }

    public void required() {
        requiredStatus = true;
    }

    public void minLength(int length) {
        if (length <= 0) {
            minLengthStatus = false;
        } else {
            minLengthStatus = true;
            this.minLength = length;
        }
    }

    public void contains(String subString) {
        this.subString = subString;
        this.containsStatus = true;
    }

    private boolean containsCheck(String text) {
        if (!containsStatus || text.contains(subString)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean minLengthCheck(String text) {
        if (!minLengthStatus || text.length() > minLength) {
            return true;
        } else {
            return false;
        }
    }

    private boolean requiredCheck(String text) {
        if (!requiredStatus || !(text == null || text == (""))) {
            return true;
        } else {
            return false;
        }
    }
}
