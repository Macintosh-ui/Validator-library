package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void numberValidatorRequired() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        assertEquals(true, schema.isValid(5));
        assertEquals(false, schema.isValid((Integer) null));
    }
    @Test
    public void numberValidatorRange() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        schema.range(0, 5);
        assertEquals(true, schema.isValid(3));
    }
    @Test
    public void numberValidatorPositive() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        schema.positive();
        assertEquals(true, schema.isValid(1));
    }
    @Test
    public void mapRequired() {
        var validator = new Validator();
        var schema = Validator.map();
        assertEquals(true, schema.isValid((Map<?, ?>) null));
        schema.required();
        assertEquals(false, schema.isValid((Map<?, ?>) null));
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        assertEquals(true, schema.isValid(map));
    }
    @Test
    public void mapSize() {
        var validator = new Validator();
        var schema = Validator.map();
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        schema.required();
        schema.sizeOf(3);
        assertEquals(false, schema.isValid(map));
        map.put("key2", "value2");
        map.put("key3", "value3");
        assertEquals(true, schema.isValid(map));
        schema.sizeOf(5);
        assertEquals(false, schema.isValid(map));
    }
}
