package thomas.a09;

import java.util.Locale;
import java.util.ResourceBundle;

public class WochentageUebesetzer {

	String language = "";
	String country = "";

	public String getEnglisch(String wort) {
		Locale currentLocale, aLocale;
		ResourceBundle messages;
		currentLocale = new Locale(language, country);
		aLocale = new Locale("en", "US");

		messages = ResourceBundle.getBundle("MessagesBundle_en_US", currentLocale);
		
		System.out.println(messages.getString(wort));

		return messages.getString(wort);
	}
	
	 static public void main(String[] args) {
		 WochentageUebesetzer wtu = new WochentageUebesetzer();
		 
		 wtu.getEnglisch("Montag");
	 }
	
	
}
