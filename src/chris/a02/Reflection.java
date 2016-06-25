package chris.a02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Reflection {
    private Auto meinTrabbi;
    private Class<?> skalpierterTrabbi;

    public Reflection(){
        meinTrabbi = new Auto("weiss", 45, 5);
        skalpierterTrabbi = meinTrabbi.getClass();
    }

    public static void main(String[] args){
        new Reflection().annotationenAusgeben();
        System.out.println("<><><><><><><><><><><><><><><><><>");
        new Reflection().attributeAusgeben();
        System.out.println("<><><><><><><><><><><><><><><><><>");
        new Reflection().methodenAusgeben();
        System.out.println("<><><><><><><><><><><><><><><><><>");
    }

    public void annotationenAusgeben(){
        Annotation[] annotationDerKlasse = skalpierterTrabbi.getDeclaredAnnotations();

        for(Annotation element : annotationDerKlasse){
            Class<? extends Annotation> annotation = element.annotationType();
            System.out.println("Annotation Type: " + annotation.toString());
        }
    }

    public void methodenAusgeben(){
        Method[] methodsDerKlasse = skalpierterTrabbi.getDeclaredMethods();

        for(Method element : methodsDerKlasse){
            System.out.print("Methoden: " + element.getName() + "(");
            Parameter[] parameterDerMethode = element.getParameters();
            for(Parameter para : parameterDerMethode){
                System.out.print(para + " ");
            }
            System.out.print(") \tReturn Type: " + element.getReturnType() + "\tSichtbarkeit: ");

            int modifier = element.getModifiers();

            if(Modifier.isPrivate(modifier)){
                System.out.print("private\n");
            } else if (Modifier.isProtected(modifier)){
                System.out.print("protected\n");
            } else if (Modifier.isPublic(modifier)){
                System.out.print("public\n");
            } else {
                System.out.print("unbekannt\n");
            }
        }
    }

    public void attributeAusgeben(){
        Field[] felderDerKlasse = skalpierterTrabbi.getDeclaredFields();

        for(Field element : felderDerKlasse){
            element.setAccessible(true);
            try {
                System.out.println("Varibale Name: " + element.getName() + " Wert: " + element.get(meinTrabbi));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
