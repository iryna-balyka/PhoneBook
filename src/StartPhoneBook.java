import java.util.Scanner;

public class StartPhoneBook {

    public static void main(String[] args) {
        Processing processing = new Processing();
        StringFormatting stringFormatting = new StringFormatting();
        Scanner scanner = new Scanner(System.in);
        String[][] book = new book [3][2];
        String number = "";
        String name = "";
        System.out.println("Введите ФИО или номер");

//      Проверка введенной строки на значение и форматирование

        boolean isNumber = false;
        boolean isName = false;
        String scan = scanner.nextLine();
        if (stringFormatting.checkPhoneNumber(scan)) {
            number = stringFormatting.formatPhoneNumber(scan);
            isNumber = true;
        } else {
            if (!stringFormatting.checkName(scan) && !stringFormatting.checkPhoneNumber(scan)){
                System.out.println("Проверьте правильность ввода и повторите");
            } else {
                name = stringFormatting.formatName(scan);
                isName = true;
            }
            isNumber = false;
            }
//      Вывод имеющейся записи или создание новой
        if (isName){
            if (!isNumber) {
                processing.PhoneSearch(book, name);
            }
//                System.out.println("Введите, пожалуйста, номер");
            } else {
            if (isNumber) {
                processing.NumberSearch(book, number);

            }
        }

    }

    public static void list(String[][] book) {
        for (String[] strings : book) {
            System.out.println(strings[0] + ":" + strings[1]);
        }

    }
}
