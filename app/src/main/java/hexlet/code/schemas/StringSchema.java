package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    private boolean requiredStatus;
    private boolean minLengthStatus;
    private boolean containsStatus;
    private int minLength;
    private String subString;
    private int checks;

    public StringSchema() { }

    public void required1() {
        requiredStatus = true;
    }

    public BaseSchema<String> required() {
        requiredStatus = true;
        super.addCondition(value -> !requiredStatus || !(value == null || value == ("")));
        return StringSchema.this;
    }

    public BaseSchema<String> minLength(int length) {
        if (length <= 0) {
            this.minLengthStatus = false;
        } else {
            this.minLengthStatus = true;
            this.minLength = length;
            super.addCondition(value -> !minLengthStatus || value.length() > minLength);
        }
        return StringSchema.this;
    }

    public void contains(String search) {
        this.subString = search;
        this.containsStatus = true;
        super.addCondition(value -> !containsStatus || value.contains(subString));
    }
}
