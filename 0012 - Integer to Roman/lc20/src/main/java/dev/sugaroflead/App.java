package dev.sugaroflead;


public class App 
{
    public static void main( String[] args )
    {
        int num = 4567;
        System.out.println( (num /= 1000) );
    }

    public String intToRoman(int num) {
        String result = "";
        char thousands = (char)(num / 1000);
        char hundreds = (char)((num - thousands * 1000) / 100);
        char tens = (char)((num - thousands * 1000 - hundreds * 100) / 10);
        char ones = (char)(num % 10);

        result += getThousandsPlaceCharacters(thousands);
        result += getHundredsPlaceCharacters(hundreds);
        result += getTensPlaceCharacters(tens);
        result += getOnesPlaceCharacters(ones);

        return result;
    }

    private String getThousandsPlaceCharacters(char num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
            default:
                return "";
        }
    }

    private String getHundredsPlaceCharacters(char num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
            default:
                return "";
        }
    }

    private String getTensPlaceCharacters(char num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }

    private String getOnesPlaceCharacters(char num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }
}
