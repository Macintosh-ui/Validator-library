package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean nRequiredStatus;
    private boolean nPositiveStatus;
    private boolean nRangeStatus;
    private int min;
    private int max;
    private int checks;
    public boolean getCondition(Integer number) {
        boolean condition1 = requiredCheck(number);
        boolean condition2 = positiveCheck(number);
        boolean condition3 = rangeCheck(number);
        return condition1 && condition2 && condition3;
    }

    public void validate(int number) {
        while (checks !=3) {
            if (nRequiredStatus) {
                super.addCondition(requiredCheck(number));
                nRequiredStatus = false;
                checks++;
            } else if (nPositiveStatus) {
                super.addCondition(positiveCheck(number));
                nPositiveStatus = false;
                checks++;
            } else if (nRangeStatus) {
                super.addCondition(rangeCheck(number));
                nRangeStatus = false;
                checks++;
            } else {
                super.addCondition(true);
            }
        }
    }

    public void required() {
        this.nRequiredStatus = true;
    }

    public boolean requiredCheck(Integer number) {
        if (nRequiredStatus && number != null) {
            return true;
        } else if (!nRequiredStatus) {
            return true;
        } else {
            return false;
        }
    }

    public boolean positiveCheck(Integer number) {
        return !nPositiveStatus || number >= 0 && number != null;
    }
    public boolean rangeCheck(Integer number) {
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
