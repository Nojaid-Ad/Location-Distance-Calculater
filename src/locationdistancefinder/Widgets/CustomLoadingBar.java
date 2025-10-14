package locationdistancefinder.Widgets;

import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import static locationdistancefinder.Theme.Themes.primaryColor;
import locationdistancefinder.View.BaseFrame;
import locationdistancefinder.View.HomeFrame;

public class CustomLoadingBar extends JProgressBar {

    public CustomLoadingBar(BaseFrame frame) {
        setMaximum(100);
        setValue(0);
        setStringPainted(true);
        setForeground(primaryColor);
        setPreferredSize(new Dimension(200, 15));
        setBorderPainted(true);
        setBorder(new LineBorder(primaryColor, 2, true));
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setValue(i);

            }
            SwingUtilities.invokeLater(() -> {
                frame.dispose();
                new HomeFrame();
            });
        }).start();
    }

}
