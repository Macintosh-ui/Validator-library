package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super.addCondition("required", value -> !super.requiredStatus || !(value == null || value == ("")));
    }

    public StringSchema required() {
        super.setRequiredStatus(true);
        super.addCondition("required", value -> !super.requiredStatus || !(value == null || value == ("")));
        return StringSchema.this;
    }

    public StringSchema minLength(int length) {
        super.addCondition("minLength", value -> value.length() > length);
        return StringSchema.this;
    }

    public StringSchema contains(String search) {
        super.addCondition("contains", value -> value.contains(search));
        return StringSchema.this;
    }
}
