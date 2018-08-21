import java.io.*;

public class AppClassloader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.replaceAll("\\.","/") + ".class";
            InputStream is = new FileInputStream(new File(classpath+"/"+fileName));
            if(is==null){
                throw new ClassNotFoundException(name);
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            System.out.println("AppClassLoader load "+name);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    private String classpath;

    public AppClassloader(String classpath,ClassLoader parent){
        super(parent);
        this.classpath=classpath;
    }
}