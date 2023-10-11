import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class PhoneBook {

    HashMap<String, ArrayList<Integer>> phoneBook;
    public PhoneBook(){
        phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String name, Integer number){
        ArrayList numbers;
        if (phoneBook.containsKey(name)){
            numbers = phoneBook.get(name);
        } else {
            numbers = new ArrayList<>();
            phoneBook.put(name, numbers);
        }
        numbers.add(number);
    }

    public void printPhoneBook() {
        for (String name : phoneBook.keySet()) {
            System.out.print(name + "- ");
            ArrayList numbers = phoneBook.get(name);

            for (Object number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook= new PhoneBook();
        Scanner menu = new Scanner(System.in);
        while (true){
            System.out.print("Введите: \n" +
                    "- 1 для ввода имени и номера телефона: \n" +
                    "- 2 для вывода телефонной киниги: \n" +
                    "- 3 для выхода: \n");
            int numberOfMenu = menu.nextInt();
            if (numberOfMenu == 1){
                Scanner inname = new Scanner(System.in);
                System.out.print("Введите имя: ");
                String name = inname.next();
                Scanner inPhoneNumber = new Scanner(System.in);
                System.out.print("Введите номер телефона: ");
                int phoneNumber = inPhoneNumber.nextInt();
                phoneBook.addPhoneNumber(name,phoneNumber);
            } else if (numberOfMenu == 2){
                phoneBook.printPhoneBook();
            } else if (numberOfMenu == 3) System.exit(0);


        }




    }
}
