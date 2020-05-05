package com.itcast.tank.v6_mediator;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName ImageUtil
 * @Description //rotate image
 * @Author ArthurZhu
 * @Version 1.0
 */

public class ImageUtil {

    public static BufferedImage rotateImage(final BufferedImage bufferedImage,
                                     final int degree) {
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
