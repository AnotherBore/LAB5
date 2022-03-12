package model;

public abstract class Ship {
    public String name;
    public int maxSpeed;
    public int displacement;

    public abstract String getAbout();
    abstract String getType();

    public String getName(){
        return name;
    }
}
