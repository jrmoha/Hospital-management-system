package hospital;

import java.util.ArrayList;

public class Doctor {

    private final String name;
    private final int age;
    private final long id;
    private final String speciallity;
    private final ArrayList<Session> sessions = new ArrayList<>();

    protected Doctor(String n, long id, int a, String s) {
        name = n;
        this.id = id;
        age = a;
        speciallity = s;
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected long getId() {
        return id;
    }

    protected String getSpeciallity() {
        return speciallity;
    }

    protected void AddSession(Session s) {
        sessions.add(s);
    }

    protected double CalcSalary() {
        double salary = 8000;
        double salaryAfterTax = salary;
        try {
            for (Session s : sessions) {
                salary += s.getFees();
            }
            salaryAfterTax = (salary) - (salary * 0.14);
        } catch (NullPointerException n) {
            System.out.println("Salary = $" + salary + "\nDoctor have taken zero sessions");
        }
        return salaryAfterTax;
    }

    @Override
    public String toString() {
        return "Doctor{" + "name=" + name + ", age=" + age + ", id=" + id + ", speciallity=" + speciallity + '}';
    }

}
