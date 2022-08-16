/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author Mostafa
 */
public class Receptionist extends Staff {

    private final long code;

    protected Receptionist(String n, String bd, long code, Gender g) {
        super(n, bd, g);
        super.setType("Receptionist");
        this.code = code;
        super.setCode(code);
        super.setGender(g);
        super.setSalary(4500.2);
    }

}
