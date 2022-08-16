package hospital;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Mostafa
 */
public abstract class Patient {

    private final String name;
    private final int age;
    private final long code;
    private final String address;
    private String diesease;
    private ArrayList<Session> sessions;
    private double sessions_fees;
    private File medical_history;
    private File Session_File;
    private Session s;

    protected Patient(String n, int a, long code, String ad) {
        name = n;
        age = a;
        this.code = code;
        address = ad;
        sessions_fees = 0;
        sessions = new ArrayList<>();
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected String getAddress() {
        return address;
    }

    protected void setDiesease(String d) {
        diesease = d;
    }

    protected void AddSession(Session s) {
        sessions.add(s);
    }

    protected long getCode() {
        return code;
    }
    protected String getDiesease() {
        return diesease;
    }

    

    protected void setSession(Session s) {
        this.s = s;
    }

    protected Session getSession() {
        return s;
    }

    protected void bookSession(Session session) {
        sessions_fees += session.getFees();
    }

    protected void cancelSession(Session session) {
        sessions_fees -= session.getFees();
    }

    protected double getSessionsFees() {
        for (Session s : sessions) {
            sessions_fees += s.getFees();
        }
        return sessions_fees;
    }

    protected void setMedical(File file) {
        medical_history = file;
    }

    protected void setSessionFile(File file) {
        Session_File = file;
    }

    protected File getSessionFile() {
        return Session_File;
    }

    protected void DeleteSessionFile() {
        Session_File.delete();
    }

    @Override
    public String toString() {
        String statement = Hospital.Type(name) + " Patient\nName :" + name + "\nAge = " + age + " ,Lives in " + address;
        return statement;
    }
}
