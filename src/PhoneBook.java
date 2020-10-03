import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [][] phonebook = new String[10][2];
        System.out.println("Введите ФИО или номер");
        boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = scanner.nextLine();
            isCorrectName = checkName(name);
            if (!isCorrectName) System.out.println("Введите корректное имя!");
        }
    }


    public static boolean checkPhoneNumber(String phoneNumber) {

        return true;
    }

    public static boolean checkName(String name) {
        String[] words = name.trim().split(" ");
        return (words.length == 3);
    }

    public static String formatName(String name) {
        String formatted = name.toLowerCase();
        String formattedName = "";
        String[]words = formatted.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            formattedName = formattedName.concat(" ").concat(words[i]);
        }

        return formattedName.trim();
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
