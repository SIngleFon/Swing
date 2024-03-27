package MontyHallParadox;
import lombok.Getter;
import lombok.Setter;
/**
 * Hello world!
 *
 */


import java.util.*;

public class App {

    @Getter
    @Setter
    public static class Result{
        private int wins;
        private int losses;
    }
    static Random random = new Random();
    public static void main(String[] args) {

        Boolean flag = false; //ФЛАГ ДЛЯ ОТОБРАЖЕНИЯ ШАГОВ!


        Map<Integer, Result> map = gameNotChange();
        Integer[] firstState = State(map, flag);
        System.out.println("Статистика для игрока, который не менял свой выбор:\n"
                + "Побед: " +firstState[0] + "\n"
                + "Поражений: "+firstState[1]);

        Map<Integer, Result> mapSecond = gameChange();
        Integer[] secondState = State(mapSecond, flag);
        System.out.println("Статистика для игрока, который поменял свой выбор:\n"
                + "Побед: " +secondState[0] + "\n"
                + "Поражений: "+secondState[1]);
    }
    public static Integer[] State(Map<Integer, Result> map, Boolean flag){
        Integer[] State = new Integer[2];
        int win = 0;
        int lose = 0;
        for (Map.Entry<Integer, Result> entry : map.entrySet()) {
            Result result = entry.getValue();
            win = win + result.getWins();
            lose = lose + result.getLosses();
            if(flag) {
                System.out.println("Шаг " + entry.getKey() + ": Победы - " + result.getWins() + ", Поражения - " + result.getLosses());
            }
        }
        State[0] = win;
        State[1] = lose;
        return State;
    }
    public static Map<Integer, Result> gameNotChange() {
        Map<Integer, Result> resultMap = new HashMap<Integer, Result>();

        for (int i = 1; i < 1001; i++) {
            Result result = new Result();
            //Дверь выбранная игроком
            int doorSelectedPlayer = random.nextInt(3)+1;
            //Дверь с выигрышным автомобилем
            int doorFromCar = random.nextInt(3)+1;

            if(doorSelectedPlayer == doorFromCar){
                result.setWins(result.getWins()+1);
            }else {
                result.setLosses(result.getLosses()+1);
            }
           resultMap.put(i, result);
        }
        return resultMap;
    };
    public static Map<Integer, Result> gameChange() {
        Map<Integer, Result> resultMap = new HashMap<Integer, Result>();
        for (int i = 1; i < 1001; i++) {
            Result result = new Result();
            //Дверь выбранная игроком
            int doorSelectedPlayer = random.nextInt(3)+1;
            //Дверь с выигрышным автомобилем
            int doorFromCar = random.nextInt(3)+1;
            //Дверь, которую откроет ведущий, где будет коза
            int openedDoor;
            do {
                openedDoor = random.nextInt(3) + 1;
            } while (openedDoor == doorFromCar | openedDoor == doorSelectedPlayer);

            //Дверь на которую участник поменяет свой выбор
            int newSelectedDoor;
            do {
                newSelectedDoor = random.nextInt(3) + 1;
            } while (newSelectedDoor == doorSelectedPlayer | newSelectedDoor == openedDoor);
            if(newSelectedDoor == doorFromCar){
                result.setWins(result.getWins()+1);
            }else {
                result.setLosses(result.getLosses()+1);
            }
            resultMap.put(i, result);
        }
        return resultMap;
    };
}
