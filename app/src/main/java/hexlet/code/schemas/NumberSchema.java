package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super.addCondition(value -> !super.requiredStatus || value != null);
    }

    public NumberSchema required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> !super.requiredStatus || value != null);
        return NumberSchema.this;
    }

    public NumberSchema positive() {
        super.addCondition(value -> value >= 0);
        return NumberSchema.this;
    }

    public NumberSchema range(int min, int max) {
        super.addCondition(value -> value >= min && value <= max);
        return NumberSchema.this;
    }

}
