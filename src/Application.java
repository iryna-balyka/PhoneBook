import java.util.Arrays;
import java.util.Scanner;

public class Application {
    private String[][] book = new String[3][2];
    static boolean runFlag = true;
    String name = "";
    String number = "";
    String[] currentLine = null;
    StringFormatting stringFormatting = new StringFormatting();


    public void run() {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 0;
        System.out.println("Введите ФИО или номер, для вывода справочника введите list");
        while (runFlag) {
            String scan = scanner.nextLine();
            switch (scan) {
                case "list":
                    list(book);
                    System.out.println("Введите ФИО или номер, для вывода справочника введите list");
                    break;
                case "exit":
                    runFlag = false;
                    break;
                default:
                    switch (stringFormatting.parseInput(scan)) {
                        case NUMBER:
                            number = stringFormatting.formatPhoneNumber(scan);
                            String[] searchString;
                            if (currentLine == null) {
                                searchString = searchElement(book, number, 1);

                                if (searchString == null) {
                                    currentLine = new String[2];
                                    currentLine[1] = number;
                                    System.out.println("Введите, пожалуйста, ФИО");
                                    break;
                                } else {
                                    System.out.println("Есть такая запись: \n" + searchString[0] + ":" + searchString[1] + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit");
                                    currentLine = null;
                                }
                            } else {
                                searchString = searchElement(book, number, 1);
                                if (searchString == null) {
                                    currentLine[1] = number;
                                    book = add(book, currentLine, lineNumber);
                                    lineNumber++;
                                    currentLine = null;
                                } else {
                                    System.out.println("Есть такая запись: \n" + searchString[0] + ":" + searchString[1] + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit");
                                    currentLine = null;
                                }
                            }
                            break;


                        case NAME:
                            name = stringFormatting.formatName(scan);
                            if (currentLine == null) {
                                searchString = searchElement(book, name, 0);
                                if (searchString == null) {
                                    currentLine = new String[2];
                                    currentLine[0] = name;
                                    System.out.println("Введите, пожалуйста, номер");
                                    break;
                                } else {
                                    System.out.println("Есть такая запись: \n" + searchString[0] + ":" + searchString[1] + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit");
                                    currentLine = null;
                                }
                            } else {
                                searchString = searchElement(book, name, 0);
                                if (searchString == null) {
                                    currentLine[0] = name;
                                    book = add(book, currentLine, lineNumber);
                                    lineNumber++;
                                    currentLine = null;
                                } else {
                                    System.out.println("Есть такая запись: \n" + searchString[0] + ":" + searchString[1] + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit");
                                    currentLine = null;
                                }
                            }

                            break;
                        case NONE:
                            System.out.println("Проверьте правильность ввода и повторите");
                            break;
                    }

            }
        }
    }

    public String[][] add(String[][] book, String[] currentLine, int lineNumber) {
        if (lineNumber == book.length - 1) {
            book = bookExtend(book);
        }
        book[lineNumber] = currentLine;
        System.out.println("Записал");
        System.out.println("Введите ФИО или номер, для вывода справочника введите list");
        return book;
    }

    private void list(String[][] book) {
        for (String[] strings : book) {
            if (strings == null) continue;
            else
                System.out.println(strings[0] + ":" + strings[1]);
        }
    }

    public static String[][] bookExtend(String[][] book) {
        String[][] book1 = new String[book.length * 2][2];
        for (int i = 0; i < book1.length; i++) {
            for (int j = 0; j < 2; j++) {
                book1[i][j] = "";
            }
        }
        book1 = Arrays.copyOf(book, book1.length);
        return book1;
    }

    public static String[] searchElement(String[][] book, String name, int position) {
        String[] result = new String[2];
        for (String[] strings : book) {
            if (strings == null) continue;
            if (name.equals(strings[position])) {
                return strings;
            } else {
                result = null;
            }

        }
        return result;
    }

}
