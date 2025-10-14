/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locationdistancefinder.Widgets.CustomPanel;


import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import static locationdistancefinder.Theme.Themes.*;

import locationdistancefinder.Widgets.CustomLabel.CustomLabel;
import locationdistancefinder.Widgets.CustomLabel.LabelFactory;
import static locationdistancefinder.Widgets.CustomLabel.LabelFactory.LabelType.WHITE_LABEL;


/**
 *
 * @author nojai
 */
public class FooterPanel extends CustomPanel {

    @Override
    public void buildUi() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        CustomLabel footerLabel = LabelFactory.createLabel(WHITE_LABEL, "Developed by Nojaid Abdullah Essa", "", 0, 0);
        CustomLabel footerLabel2 = LabelFactory.createLabel(WHITE_LABEL, "© 2025 All rights reserved.", "", 0, 0);

        add(footerLabel);
        add(footerLabel2);
        JPanel panel = new JPanel();
        panel.setBackground(containerBackgroundColor);
        panel.setPreferredSize(new Dimension(WIDTH, 16));
        add(panel);

        setBackground(primaryColor);

        
    }

}
