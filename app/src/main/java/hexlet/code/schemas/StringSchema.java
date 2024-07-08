package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() { }

    public StringSchema required() {
        super.setRequiredStatus(true);
        super.addCondition(value -> !super.requiredStatus || !(value == null || value == ("")));
        return StringSchema.this;
    }

    public StringSchema minLength(int length) {
        super.addCondition(value -> value.length() > length);
        return StringSchema.this;
    }

    public StringSchema contains(String search) {
        super.addCondition(value -> value.contains(search));
        return StringSchema.this;
    }
}
