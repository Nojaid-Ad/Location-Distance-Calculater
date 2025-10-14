package locationdistancefinder.Widgets.CustomLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import locationdistancefinder.Theme.Themes;

public class CustomLabel extends JLabel {

    public CustomLabel(String txt, Color color, int fontWeight, int fontSize) {
        super(txt);
        setForeground(color);
        setFont(new Font("Segoe UI", fontWeight, fontSize));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setAlignmentX(CENTER_ALIGNMENT);
        setOpaque(false);
    }

    public CustomLabel(String txt, ImageIcon icon, Color color, int fontSize) {
        super(txt);
        setForeground(color);
        setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setIcon(icon);
        setOpaque(false);
        setIconTextGap(8);

        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);

        setAlignmentX(CENTER_ALIGNMENT);
    }

    public CustomLabel(ImageIcon icon) {

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

        setIcon(icon);

        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);

        setAlignmentX(CENTER_ALIGNMENT);
    }

    public CustomLabel(String txt, ImageIcon icon, int fontSize) {
        super(txt, icon, SwingConstants.LEFT);
        setForeground(Themes.textColor);
        setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        setOpaque(false);
        setIconTextGap(5);

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);
    }
}
