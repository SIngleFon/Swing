package Guide;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        // Инициализация справочника сотрудников
        GuideEmployee guideEmployee = new GuideEmployee();

        //Добавление сотрудников в справочник
        guideEmployee.addEmployee("Vasya", 799911122, 5);
        guideEmployee.addEmployee("Vasya", 799911122, 6);
        guideEmployee.addEmployee("Vasya1", 79412122, 3);
        guideEmployee.addEmployee("Vasya2", 794111411, 5);

        //Получение списка сотрудников getList()
        System.out.println("Получение списка сотрудников:\n" + String.join("\n", guideEmployee.getList().stream()
                .map(Employee::toString)
                .collect(Collectors.toList())));


        //Поиск сотрудника(ов) по стажу findEmployeeByExpirience(int expirience)
        System.out.println("\nПоиск сотрудника(ов) по стажу: \n" + String.join("\n", guideEmployee.findEmployeeByExpirience(5).stream()
                .map(Employee::toString)
                .collect(Collectors.toList())));

        //Поиск номера(ов) телефона(ов) по имени (кривое условие) findNumberByName(String name)
        System.out.println("\nПоиск номера(ов) телефона(ов) по имени: \n" + guideEmployee.findNumberByName("Vasya"));
        //Поиск СОТРУДНИКА(ов) по имени (ред.) findNumberByNameV2(String name)
        System.out.println("\nПоиск номера(ов) телефона(ов) по имени: \n" +  String.join("\n", guideEmployee.findNumberByNameV2("Vasya").stream()
                .map(Employee::toString)
                .collect(Collectors.toList())));

        //Поиск сотрудника по табельному номеру
        System.out.println("\nПоиск сотрудника по табельному номеру: \n" + guideEmployee.findEmployeeByID(1).toString());



//        List<String> names = new ArrayList<>();
//        names.add("Костя");
//        names.add("Аася");
//        names.add("Степан");
//        System.out.println(names);
//        System.out.println(reverseList(names));
//        System.out.println(sortByAlp(names));
//        System.out.println(sortByLenght(names));
//
//    }
//    private static List<String> sortByAlp(List<String> list){
//        return list.stream().sorted(Comparator.naturalOrder()).toList();
//    }
//    private static List<String> sortByLenght(List<String> list){
//        return list.stream().sorted((e1, e2) -> e1.length() - e2.length()).toList();
//    }
//    private static List<String> reverseList(List<String> list){
//        Collections.reverse(list);
//        return list;
//    }
    }
}