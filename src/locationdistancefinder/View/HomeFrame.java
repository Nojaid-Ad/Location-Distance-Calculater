package locationdistancefinder.View;

import locationdistancefinder.Theme.Themes;
import locationdistancefinder.Widgets.CustomPanel.CustomPanel;
import locationdistancefinder.Widgets.CustomPanel.PanelFactory;

public class HomeFrame extends BaseFrame {

    @Override
    public void initUi() {
        CustomPanel bodyPanel = PanelFactory.createPanel(PanelFactory.PanelType.HOME_BODY_PANEL, this);
        CustomPanel backgroundPanel = PanelFactory.createPanel(PanelFactory.PanelType.PANEL_BACKGROUND, null);
        backgroundPanel.buildUi();
        add(backgroundPanel);
        bodyPanel.buildUi();
        add(bodyPanel);
    }

    public HomeFrame() {

        super("Home Screen", 1100, 625, false);
       
    }

}
