import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class container {
    public static void main(String[] args){
        CommonClassloader commonClassloader=new CommonClassloader();

        System.out.println("start up the app 1:");

        AppClassloader appClassloader1=new AppClassloader("/opt/cl/applib1",commonClassloader);

        Class clz= null;
        try {
            clz = appClassloader1.loadClass("applib1");
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


        System.out.println("start up the app 2:");

        AppClassloader appClassloader2=new AppClassloader("/opt/cl/applib2",commonClassloader);

         clz= null;
        try {
            clz = appClassloader2.loadClass("applib2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         o= null;
        try {
            o = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
         method = null;
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
