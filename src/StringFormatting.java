public class StringFormatting {

    public String formatName(String name) {
        String formatted = name.toLowerCase();
        String formattedName = "";
        String[]words = formatted.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            formattedName = formattedName.concat(" ").concat(words[i]);
        }

        return formattedName.trim();
    }
    public String formatPhoneNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        return ("+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9));
    }

    public Sign parseInput(String input) {
        if (checkPhoneNumber(input)) {
            return Sign.NUMBER;
        }
        if (checkName(input)){
            return Sign.NAME;
        }
        return Sign.NONE;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public boolean checkName(String name) {
        String[] words = name.trim().split(" ");
        return (words.length == 3);
    }


}
