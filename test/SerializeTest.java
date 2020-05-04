import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @ClassName imagesTest
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class SerializeTest {

    /*
     * @Description //load image test
     * @Param []
     * @return void
     **/
    @Test
    public void test() {
        try {
            T t = new T();
            File f = new File("d:/test/s.dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoad() {
        try {
            File f = new File("d:/test/s.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            T t = (T)(ois.readObject());

            assertEquals(4, t.m);
            assertEquals(8, t.n);

            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class T implements Serializable {
    int m = 4;
    int n = 8;
}