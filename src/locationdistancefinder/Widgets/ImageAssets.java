package locationdistancefinder.Widgets;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImageAssets {

    public ImageIcon getImage(String imgPath, int w, int h) {
        try {
            var imagePath = getClass().getResource(imgPath);

            if (imagePath == null) {
                return null;
            }
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imgPath));
            Image scaledImage = imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
            return null;
        }

    }
}
