package thirdlab.models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {

    public void getImageSize(String imagePath) {
        try {
            File image = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(image);
            if (bufferedImage != null) {
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                System.out.println("Image width = " + width);
                System.out.println("Image height = " + height);
            } else {
                System.out.println("Image could not be read.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
