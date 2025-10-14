/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locationdistancefinder.Widgets.CustomTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import locationdistancefinder.Theme.Themes;
import locationdistancefinder.Widgets.CustomLabel.CustomLabel;
import locationdistancefinder.Widgets.CustomLabel.LabelFactory;

public class HintIconTextField extends JTextField {

    public HintIconTextField(JPanel panel, String hint, String icon, int width, int height) {
        Border normalBorder = BorderFactory.createLineBorder(Themes.primaryColor, 1);
        Border focusBorder = BorderFactory.createLineBorder(Themes.primaryColor, 2);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);
        content.setMaximumSize(new Dimension(305, 40));
        content.setBorder(normalBorder);
        panel.add(content);

        CustomLabel labelIcon = LabelFactory.createLabel(LabelFactory.LabelType.HINT_TEXTFIELD, "", icon, 25, 25);
        labelIcon.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        labelIcon.setOpaque(true);
        labelIcon.setBackground(UIManager.getColor("TextField.background"));
        content.add(labelIcon, BorderLayout.WEST);

        setText(hint);
        setForeground(Themes.hintColor);
        setFont(new Font("Segieo UI", Font.PLAIN, 18));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       setMaximumSize(new Dimension(width, height));
       setPreferredSize(new Dimension(width, height));

        content.add(this, BorderLayout.CENTER);
       setFocusable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                setFocusable(true);
                requestFocusInWindow();
            }
        });
      addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                content.setBorder(focusBorder);
                if (getText().equals(hint)) {
                    setText("");
                    setForeground(Themes.textColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                content.setBorder(normalBorder);
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(Themes.hintColor);
                }
            }
        });

    }

}
