import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @ClassName imagesTest
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class imageTest {

    /*
     * @Description //load image test
     * @Param []
     * @return void
     **/
    @Test
    public void testLoadImage(){
        try {
            BufferedImage image = ImageIO.read(imageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRotateImage() {
        BufferedImage tankL = null;
        try {
            tankL = ImageIO.read(imageTest.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            tankL = rotateImage(tankL, 90);
            assertNotNull(tankL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage rotateImage(final BufferedImage bufferedImage, final int degree) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2D;
        (graphics2D = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degree), w/2, h/2);
        graphics2D.drawImage(bufferedImage, 0, 0, null);
        graphics2D.dispose();
        return img;
    }


}
