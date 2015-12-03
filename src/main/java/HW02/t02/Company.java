package HW02.t02;
public class Company {

    private Employee[] employees;

    Company(Employee ... employees){
        this.employees = employees;
    }
    public Employee getEmployee(String name, String sName){
        for (Employee employee: employees){
            if(employee.getName().equals(name) && employee.getsName().equals(sName)) return employee;
        }
        return null;
    }
}
