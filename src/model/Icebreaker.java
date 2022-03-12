package model;

public class Icebreaker extends Ship{
    public int maxSpeedOnIce;

    public Icebreaker(String name, int maxSpeed, int displacement, int maxSpeedOnIce) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.displacement = displacement;
        this.maxSpeedOnIce = maxSpeedOnIce;
    }

    public String getAbout(){
        String answer = "";
        answer += ("Название: " + name + '\n');
        answer += ("Водоизмещение: " + displacement + '\n');
        answer += ("Максимальная скорость: " + maxSpeed + '\n');
        answer += ("Максимальная скорость на льду: " + maxSpeedOnIce + '\n');
        return answer;
    }

    public String getType(){
        return "Ледокол";
    }
}
