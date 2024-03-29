package Guide.Model;

import Guide.UI.UI;

public class Employee {
    private int ID;
    private static int idCount = 0;
    private int number;
    private String name;
    private int experience;

    public Employee(int number, String name, int experience){
        this.ID = idCount;
        idCount++;
        this.number = number;
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getNumber() {
        return number;
    }

    public int getID(){
        return ID;
    }
    @Override
    public String toString() {
        return "Табельный номер: "+ID+". Имя: "+name+". Номер телефона: "+number+". Стаж: "+experience ;
    }
}
