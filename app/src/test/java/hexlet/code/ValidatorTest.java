package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        var schema = validator.map();
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
        var schema = validator.map();
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        schema.required();
        schema.sizeof(3);
        assertEquals(false, schema.isValid(map));
        map.put("key2", "value2");
        map.put("key3", "value3");
        assertEquals(true, schema.isValid(map));
        schema.sizeof(5);
        assertEquals(false, schema.isValid(map));
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
        assertEquals(true, schema.isValid(schemas));
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
        assertEquals(true, schema.isValid(schemas));
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
        assertEquals(true, schema.isValid(human1)); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertEquals(false, schema.isValid(human2)); // false

    }
    @Test
    public void numberTest() {
        var v = new Validator();
        var schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(-10)); // false
        assertFalse(schema.isValid(0)); // false
        schema.range(5, 10);
        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
    }

}
