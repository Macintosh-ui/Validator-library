package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public BaseSchema<Integer> required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> !super.requiredStatus || value != null);
        return NumberSchema.this;
    }

    public BaseSchema<Integer> positive() {
        super.addCondition(value -> value >= 0);
        return NumberSchema.this;
    }

    public BaseSchema<Integer> range(int min, int max) {
        super.addCondition(value -> value >= min && value <= max);
        return NumberSchema.this;
    }

}
