package chris.a02;

import java.lang.annotation.Annotation;

public class Reflection {
    private Auto meinTrabbi;
    private Class<?> skalpierterTrabbi;

    public Reflection(){
        meinTrabbi = new Auto("weiss", 45, 5);
        skalpierterTrabbi = meinTrabbi.getClass();
    }

    public static void main(){
        new Reflection().annotationenAusgeben();
        new Reflection().attributeAusgeben();
        new Reflection().methodenAusgeben();
    }

    public void annotationenAusgeben(){
        Annotation[] annotationDerKlasse = skalpierterTrabbi.getAnnotations();

        for(Annotation element : annotationDerKlasse){
            Class<? extends Annotation> annotation = element.annotationType();
            System.out.println("Annotation Type: " + annotation.toString());
        }
    }

    public void methodenAusgeben(){

    }

    public void attributeAusgeben(){

    }
}
