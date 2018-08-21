import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class app2 {
    public static void main(String[] args){
        CommonClassloader commonClassloader=new CommonClassloader();

        AppClassloader appClassloader=new AppClassloader("/opt/cl/applib2",commonClassloader);

        Class clz= null;
        try {
            clz = appClassloader.loadClass("applib2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object o= null;
        try {
            o = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method = null;
        try {
            method = clz.getMethod("Do");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
