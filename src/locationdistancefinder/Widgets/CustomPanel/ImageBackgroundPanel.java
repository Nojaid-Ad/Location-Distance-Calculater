package locationdistancefinder.Widgets.CustomPanel;

import java.awt.Graphics;
import java.awt.Image;
import locationdistancefinder.Theme.Themes;
import locationdistancefinder.Widgets.ImageAssets;

public class ImageBackgroundPanel extends CustomPanel {

    private Image backgroundImage;

    public void setBackgroundImage() {

        ImageAssets assetsImage = new ImageAssets();
        backgroundImage = assetsImage.getImage(Themes.backgroundImage, 800, 800).getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void buildUi() {
        setBackgroundImage();
    }

}
