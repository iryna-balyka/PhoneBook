import java.util.Arrays;

public class Processing {
    String result;
    public String NameSearch(String[][]book, String name){
        for (String[] strings : book) {
            if (strings == null) continue;
            if (name.equals(strings[0])) {
                result = "Есть такая запись: \n" + name + ":" + strings[1] + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit";
                return result;
            }
            if  (!name.equals(strings[0])) {
                result = "Введите, пожалуйста, номер";
            }
        }
        return result;
    }
    public String NumberSearch(String[][]book, String number){
        for (String[] strings : book) {
            if (strings == null) continue;
            if (number.equals(strings[1])) {
                result = "Есть такая запись: \n" + strings[0] + ":" + number + "\nВведите ФИО или номер, для вывода справочника - list, выход - exit";
            return result;}
            if (!number.equals(strings[0])) {
                result = "Введите, пожалуйста, ФИО";
            }
        }
        return result;
    }

}
