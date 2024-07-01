package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class BaseSchema<T> {
    protected List<Boolean> conditions = new ArrayList<>();
    protected List<Boolean> conditions1;

    public void addCondition(Boolean condition) {
        conditions.add(condition);
    }

    public boolean isValid(Object obj) {

        if (obj instanceof String) {
            StringSchema sSchema = new StringSchema();
            sSchema.validate((String) obj);
        } else if (obj instanceof Integer) {
            NumberSchema nSchema = new NumberSchema();
            nSchema.validate((Integer) obj);
        }
        for(var condition : conditions) {
            if(!condition) {
                return false;
            }
        }
        return true;
    }
}
