package model;

import java.util.ArrayList;

public class Seaport {
        String name;
        private ArrayList<Ship> ships = new ArrayList<>();

        public Seaport(String name) {
            this.name = name;
        }

        public void add(Ship ship) {
            ships.add(ship);
        }

        public void delete(int index) {
            ships.remove(index);
        }

        public int getSize(){
            return ships.size();
        }

        public String getName(){
            return this.name;
        }

        public ArrayList<Ship> getShips(){
            return ships;
        }

        public String searchByName(String name) {
            String answer = "";
            for (Ship ship : ships) {
                if (ship.name.contains(name))
                    answer += name + '\n';
            }
            if (answer.equals(""))
                return "Таких кораблей нет!";
            return "Корабли:\n" + answer;
        }

        public String getShipsInfo() {
            String answer = "";
            for (Ship ship : ships) {
                answer += ship.name + '\n';
            }
            if (answer.equals(""))
                return "Кораблей нет";
            else
                return answer;
        }
}
