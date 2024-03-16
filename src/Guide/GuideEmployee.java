package Guide;

import java.util.ArrayList;
import java.util.List;

public class GuideEmployee {
    private List<Employee> list;
    private Employee employee;
    GuideEmployee(){
        list = new ArrayList<>();
    }

    public void addEmployee(String name, Integer number, Integer expirience){
        list.add(new Employee(number, name, expirience));
    }
    public List<Employee> getList(){
        return list;
    }
    public List<Employee> findEmployeeByExpirience(int expirience){
        List<Employee> employees = new ArrayList<>();
        for(Employee empl : list){
            if(empl.getExperience() == expirience){
                employees.add(empl);
            }
        }
        return employees;
    }
    public List<Employee> findNumberByNameV2(String name){
        List<Employee> employees = new ArrayList<>();
        for(Employee empl : list){
            if(empl.getName().equals(name)){
                employees.add(empl);
            }
        }
        return employees;
    }
    public List<Integer> findNumberByName(String name){
        List<Integer> numbers = new ArrayList<>();
        for(Employee empl : list){
            if(empl.getName().equals(name)){
                numbers.add(empl.getNumber());
            }
        }
        return numbers;
    }
    public Employee findEmployeeByID(int ID){
        for(Employee empl : list){
            if(empl.getID() == ID){
                return empl;
            }
        }
        return null;
    }
}
