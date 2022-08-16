package hospital;

import hospital.Staff.Gender;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public final class Hospital {

    private final String name;
    private final String address;
    private final Owner owner;
    private final String DateEstablished;
    private static ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Session> sessions;
    private ArrayList<Staff> staff;

    public Hospital(Owner o) {
        owner = o;
        name = "Hope";
        address = "Alexandria";
        DateEstablished = "1/9/1900";
        setDoctors();
        setSessions();
        setStaff();
        try {
            setPatients();
        } catch (IOException e) {
            System.err.println("Error Occured" + e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private void setStaff() {
        staff = new ArrayList() {
            {
                add(new CEO("Cleveland Morgan", "5/2/1949", 11223344, Gender.Male));
                add(new Receptionist("Alicia Powell", "10/7/1995", 10000009, Gender.Female));
                add(new Nurse("Neel King", "8/5/1986", 30365611, Gender.Male));
                add(new Nurse("Taha Clarke", "1/1/1994", 30365612, Gender.Male));
                add(new Nurse("Paloma Malone", "5/12/1980", 30365613, Gender.Female));
                add(new Nurse("Sahar Roche", "9/8/1994", 30365614, Gender.Female));
                add(new Nurse("Kara Reeve", "27/11/1994", 30365615, Gender.Female));
                add(new Nurse("Nikola Molin", "20/11/1962", 30365616, Gender.Female));
                add(new Nurse("Angelo Davis", "8/6/1986", 30365617, Gender.Male));
                add(new Workers("Carmel Patterson", "5/1/1999", 30365713, Gender.Male));
                add(new Workers("Mandeep Howarth", "5/2/1990", 30365813, Gender.Female));
                add(new Workers("Oscar Mcclain", "15/1/2000", 30369613, Gender.Male));
                add(new Workers("Antoinette Franco", "7/9/1994", 30353613, Gender.Female));
                add(new Workers("Samir Wickens", "2/21/1989", 30365223, Gender.Male));
                add(new Workers("Samir Younes", "7/21/1970", 30362413, Gender.Male));
                add(new Workers("Cole Mills", "15/12/1980", 30367843, Gender.Male));
                add(new Workers("Beth Salas", "29/9/1976", 30365743, Gender.Male));
                add(new Workers("Amelie Sutherland", "11/11/2001", 30396313, Gender.Female));
                add(new Workers("Ellie-May Bauer", "4/10/1980", 30365923, Gender.Female));
                add(new Workers("Ali Ahmed", "1/11/1969", 30365741, Gender.Male));
            }
        };
        staff.forEach((s) -> {
            AddStaffFile(s.Code());
        });
    }

    private long generateId() {
        Random r = new Random();
        long id = 3164891 + r.nextInt(100000);
        return id;
    }

    public boolean InsertNewStaff(String name, String type, String birthday, Gender g) {
        long code = generateId();
        boolean added = false;
        Staff s = null;
        if (type.equalsIgnoreCase("nurse")) {
            s = new Nurse(name, birthday, code, Gender.Male);
        }
        if (type.equalsIgnoreCase("accountant")) {
            s = new Accountant(name, birthday, code, g);
        }
        if (type.equalsIgnoreCase("receptionist")) {
            s = new Receptionist(name, birthday, code, g);
        }
        if (type.equalsIgnoreCase("workers")) {
            s = new Workers(name, birthday, code, g);
        }
        if (s != null) {
            AddStaff(s);
            AddStaffFile(code);
            added = true;
        }
        return added;
    }

    private void setPatients() throws IOException {
        Patient p1 = new RegularPatient("Lachlan Lister", 60, 550, "Ekrodence");
        Patient p2 = new VipPatient("Rosalind Webster", 30, 551, "Andmouth");
        Patient p3 = new RegularPatient("Raja Stanton", 43, 552, "Ulburgh");
        Patient p4 = new VipPatient("Ryder Dyer", 55, 553, "Zrita");
        Patient p5 = new VipPatient("Ryder Lachlan", 54, 554, "Strathe");
        Patient p6 = new VipPatient("Adrienne Pollard", 25, 555, "Yhathe");
        Patient p7 = new RegularPatient("Mice Raja", 10, 556, "Piham");
        patients = new ArrayList() {
            {
                add(p1);
                add(p2);
                add(p3);
                add(p4);
                add(p5);
                add(p6);
                add(p7);

            }
        };
        for (Patient p : patients) {
            AddPatientFile(p.getCode(), "Samy");
        }
    }

    private void AddPatient(String name, int age, String add, String type, String docName) throws IOException {
        long code;
        code = (patients.get(patients.size() - 1).getCode()) + 1;
        Patient p = null;
        if (type.equalsIgnoreCase("regular")) {
            p = new RegularPatient(name, age, code, add);
        } else if (type.equalsIgnoreCase("vip")) {
            p = new VipPatient(name, age, code, add);
        }
        AddPatient(p);
        AddPatientFile(code, docName);
    }

    private void AddPatient(Patient p) {
        patients.add(p);
    }

    protected static String Type(String name) {
        String type = null;
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                if (p instanceof RegularPatient) {
                    type = "Regular";
                } else {
                    type = "Vip";
                }
            }
        }
        return type;
    }

    private void setDoctors() {
        Doctor d1 = new Doctor("Alaa", 112255, 20, "bones");
        Doctor d2 = new Doctor("Nada", 112256, 20, "bones");
        Doctor d3 = new Doctor("Hamdy", 112257, 20, "bones");
        Doctor d4 = new Doctor("Mahmoud", 112258, 20, "bones");
        Doctor d5 = new Doctor("Abdallaa", 112259, 20, "bones");
        Doctor d6 = new Doctor("Aly", 112260, 20, "bones");
        doctors = new ArrayList() {
            {
                add(d1);
                add(d2);
                add(d3);
                add(d4);
                add(d5);
                add(d6);
            }
        };
    }

    public boolean AddDoctor(String name, long id, int age, String specialliy) {
        boolean added = true;
        String idStr = String.valueOf(id);
        if (idStr.length() != 6) {
            added = false;
        } else {
            Doctor d;
            for (Doctor doc : doctors) {
                if (doc.getId() == id) {
                    added = false;
                    break;
                }
            }
            if (added) {
                d = new Doctor(name, id, age, specialliy);
                AddDoctor(d);
            }
        }
        return added;
    }

    public boolean bookSession(String pName, int age, String add, String type, String docName) {
        boolean booked = false;
        DateTimeFormatter dtf;
        LocalDate now, SessionDate;
        String date = null;
        Session s = null;
        File file;
        FileWriter writer;
        double cost = 0;
        try {
            dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            now = LocalDate.now();
            SessionDate = now.plusDays(5);
            date = dtf.format(SessionDate);
            s = new Session(80, date);
            file = new File("Sessions\\Doctor " + docName + "-" + SessionDate.getDayOfWeek() + ".txt");
            writer = new FileWriter(file);
            for (Doctor d : doctors) {
                if (docName.equalsIgnoreCase(d.getName())) {
                    AddPatient(pName, age, add, type, docName);
                    d.AddSession(s);
                    for (Patient p : patients) {
                        if (pName.equalsIgnoreCase(p.getName())) {
                            s.setAge(p.getAge());
                            cost = calcFees(pName, s);
                            s.setFess(cost);
                            try {
                                if (file.canWrite()) {
                                    writer.append(s.toString());
                                }
                            } catch (IOException e) {
                                System.err.println("Error" + e.getMessage());
                                booked = false;
                            } finally {
                                writer.close();
                            }
                            addSession(p.getCode(), s);
                            p.setSessionFile(file);
                            p.setSession(s);
                            addSession(s);
                            booked = true;
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println("Error Occured" + ex.getMessage());
            booked = false;
        } catch (ParseException e) {
            System.err.println("Error Occured");
            booked = false;
        } catch (NullPointerException e) {
            System.err.println("An UnExpected Error Occured");
            booked = false;
        }
        if (booked) {
            JOptionPane.showMessageDialog(null, "Session has been booked!\nThe Session will be on " + date + "\nCost = " + cost, "Booked Succesfully", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "An Error Occured", "Please Try Again!", JOptionPane.ERROR_MESSAGE);
        }
        return booked;
    }

    public void CancelSession(String pName, String docName) {
        File file;
        Session s;
        boolean canceld = false;
        for (Patient p : patients) {
            if (pName.equalsIgnoreCase(p.getName())) {
                s = p.getSession();
                p.DeleteSessionFile();
                CancelSession(p.getCode(), s);
                CancelSession(s);
                canceld = true;
                break;
            }
        }
        if (canceld) {
            JOptionPane.showMessageDialog(null, "The Session Has Been Canceld Sucessfuly", "GoodBye", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addSession(long code, Session s) {
        for (Patient p : patients) {
            if (code == p.getCode()) {
                p.bookSession(s);
                break;
            }
        }
    }

    private void CancelSession(long code, Session s) {
        for (Patient p : patients) {
            if (code == p.getCode()) {
                p.cancelSession(s);
                break;
            }
        }
    }

    private boolean AddPatientFile(long code, String docName) throws IOException {
        boolean added = false;
        File file;
        FileWriter writer = null;
        for (Patient p : patients) {
            if (code == p.getCode()) {
                try {
                    file = new File("Patietns\\" + p.getName() + "-" + p.getCode() + ".txt");
                    writer = new FileWriter(file);
                    if (file.canWrite()) {
                        writer.append(p.toString() + "\nDoctor " + docName);
                        added = true;
                        break;
                    }
                } catch (IOException e) {
                    System.err.println("Error while writing");
                } finally {
                    writer.close();
                }
                break;
            }
        }
        return added;
    }

    private boolean AddStaffFile(long code) {
        boolean added = false;
        File file;
        FileWriter writer = null;
        for (Staff s : staff) {
            if (code == s.Code()) {
                try {
                    file = new File("Staff\\" + s.Code() + "-" + s.Type() + ".txt");
                    writer = new FileWriter(file);
                    if (file.canWrite()) {
                        writer.append(s.toString());
                        added = true;
                        break;
                    }
                } catch (IOException e) {

                } finally {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        added = false;
                    }
                }
                break;
            }
        }
        return added;
    }

    public void AddNewDoctor(String name, int age, String specallity) {
        long id;
        id = (doctors.get(doctors.size() - 1).getId()) + 1;
        Doctor d = new Doctor(name, id, age, specallity);
        AddDoctor(d);
    }

    private void AddDoctor(Doctor d) {
        doctors.add(d);
    }

    private void AddSession(String Doctorname, String date, double fees) {
        try {
            Session s = new Session(fees, date);
            for (Doctor d : doctors) {
                if (Doctorname.equalsIgnoreCase(d.getName())) {
                    d.AddSession(s);
                    break;
                }
            }
        } catch (ParseException p) {
            System.err.println("Error occured");
        }
    }

    public double getDoctorSalary(String name) {
        double salary = 0;
        for (Doctor d : doctors) {
            if (name.equalsIgnoreCase(d.getName())) {
                salary = d.CalcSalary();
                break;
            }
        }
        return salary;
    }

    private double calcFees(String pName, Session s) {
        double fees = 0;
        for (Patient p : patients) {
            if (pName.equalsIgnoreCase(p.getName())) {
                if (p instanceof RegularPatient) {
                    fees = s.getFees() + (s.getFees() * 0.14);
                } else if (p instanceof VipPatient) {
                    fees = s.getFees() + (s.getFees() * 0.4) + (s.getFees() * 0.14);
                }
                break;
            }
        }
        return fees;
    }

    public void DoctorsList() {
        doctors.forEach((d) -> {
            System.out.println("Name : " + d.getName() + ", Id : " + d.getId() + "\nAge is " + d.getAge() + " Speciallity in " + d.getSpeciallity());
        });
    }

    public void OwnerDetails() {
        System.out.println(owner);
    }

    private void AddStaff(Staff s) {
        staff.add(s);
    }

    private void setSessions() {
        sessions = new ArrayList<>();
    }

    private void addSession(Session s) {
        sessions.add(s);
    }

    private void CancelSession(Session s) {
        sessions.remove(s);
    }

    public boolean CheckOut(String fullName) {
        double fees = 0;
        boolean retval = false;
        for (Patient p : patients) {
            if (fullName.equalsIgnoreCase(p.getName())) {
                fees = p.getSessionsFees();
                retval = true;
                break;
            }
        }
        if (retval) {
            JOptionPane.showMessageDialog(null, "You Have to Pay $" + fees, "Thank You!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The Name doesn't exist", null, JOptionPane.ERROR_MESSAGE);
        }
        return retval;
    }

    @Override
    public String toString() {
        String s = "The " + name + " Hospital is in " + address + "\nEstablished in " + DateEstablished + "\nBelongs to the Owner : " + owner.getName();
        return s;
    }
}
