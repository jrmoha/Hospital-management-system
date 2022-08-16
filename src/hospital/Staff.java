package hospital;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Staff {

    private final String name;
    private String type;
    private final String BirthDate;
    private long code;
    private double salary;
    private String gender;

    protected enum Gender {
        Male, Female
    };

    protected Staff(String n, String bd, Gender g) {
        name = n;
        BirthDate = bd;
        gender = g.toString();
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected void setCode(long code) {
        this.code = code;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    protected String getName() {
        return name;
    }

    protected int Age() {
        String[] bd = BirthDate.split("/");
        int year = Integer.parseInt(bd[2]);
        LocalDate date = LocalDate.now();
        return date.getYear() - year;
    }

    protected String Type() {
        return type;
    }

    protected long Code() {
        return code;
    }

    protected void setGender(Gender g) {
        gender = g.toString();
    }

    protected String Gender() {
        return gender;
    }

    protected double Salary() {
        double salaryAfterTaxes = (salary - 0.14 * salary);
        double salary = Double.parseDouble(new DecimalFormat("##.####").format(salaryAfterTaxes));
        return salary;
    }

    @Override
    public String toString() {
        String state = getName() + " Is A " + Type() + "\nGender : " + gender + "\nAge is " + Age() + "\nSalary = " + Salary();
        return state;
    }
}
