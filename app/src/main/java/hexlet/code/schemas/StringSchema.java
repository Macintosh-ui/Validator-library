package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() { }

    public BaseSchema<String> required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> !super.requiredStatus || !(value == null || value == ("")));
        return StringSchema.this;
    }

    public BaseSchema<String> minLength(int length) {
        super.addCondition(value -> value.length() > length);
        return StringSchema.this;
    }

    public void contains(String search) {
        super.addCondition(value -> value.contains(search));
    }
}
