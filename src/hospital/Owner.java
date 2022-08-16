package hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Owner {

    private final String name, gender, address, BirthDate = "12/10/1973";
    private int age;

    public Owner() {
        name = "Sara";
        gender = "Female";
        address = "Cairo";
        age = Age();

    }

    protected String getName() {
        return name;
    }

    private int Age() {
        String bd = BirthDate;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(bd, dtf);
        return (now.getYear()) - (date.getYear());

    }

    @Override
    public String toString() {
        String statement;
        if (Login()) {
            statement = "The Owner's Name is " + name + " She is " + age + "\nLives in " + address + "\nBorn In " + BirthDate;
        } else {
            statement = "You Don't have the permisson to access this information";
        }
        return statement;
    }

    private boolean Login() {
        Scanner sc = new Scanner(System.in);
        String userName, Password;
        System.out.println("Enter the Username");
        userName = sc.nextLine();
        System.out.println("Enter the Password");
        Password = sc.nextLine();
        return userName.equals("Admin") && Password.equals("Admin");
    }
}
