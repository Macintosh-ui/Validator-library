package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean nRequiredStatus;
    private boolean nPositiveStatus;
    private boolean nRangeStatus;

    public void required() {
        nRequiredStatus = true;
        super.addCondition(value -> !nRequiredStatus || value != null);
    }

    public void positive() {
        nPositiveStatus = true;
        super.addCondition(value -> !nPositiveStatus || value >= 0);
    }

    public void range(int min, int max) {
        nRangeStatus = true;
        super.addCondition(value -> !nRangeStatus || value >= min && value <= max);
    }

}
