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
public class Accountant extends Staff {

    private final long code;

    protected Accountant(String n, String bd, long code, Gender g) {
        super(n, bd, g);
        super.setType("Accountant");
        this.code = code;
        super.setCode(code);
        super.setGender(g);
        super.setSalary(36000.261);
    }

}
