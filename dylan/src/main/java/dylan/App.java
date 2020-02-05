package dylan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("I AM ONE OF 90");
        ArrayList<Volunteer> volunteers = loadInfo();
        volunteers.add(getVolunteer());
        saveInfo(volunteers);

    }

    public static Volunteer getVolunteer() {
        System.out.println("First Name: ");
        String firstName = in.nextLine();
        System.out.println("Last Name: ");
        String lastName = in.nextLine();
        System.out.println("Phone: ");
        String phone = in.nextLine();
        System.out.println("Email: ");
        String email = in.nextLine();
        System.out.println("Here are the options: ");
        System.out.println("---------------");
        System.out
                .println("Worship | Welocme | Production | Community Groups | Children's Ministry | Student Ministry");
        System.out.println("---------------");
        System.out.println("Which group are you interested in?: ");
        String group = in.nextLine();
        return new Volunteer(firstName, lastName, phone, email, group);
    }

    private static void saveInfo(ArrayList<Volunteer> volunteers) {
        try {
            FileOutputStream fileStream = new FileOutputStream("volunteers.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save volunteers.");
        }
    }

    public static ArrayList<Volunteer> loadInfo() {
        try {
            FileInputStream fileStream = new FileInputStream("volunteers.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Volunteer> volunteers = (ArrayList<Volunteer>) os.readObject();
            os.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Volunteer>();
        }
    }
}