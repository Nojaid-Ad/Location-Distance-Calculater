package locationdistancefinder.Widgets.CustomPanel;


import javax.swing.Box;
import javax.swing.BoxLayout;

import static locationdistancefinder.Theme.Themes.containerBackgroundColor;
import locationdistancefinder.Widgets.CustomLabel.CustomLabel;
import locationdistancefinder.Widgets.CustomLabel.LabelFactory;
import static locationdistancefinder.Widgets.CustomLabel.LabelFactory.LabelType.ICON_LABEL;

public class BodyPanel extends CustomPanel {

    @Override
    public void buildUi() {

        add(Box.createGlue());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        CustomLabel iconLabel = LabelFactory.createLabel(ICON_LABEL, "Welcome to GeoDistance", "/Assets/images/LocationImage.png", 275, 220);
        add(iconLabel);

        add(Box.createGlue());
        setBackground(containerBackgroundColor);
    }

}
