import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommonClassloader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.replaceAll("\\.","/") + ".class";
            InputStream is = new FileInputStream(new File("/opt/cl/common/"+fileName));
            if(is==null){
                throw new ClassNotFoundException(name);
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            System.out.println("CommonClassLoader load "+name);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }
}