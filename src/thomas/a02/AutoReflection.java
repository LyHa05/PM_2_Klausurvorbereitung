package thomas.a02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import thomas.a01.Urheberrecht;

public class AutoReflection {
	private Auto auto;
	@SuppressWarnings("unused")
	private Class<?> autoKlasse;
	
	public AutoReflection(){
		auto = new Auto("Blau",100,4);
		autoKlasse = this.getClass();
	}
	
	public void methodenAuslesen(){
		Method[] methoden = auto.getClass().getDeclaredMethods();
		for (Method m:methoden){
			System.out.println("Methode: " + m.getName());
			printModifir(m.getModifiers());
			System.out.println(" Rückgabetyp: " + m.getReturnType());
		
			for(Parameter p : m.getParameters()) {
				System.out.println(" Parameter: " + p);
			}
			
			System.out.println("");
		}
	}

	
	public void printModifir(int modifier){
		if (Modifier.isPrivate(modifier)){
			System.out.println(" Private");		
		}else if (Modifier.isPublic(modifier)){
			System.out.println(" Public");
		}else if (Modifier.isProtected(modifier)){
			System.out.println(" Protected");
		}else if (Modifier.isStatic(modifier)){
			System.out.println(" Static");
		}else{
			System.out.println(" Nicht definiert");
		}
	}
	
	public void attributeAuslesen() throws IllegalArgumentException, IllegalAccessException {
		Field[] attribute = auto.getClass().getDeclaredFields();
		for(Field attribut: attribute){
			attribut.setAccessible(true);
			System.out.println("Attribut: " + attribut.getName());
			printModifir(attribut.getModifiers());
			System.out.println(" Wert: " + attribut.get(auto));
			System.out.println("");
		}
		
	}
	
	
	public void annotationenAuslesen() {
		Annotation[] annotations = auto.getClass().getAnnotations();
		for(Annotation annotation:annotations){
			System.out.println("Annotation: " + annotation);
			Class<? extends Annotation> annotationType = annotation.annotationType();
			System.out.println("Annotationstyp: " + annotationType);
			
		}
		
		Urheberrecht annotationUrheberrecht = auto.getClass().getDeclaredAnnotation(Urheberrecht.class);
		System.out.println("Verfasser: " + annotationUrheberrecht.name() + " in " + annotationUrheberrecht.jahr());
		System.out.println("");
	}
	
	

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		AutoReflection ar = new AutoReflection();
		ar.annotationenAuslesen();
		ar.methodenAuslesen();
		ar.attributeAuslesen();
	

	}


}
