package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    private boolean requiredStatus;
    private boolean minLengthStatus;
    private boolean containsStatus;
    private int minLength;
    private String subString;
    private int checks;

    public StringSchema() { }

    public void required() {
        requiredStatus = true;
    }
    public boolean requiredCheck(String text) {
       return !requiredStatus || !(text == null || text == (""));
    }

    protected void validate(String text) {
        checks = 0;
        while (checks != 3) {
            if (requiredStatus) {
                super.addCondition(requiredCheck(text));
                if (!minLengthStatus == false && !containsStatus) {
                    break;
                }
                checks++;
                requiredStatus = false;
            } else if(minLengthStatus) {
                super.addCondition(minLengthCheck(text));
                checks++;
                if (!requiredStatus && !containsStatus) {
                    break;
                }
                minLengthStatus = false;
            } else if(containsStatus) {
                super.addCondition(containsCheck(text));
                checks++;
                if (!requiredStatus && !minLengthStatus) {
                    break;
                }
                containsStatus = false;
            } else {
                super.addCondition(true);
                checks++;
                break;
            }
        }
    }

    public void minLength(int length) {
        if (length <= 0) {
            this.minLengthStatus = false;
        } else {
            this.minLengthStatus = true;
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
}
