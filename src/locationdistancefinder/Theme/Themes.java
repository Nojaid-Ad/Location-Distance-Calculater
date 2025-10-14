package locationdistancefinder.Theme;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Themes {

    public enum ThemeMode {
        LIGHT,
        DARK
    }
    public static String backgroundImage;
    public static ThemeMode mode = ThemeMode.DARK;

    public static Color containerBackgroundColor;
    public static Color textColor;
    public static Color hintColor;
    public static Color primaryColor;
    public static Color secondaryColor;
    public static Color normalColor;
    public static Color hoverColor;
    public static Color pressedColor;

    public static void loadTheme(ThemeMode mode) {

        switch (mode) {
            case DARK -> {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                backgroundImage = "/Assets/images/darkBackground.png";
                primaryColor = new Color(0x00695C);
                secondaryColor = new Color(0xFFC107);
                containerBackgroundColor = new Color(0x212121);
                textColor = new Color(0xE0E0E0);
                hintColor = new Color(0x9E9E9E);
                normalColor = new Color(0x46494b);
                hoverColor = primaryColor.darker();
                pressedColor = new Color(0x004D40);
            }
            case LIGHT -> {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                backgroundImage = "/Assets/images/background.png";
                primaryColor = new Color(0x009688);
                secondaryColor = new Color(0x00796B);
                containerBackgroundColor = new Color(0xeeeeee);
                textColor = new Color(0x212121);
                hintColor = new Color(0x757575);
                normalColor = Color.white;
                hoverColor = primaryColor.brighter();
                pressedColor = secondaryColor;
            }
        }
    }

    public static void toggleTheme() {
        if (mode == ThemeMode.DARK) {
            mode = ThemeMode.LIGHT;
            loadTheme(ThemeMode.LIGHT);

        } else {
            mode = ThemeMode.DARK;
            loadTheme(ThemeMode.DARK);
        }

    }
}
