package Guide;

import Guide.Controller.GuideEmployee;
import Guide.Model.Employee;
import Guide.UI.UI;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        GuideEmployee guideEmployee = new GuideEmployee(new UI());

        // Инициализация справочника сотрудников
//        GuideEmployee guideEmployee = new GuideEmployee();
//
//        //Добавление сотрудников в справочник
//        guideEmployee.addEmployee("Vasya", 799911122, 5);
//        guideEmployee.addEmployee("Vasya", 799911122, 6);
//        guideEmployee.addEmployee("Vasya1", 79412122, 3);
//        guideEmployee.addEmployee("Vasya2", 794111411, 5);
//
//        //Получение списка сотрудников getList()
//        System.out.println("Получение списка сотрудников:\n" + String.join("\n", guideEmployee.getList().stream()
//                .map(Employee::toString)
//                .collect(Collectors.toList())));
//
//
//        //Поиск сотрудника(ов) по стажу findEmployeeByExpirience(int expirience)
//        System.out.println("\nПоиск сотрудника(ов) по стажу: \n" + String.join("\n", guideEmployee.findEmployeeByExpirience(5).stream()
//                .map(Employee::toString)
//                .collect(Collectors.toList())));
//
//        //Поиск номера(ов) телефона(ов) по имени (кривое условие) findNumberByName(String name)
//        System.out.println("\nПоиск номера(ов) телефона(ов) по имени: \n" + guideEmployee.findNumberByName("Vasya"));
//        //Поиск СОТРУДНИКА(ов) по имени (ред.) findNumberByNameV2(String name)
//        System.out.println("\nПоиск номера(ов) телефона(ов) по имени: \n" +  String.join("\n", guideEmployee.findNumberByNameV2("Vasya").stream()
//                .map(Employee::toString)
//                .collect(Collectors.toList())));
//
//        //Поиск сотрудника по табельному номеру
//        System.out.println("\nПоиск сотрудника по табельному номеру: \n" + guideEmployee.findEmployeeByID(1).toString());
//
    }
}