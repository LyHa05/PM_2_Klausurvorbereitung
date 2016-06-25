package lydia.a02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import lydia.a01.Urheberrecht;

public class AutoDiebstahl {
	
	private Auto auto;
	/**Verwendung, falls kein Objekt existiert*/
	@SuppressWarnings("unused")
	private Class<?> autoKlasse;
	
	public AutoDiebstahl() {
		auto = new Auto("gruen", 75, 4);
		autoKlasse = this.getClass();
	}
	
	public void annotationAuslesen() {
		
		System.out.println("Name der Klasse: " + auto.getClass().getName());
		Annotation[] annosDerKlasse = auto.getClass().getAnnotations();
		for(Annotation annoDerKlasse : annosDerKlasse) {
			System.out.println("Annotationen der Klasse: " + annoDerKlasse);
			Class<? extends Annotation> annoType = annoDerKlasse.annotationType();
			System.out.println("Annotationstyp der Klasse: " + annoType);
		
		}
			Urheberrecht annoUrheber = auto.getClass().getDeclaredAnnotation(Urheberrecht.class);
			System.out.println("Verursacher: " + annoUrheber.urheber() + " in " + annoUrheber.jahr());

	}

	public void methodenAusgeben() {
		Method[] methoden = auto.getClass().getDeclaredMethods();
		for(Method methode : methoden) {
			System.out.println("Methode: " + methode.getName());
			System.out.println(" Rückgabewert: " + methode.getReturnType());
			int modifier = methode.getModifiers();
						
			if (Modifier.isPrivate(modifier)) {
				System.out.println(" Modifier: private");
			} else if (Modifier.isPublic(modifier)) {
				System.out.println(" Modifier: public");
			} else {
				System.out.println(" Modifier: unbekannt");
			}
			
			Parameter[] methodenParameter = methode.getParameters();
			for(Parameter p : methodenParameter) {
				System.out.println(" Parameter: " + p);
			}
			
			System.out.println("\n");
			
		}
	}
	
	public void instanzVariablenAusgaben() throws IllegalArgumentException, IllegalAccessException {
		Field[] iVariablen = auto.getClass().getDeclaredFields();
		
		for(Field variable : iVariablen) {
			variable.setAccessible(true);
			System.out.println("Variablenname: " + variable.getName());
			System.out.println(" Wert: " + variable.get(auto));
		}
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		new AutoDiebstahl().annotationAuslesen();
		System.out.println("_________________________");
		new AutoDiebstahl().methodenAusgeben();
		System.out.println("_________________________");
		new AutoDiebstahl().instanzVariablenAusgaben();
	}
}
