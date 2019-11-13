import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) {
        Test obj = new Test();
        try {
            Class c = Class.forName("Test");
            System.out.println("The name of the class is "+ c.getSimpleName());
            Constructor constructor = c.getConstructor();
            System.out.println("The name of the constructor is "+constructor.getName());
            System.out.println("The public methods are: ");
            Method[] methods = c.getDeclaredMethods();
            for(Method method:methods){
                System.out.println(method.getName());
            }
            Method methodcall1 = c.getDeclaredMethod("method2", int.class);
            methodcall1.invoke(obj, 25);

            Field field = c.getDeclaredField("s");
            field.setAccessible(true);
            field.set(obj, "Java");

            Method methodcall2 = c.getDeclaredMethod("method1");
            methodcall2.invoke(obj);

            Method methodcall3 = c.getDeclaredMethod("method3");
            methodcall3.setAccessible(true);
            methodcall3.invoke(obj);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
