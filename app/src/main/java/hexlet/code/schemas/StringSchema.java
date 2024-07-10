package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        addCondition("required", value -> !super.requiredStatus || !(value == null || value == ("")));
    }

    public StringSchema required() {
        setRequiredStatus(true);
        addCondition("required", value -> !super.requiredStatus || !(value == null || value == ("")));
        return this;
    }

    public StringSchema minLength(int length) {
        addCondition("minLength", value -> value.length() > length);
        return this;
    }

    public StringSchema contains(String search) {
        addCondition("contains", value -> value.contains(search));
        return this;
    }
}
