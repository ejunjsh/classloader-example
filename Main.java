import java.lang.Exception;

public class Main{
    public static void main(String[] args) throws Exception {
        CommonClassloader commonClassLoader=new CommonClassloader();

        AppClassloader appClassLoader=new AppClassloader(commonClassLoader);

        appClassLoader.loadClass("app1.test").newInstance();
        appClassLoader.loadClass("app2.test").newInstance();

        appClassLoader.loadClass("app1.test").newInstance();
        appClassLoader.loadClass("app2.test").newInstance();
    }
}