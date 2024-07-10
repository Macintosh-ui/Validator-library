package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {

    @Test
    public void testStringValidationRequired() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        var actual = schema.isValid("");
        assertFalse(actual);
    }

    @Test
    public void testStringValidationMinLength() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        schema.minLength(3);
        var actual = schema.isValid("te");
        assertFalse(actual);
    }

    @Test
    public void testStringValidationContains() {
        var validator = new Validator();
        var schema = validator.string();
        schema.contains("q");
        var actual = schema.isValid("test");
        assertFalse(actual);
    }

    @Test
    public void testStringValidationReqTrue() {
        var validator = new Validator();
        var schema = validator.string();
        assertTrue(schema.isValid(""));
        schema.required();
        assertTrue(schema.isValid("test"));
    }

    @Test
    public void testStringValidationMinLengthTrue() {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        schema.minLength(-1);
        assertTrue(schema.isValid("test"));
        schema.minLength(10);
        assertTrue(schema.isValid("test|test|test"));
        schema.minLength(0);
        assertTrue(schema.isValid("test"));
    }

    @Test
    public void testStringValidationContainsTrue() {
        var validator = new Validator();
        var schema = validator.string();
        schema.contains("What ");
        assertTrue(schema.isValid("What does the fox say?"));
        schema.contains("oes th");
        assertTrue(schema.isValid("What does the fox say?"));
    }

    @Test
    public void numberValidatorRequired() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void numberValidatorRange() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        schema.range(0, 5);
        assertTrue(schema.isValid(3));
    }

    @Test
    public void numberValidatorPositive() {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        schema.positive();
        assertTrue(schema.isValid(1));
    }

    @Test
    public void mapRequired() {
        var validator = new Validator();
        var schema = validator.map();
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        assertTrue(schema.isValid(map));
    }

    @Test
    public void mapSize() {
        var validator = new Validator();
        var schema = validator.map();
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        schema.required();
        schema.sizeof(3);
        assertFalse(schema.isValid(map));
        map.put("key2", "value2");
        map.put("key3", "value3");
        assertTrue(schema.isValid(map));
        schema.sizeof(5);
        assertFalse(schema.isValid(map));
    }

    @Test
    public void mapShape() {
        var validator = new Validator();
        var validator1 = new Validator();
        var schema1 = validator1.string();
        schema1.required();
        var schema = validator.map();
        Map<String, BaseSchema<?>> schemas = new HashMap<>();
        schemas.put("first name", schema1);
        assertTrue(schema.isValid(schemas));
    }

    @Test
    public void mapShape2() {
        var validator = new Validator();
        var validator1 = new Validator();
        var schema1 = validator1.string();
        var schema2 = validator.number();
        schema2.required();
        schema2.positive();
        schema1.required();
        var schema = validator.map();
        Map<Object, BaseSchema<?>> schemas = new HashMap<>();
        schemas.put("first name", schema1);
        schemas.put(4, schema2);
        assertTrue(schema.isValid(schemas));
    }

    @Test
    public void mapShape3() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required());
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

    }

    @Test
    public void numberTest() {
        var v = new Validator();
        var schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

}
