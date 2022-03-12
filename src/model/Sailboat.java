package model;

public class Sailboat extends Ship{
    public int mastHeight;

    public Sailboat(String name, int maxSpeed, int displacement, int mastHeight) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.displacement = displacement;
        this.mastHeight = mastHeight;
    }

    public String getAbout(){
        String answer = "";
        answer += ("Название:" + name + '\n');
        answer += ("Водоизмещение: " + displacement + '\n');
        answer += ("Максимальная скорость: " + maxSpeed + '\n');
        answer += ("Высота мачты: " + mastHeight + '\n');
        return answer;
    }

    public String getType(){
        return "Парусник";
    }
}
