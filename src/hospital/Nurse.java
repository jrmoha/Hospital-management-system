package hospital;

public class Nurse extends Staff {

    private final long code;

    protected Nurse(String n, String bd, long code, Gender g) {
        super(n, bd, g);
        super.setType("Nurse");
        this.code = code;
        super.setCode(code);
        super.setGender(g);
        super.setSalary(1900.25);
    }

}
