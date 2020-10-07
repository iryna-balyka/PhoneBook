import java.util.Arrays;
import java.util.Scanner;

public class Application {
    private String[][] book = new String[3][2];
    static boolean runFlag = true;

    Processing processing = new Processing();
    StringFormatting stringFormatting = new StringFormatting();


    public void run(){
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 0;
        String number = "";
        String name = "";
        boolean isNumber = false;
        boolean isName = false;
        System.out.println("Введите ФИО или номер, для вывода справочника введите list");
        while (runFlag){
            String scan = scanner.nextLine();
            switch (scan) {
                case "list":
                    list(book);
                    isName = false;
                    isNumber = false;
                    System.out.println("Введите ФИО или номер, для вывода справочника введите list");
                    break;
                case "exit":
                    runFlag = false;
                    break;
                default:
                    switch (stringFormatting.parseInput(scan)) {
                        case NUMBER:
                            number = stringFormatting.formatPhoneNumber(scan);
                            isNumber = true;
                            break;
                        case NAME:
                            name = stringFormatting.formatName(scan);
                            isName = true;
                            break;
                        case NONE:
                            System.out.println("Проверьте правильность ввода и повторите");
                            break;
                    }
        }


//      Вывод имеющейся записи или создание новой
        if (isName&&isNumber) {
            if (lineNumber == book.length-1) {
                book = bookExtend(book);
            }
            String[] line = new String[2];
            line[0] = name;
            line[1] = number;
            book[lineNumber] = line;
            isName = false;
            isNumber = false;
            lineNumber++;
            System.out.println("Записал");
            System.out.println("Введите ФИО или номер, для вывода справочника введите list");

        } else {
            if (isName) {
                System.out.println(processing.NameSearch(book, name));
                isNumber = false;
            } else {
                if (isNumber) {
                    System.out.println(processing.NumberSearch(book, number));
                    isName = false;
                }
            }
        }
    }
    }

    private void list(String[][] book) {
        for (String[] strings : book) {
            if (strings == null) continue;
            else
            System.out.println(strings[0] + ":" + strings[1]);
        }
    }

    public static String[][] bookExtend(String[][] book) {
        String[][] book1 = new String[book.length*2][2];
        for (int i = 0; i < book1.length; i++){
            for (int j = 0; j < 2; j++) {
                book1[i][j] = "";
            }
        }
        book1 = Arrays.copyOf(book, book1.length);
        return book1;
    }
}
