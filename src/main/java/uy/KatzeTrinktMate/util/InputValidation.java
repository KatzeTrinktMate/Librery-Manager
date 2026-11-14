package uy.KatzeTrinktMate.util;

public class InputValidation {
    //Validations if a number is minuse that zero
    public static boolean numNegative(Long n){
        return n < 0;
    }public static boolean numNegative(int n){
        return n < 0;
    }

    //Validations if a texts is empty or has spaces characters
    public static boolean emptyText(String text){
        return text == null || text.trim().isEmpty();
    }

}
