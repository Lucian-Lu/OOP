package thirdlab.models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile extends DefaultFile {

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

    @Override
    public void printFileInfo(String fileName) {
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + getExtensionFromFileName(fileName));
        System.out.println("Created: " + DefaultFile.getCreationDate(fileName));
        System.out.println("Updated: " + DefaultFile.getUpdatedDate(fileName));
        getImageSize(getFolderLocation() + "\\" + fileName);
    }
}
