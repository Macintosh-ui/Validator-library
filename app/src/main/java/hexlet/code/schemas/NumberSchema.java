package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public void required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> !super.requiredStatus || value != null);
    }

    public void positive() {
        super.addCondition(value -> value >= 0);
    }

    public void range(int min, int max) {
        super.addCondition(value -> value >= min && value <= max);
    }

}
