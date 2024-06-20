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

    public void contains(String search) {
        this.subString = search;
        this.containsStatus = true;
    }

    private boolean containsCheck(String text) {
        return !containsStatus || text.contains(subString);
    }

    private boolean minLengthCheck(String text) {
        return !minLengthStatus || text.length() > minLength;
    }

    private boolean requiredCheck(String text) {
        return !requiredStatus || !(text == null || text == (""));
    }
}
