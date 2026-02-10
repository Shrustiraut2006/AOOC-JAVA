class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;
    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }
    public double calculateBonus() {
        return salary * 0.10;
    }
    public void performanceReport() {
        System.out.println(jobTitle + " Performance: Satisfactory");
    }
    public void manageProjects() {
        System.out.println(jobTitle + " is managing general tasks.");
    }
}
class Manager extends Employee {
    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }
    @Override
    public double calculateBonus() {
        return salary * 0.20;
    }
    @Override
    public void manageProjects() {
        System.out.println("Manager is managing company projects.");
    }
}

class Developer extends Employee {
    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }
    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }
    @Override
    public void performanceReport() {
        System.out.println("Developer Performance: Excellent coding skills.");
    }
}
class Programmer extends Employee {
    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }
    @Override
    public double calculateBonus() {
        return salary * 0.12;
    }
    @Override
    public void performanceReport() {
        System.out.println("Programmer Performance: Meets deadlines efficiently.");
    }
}
public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", "New York", 80000);
        Employee developer = new Developer("Bob", "California", 70000);
        Employee programmer = new Programmer("Charlie", "Texas", 60000);
        manager.performanceReport();
        System.out.println("Manager Bonus: " + manager.calculateBonus());
        manager.manageProjects();
        System.out.println();
        developer.performanceReport();
        System.out.println("Developer Bonus: " + developer.calculateBonus());
        System.out.println();
        programmer.performanceReport();
        System.out.println("Programmer Bonus: " + programmer.calculateBonus());
    }
}
