/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mostafa
 */
public class Session {

    private final String date;
    private double fees;
    private final Date dateF;
    private int PatientAge;

    protected Session(double fees, String date) throws ParseException {
        this.fees = fees;
        this.date = date;
        dateF = new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }

    protected String getDate() {
        return dateF.toLocaleString();
    }

    protected void setFess(double f) {
        fees = f;
    }

    protected double getFees() {
        return fees;
    }

    protected void setAge(int a) {
        PatientAge = a;
    }

    @Override
    public String toString() {
        return "The Session will be on : " + dateF.toGMTString() + "  The Patient's Age is " + PatientAge + "\nIt costs $" + getFees();
    }
}
