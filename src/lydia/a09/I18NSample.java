package lydia.a09;

import java.util.*;

public class I18NSample {

    static public void main(String[] args) {

//        String language;
//        String country;
//
//        if (args.length != 2) {
//            language = new String("en");
//            country = new String("US");
//        } else {
//            language = new String(args[0]);
//            country = new String(args[1]);
//        }

        
        Locale aLocale = new Locale("en","US");

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", aLocale);
        
        System.out.println(messages.getString("Begruessung"));
        System.out.println(messages.getString("Montag")); 
        System.out.println(messages.getString("Freitag"));}
    
}
