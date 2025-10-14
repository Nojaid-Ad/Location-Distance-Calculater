package locationdistancefinder.View;

import javax.swing.JFrame;
import locationdistancefinder.Theme.Themes;
import static locationdistancefinder.Theme.Themes.loadTheme;
import locationdistancefinder.Widgets.ImageAssets;

public abstract class BaseFrame extends JFrame {

    public abstract void initUi();

    public BaseFrame() {
    }

    public BaseFrame(String title, int width, int height, boolean resize) {
        setTitle(title);

        Themes.ThemeMode currentTheme = Themes.mode;

        loadTheme(currentTheme);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(resize);

        ImageAssets image = new ImageAssets();
        setIconImage(image.getImage("/Assets/images/logo.png", 150, 150).getImage());

        initUi();
        setVisible(true);
    }

}
