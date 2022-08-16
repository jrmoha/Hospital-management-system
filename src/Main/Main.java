package Main;

import hospital.Hospital;
import hospital.Owner;

public class Main {

    public static void main(String arguments[]) {
        Owner owner = new Owner();
        Hospital h = new Hospital(owner);
        h.bookSession("ahmed", 50, "Alexnadria", "VIP", "Alaa");
//        h.CancelSession("Loris Moren", "Alaa");
//        h.CheckOut("Loris Morens");
    }

}
