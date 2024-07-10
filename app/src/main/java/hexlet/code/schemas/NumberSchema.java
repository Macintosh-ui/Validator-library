package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super.addCondition("required", value -> !super.requiredStatus || value != null);
    }

    public NumberSchema required() {
        super.setRequiredStatus(true);
        super.addCondition("required", value -> !super.requiredStatus || value != null);
        return NumberSchema.this;
    }

    public NumberSchema positive() {
        super.addCondition("positive", value -> value > 0);
        return NumberSchema.this;
    }

    public NumberSchema range(int min, int max) {
        super.addCondition("range", value -> value >= min && value <= max);
        return NumberSchema.this;
    }

}
