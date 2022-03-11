package model;


public class Steamboat extends Ship{
    public int enginePower;

    public Steamboat(String name, int maxSpeed, int displacement, int enginePower) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.displacement = displacement;
        this.enginePower = enginePower;
    }

    public String getAbout(){
        String answer = "";
        answer += ("Название:" + name + '\n');
        answer += ("Водоизмещение" + displacement + '\n');
        answer += ("Максимальная скорость" + maxSpeed + '\n');
        answer += ("Суммарная мощность двигателей" + enginePower + '\n');
        return answer;
    }

    public String getType(){
        return "Пароход";
    }
}
