package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    private boolean requiredStatus;
    private boolean minLengthStatus;
    private boolean containsStatus;
    private int minLength;
    private String subString;
    private int checks;
    protected String text;

    public StringSchema() { }

    public void required1() {
        requiredStatus = true;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public void required() {
        requiredStatus = true;
        super.addCondition(value -> !requiredStatus || !(value == null || value == ("")));
    }

    public void minLength(int length) {
        if (length <= 0) {
            this.minLengthStatus = false;
        } else {
            this.minLengthStatus = true;
            this.minLength = length;
            super.addCondition(value -> !minLengthStatus || text.length() > minLength);
        }
    }

    public void contains(String search) {
        this.subString = search;
        this.containsStatus = true;
        super.addCondition(value -> !containsStatus || text.contains(subString));
    }
}
