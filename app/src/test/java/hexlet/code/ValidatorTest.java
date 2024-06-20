package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {
    @Test //false impl
    public void testStringValidationRequired() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        var actual = schema.isValid("");
        assertEquals(false, actual);
    }
    @Test //false impl
    public void testStringValidationMinLength() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        schema.minLength(3);
        var actual = schema.isValid("te");
        assertEquals(false, actual);
    }
    @Test //false impl
    public void testStringValidationContains() {
        var validator = new Validator();
        var schema = validator.string();
        schema.contains("q");
        var actual = schema.isValid("test");
        assertEquals(false, actual);
    }
    @Test //true impl
    public void testStringValidationReqTrue() {
        var validator = new Validator();
        var schema = validator.string();
        assertEquals(true, schema.isValid(""));
        schema.required();
        assertEquals(true, schema.isValid("test"));
    }
    @Test
    public void testStringValidationMinLengthTrue() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        schema.minLength(-1);
        assertEquals(true, schema.isValid("test"));
        schema.minLength(10);
        assertEquals(true, schema.isValid("test|test|test"));
        schema.minLength(0);
        assertEquals(true, schema.isValid("test"));
    }
    @Test
    public void testStringValidationContainsTrue() {
        var validator = new Validator();
        var schema = validator.string();
        schema.contains("What ");
        assertEquals(true, schema.isValid("What does the fox say?"));
        schema.contains("oes th");
        assertEquals(true, schema.isValid("What does the fox say?"));
    }
}
