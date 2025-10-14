/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locationdistancefinder.Widgets.CustomButton;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import locationdistancefinder.Widgets.ImageAssets;

/**
 *
 * @author nojai
 */
public class AddButton implements CustomButton {

    @Override
    public JButton createButtton(JPanel panel, String text, String iconPath, int width, int height) {
        JButton btn = new JButton(text);
        ImageAssets iconImage = new ImageAssets();

        btn.setMaximumSize(new Dimension(width, height));
        btn.setPreferredSize(new Dimension(width, height));
        btn.setIcon(iconImage.getImage(iconPath, 25, 25));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btn.setFocusable(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setHorizontalTextPosition(SwingConstants.LEFT);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setIconTextGap(4);
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        panel.add(btn);
        return btn;
    }

}
