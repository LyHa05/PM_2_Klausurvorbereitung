package lydia.a09;

import java.util.*;

public class I18NSample {

   static public void main(String[] args) {

      String language = "";
      String country = "";

      Locale currentLocale, aLocale, frLocale, deLocale;
      ResourceBundle messages;

      currentLocale = new Locale(language, country);
      aLocale = new Locale("en","US");
      frLocale = new Locale("fr","FR");
      deLocale = new Locale("de","DE");

      messages =
        ResourceBundle.getBundle("MessagesBundle_fr_FR",currentLocale);

      System.out.println(messages.getString("Begruessung"));
      System.out.println(messages.getString("Montag"));
      System.out.println(messages.getString("Freitag"));
   }
}