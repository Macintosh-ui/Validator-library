package hexlet.code.schemas;

import java.util.Map;

public class BaseSchema<T> {
    private boolean stringSchemaExist;
    private boolean numberSchemaExist;
    private boolean mapSchemaExist;
    protected boolean sRequiredStatus;
    protected boolean sMinLengthStatus;
    protected boolean sContainsStatus;
    protected boolean nRequiredStatus;
    protected boolean nPositiveStatus;
    protected boolean rRangeStatus;

    public void setStringSchemaExist(boolean status) {
        this.stringSchemaExist = status;
    }
    public void setMapSchemaExist(boolean status) {
        this.mapSchemaExist = status;
    }
    public void setNumberSchemaExist(boolean condition) {
        this.numberSchemaExist = condition;
    }

    public boolean isValid() {

    }
}
