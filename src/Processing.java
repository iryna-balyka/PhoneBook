public class Processing {
    String result;
    public String PhoneSearch(String[][]book, String name){
        for (String[] strings : book) {
            if (name.equals(strings[0])) {
                result = (name + ":" + strings[1]);
            } else result = "Введите, пожалуйста, номер";
        }
        return result;
    }
    public String NumberSearch(String[][]book, String number){
        for (String[] strings : book) {
            if (number.equals(strings[1])) {
                result = strings[0] + ":" + number;
            } else result = "Введите, пожалуйста, номер";
        }
        return result;
    }

    public void add(String[][] book, String name, String number) {

    }
}
