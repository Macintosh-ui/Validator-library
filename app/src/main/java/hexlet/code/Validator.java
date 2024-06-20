package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public StringSchema string() {
        BaseSchema.setStringSchemaExist(true);
        return new StringSchema();
    }

    public NumberSchema number() {
        BaseSchema.setNumberSchemaExist(true);
        return new NumberSchema();
    }
}
