package schwarz.it.lws.java._002_001_oop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
 *      Lernziele:
 *      - Annotations erstellen
 *      - Annotations default Attribute verwenden
 *      - Java Reflection
 */

public class Annotaions {

    // Annotation verwenden
    public static void main1(String[] args) {
        NewEmployee employee = new NewEmployee();
        Class<? extends NewEmployee> aClass = employee.getClass();
        if (!aClass.isAnnotationPresent(MyObject.class)) {
            throw new RuntimeException("Annotation @MyAnnotation missing");
        }
    }

    // Annotation Default Attribute verwenden
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        NewEmployee employee = new NewEmployee();

        Class<? extends NewEmployee> aClass = employee.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyLongValue.class)) {
                field.setAccessible(true);
                if (field.get(employee) == null) {
                    MyLongValue myLongValue = field.getAnnotation(MyLongValue.class);
                    field.set(employee, myLongValue.value());
                }
                field.setAccessible(false);
            }
            if (field.isAnnotationPresent(MyStringValue.class)) {
                field.setAccessible(true);
                if (field.get(employee) == null) {
                    MyStringValue myStringValue = field.getAnnotation(MyStringValue.class);
                    field.set(employee, myStringValue.value());
                }
                field.setAccessible(false);
            }
        }
        System.out.println(employee.getId());
        System.out.println(employee.getName());
    }

    // JAVA Reflection verwenden
    public static void main3(String[] args) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<? extends MyPlugin1> pluginClass = MyPlugin1.class;
        Plugin annotation = pluginClass.getAnnotation(Plugin.class);
        if (annotation == null) {
            throw new RuntimeException("Annotation @Plugin missing");
        }

        MyPlugin1 plugin = pluginClass.getDeclaredConstructor().newInstance();
        String entryPoint = annotation.entryPoint();
        String[] pargs = {"param1", "param2"};
        Object[] methodeParams = new Object[]{pargs};
        if (pluginClass.getMethod(entryPoint, String[].class).invoke(plugin, methodeParams) instanceof String response) {
            System.out.println(response);
        }
    }
}

@Plugin
class MyPlugin1 {
    public String pluginMain(String[] args) {
        System.out.println("MyPlugin is started");
        System.out.println("Count parameters: " + args.length);
        return "Done";
    }
}

@Plugin(entryPoint = "run")
class MyPlugin2 {
    public String run(String[] args) {
        System.out.println("MyPlugin is started");
        System.out.println("Count parameters: " + args.length);
        return "Done";
    }
}

@MyObject
class NewEmployee {
    @MyLongValue
    private Long id;
    @MyStringValue(value = "not available")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// - - - - ANNOTATION INTERFACES - - - - - - - - - - - - - - - - - - -
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyObject {
    String info() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyLongValue {
    long value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyStringValue {
    String value() default "";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Plugin {
    String entryPoint() default "pluginMain";
}
