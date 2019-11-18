package roomDB;



public class DetailsModel {
    private String typeName , value ;

    public DetailsModel(String typeName, String value) {
        this.typeName = typeName;
        this.value = value;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getValue() {
        return value;
    }
}
