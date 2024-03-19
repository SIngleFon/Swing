package Guide.Controller;

import Guide.Model.Employee;
import Guide.UI.UI;

import java.util.ArrayList;
import java.util.List;

public class GuideEmployee {
    private List<Employee> list;
    UI ui;
    private Employee employee;
    public GuideEmployee(UI ui){
        list = new ArrayList<>();
        this.ui = ui;
        ui.setGuideEmployee(this);
    }

    public void addEmployee(String name, Integer number, Integer experience){
        list.add(new Employee(number, name, experience));
        ui.clearLog();
        for (Employee l : list){
            ui.appendLog(l.toString());
        }
//        ui.appendLog(list.get(list.size() - 1).toString());
    }
    public void getList(){
        ui.clearLog();
        for(Employee mpl : list){
            ui.appendLog(mpl.toString());
        }
    }
    public void findEmployeeByExperience(int experience){
        List<Employee> employees = new ArrayList<>();
        for(Employee mpl : list){
            if(mpl.getExperience() == experience){
                employees.add(mpl);
            }
        }
        appenderEmployees(employees);
    }
    public void findNumberByNameForUI(String name){
        List<Employee> employees = new ArrayList<>();
        for(Employee empl : list){
            if(empl.getName().equals(name)){
                employees.add(empl);
            }
        }
        appenderEmployees(employees);
    }
    public void appenderEmployees(List<Employee> list){
        if (list.isEmpty()){
            notFound();
        }else {
            ui.clearLog();
            for (Employee emp : list){
                ui.appendLog(emp.toString());
            }
        }
    }
    public void findEmployeeByID(int ID){
        for(Employee empl : list){
            if(empl.getID() == ID){
                ui.clearLog();
                ui.appendLog(empl.toString());
            }else{
                notFound();
            }
        }
    }
    public void notFound(){
        ui.clearLog();
        ui.appendLog("Сотрудников не найдено!");
    }
}
