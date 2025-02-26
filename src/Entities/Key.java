package Entities;

public class Key extends Entity{
    private TypeOfKey typeOfKey ;
    Player player;

    public Key(TypeOfKey typeOfKey) {
        this.typeOfKey = typeOfKey;
    }
    @Override
    public String play() {
        return "";
    }

    public TypeOfKey getTypeOfKey() {
        return typeOfKey;
    }

    public void setTypeOfKey(TypeOfKey typeOfKey) {
        this.typeOfKey = typeOfKey;
    }
}
