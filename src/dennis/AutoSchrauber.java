package dennis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AutoSchrauber {
	Auto auto = new Auto("Rot", 4, 100);
	Class<Auto> autoKlasse = Auto.class;

	public void printMethods() throws NoSuchMethodException, SecurityException {
		Method[] methoden = autoKlasse.getDeclaredMethods();
		for (Method m : methoden) {
			methodeAuslesen(m);
		}
	}

	private void methodeAuslesen(Method m) {
		m.setAccessible(true);
		int modifier = m.getModifiers();
		System.out.println("Methodenname: " + m.getName());
		printModifier(modifier);
		if (m.getAnnotations().length != 0) {
			System.out.println("Annotiert mit:");
			for (Annotation a : m.getDeclaredAnnotations()) {
				System.out.println(a.annotationType().getName());
			}
		}
		System.out.println("Return: " + m.getReturnType().getName() + "\n");
	}

	private void printModifier(int modifier) {
		if (Modifier.isPublic(modifier)) {
			System.out.println("Ist public");
		}
		if (Modifier.isPrivate(modifier)) {
			System.out.println("Ist private");
		}
		if (Modifier.isStatic(modifier)) {
			System.out.println("Ist static");
		}
	}

	public void printAnnotation() {
		for (Annotation anno : autoKlasse.getAnnotations()) {
			System.out.println(anno.getClass().getName());
		}
		Urheberrecht u = autoKlasse.getDeclaredAnnotation(Urheberrecht.class);
		System.out.println("Urheber: " + u.name());
		System.out.println("Jahr: " + u.jahr());
	}

	public void printFields() throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = autoKlasse.getDeclaredFields();
		for(Field f:fields){
			f.setAccessible(true);
			System.out.println("Fieldname: " + f.getName());
			printModifier(f.getModifiers());
			System.out.println("Wert: " + f.get(auto));
		}
	}

//	public void printConstructors() {
//		Constructor<Auto> ac = autoKlasse.getConstructor(String.class, int.class, int.class);
//	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {
		AutoSchrauber as = new AutoSchrauber();
		as.printMethods();
		as.printFields();
		as.printAnnotation();
	}
}
