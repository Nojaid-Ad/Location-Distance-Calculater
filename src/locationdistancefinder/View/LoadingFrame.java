package locationdistancefinder.View;

import java.awt.BorderLayout;

import locationdistancefinder.Widgets.CustomLoadingBar;

import locationdistancefinder.Widgets.CustomPanel.CustomPanel;

import locationdistancefinder.Widgets.CustomPanel.PanelFactory;

public class LoadingFrame extends BaseFrame {

    public LoadingFrame() {
        super("Loading", 900, 505, false);
    }

    @Override
    public void initUi() {
        CustomPanel bodyPanel = PanelFactory.createPanel(PanelFactory.PanelType.BODY, null);
        bodyPanel.buildUi();

        add(bodyPanel, BorderLayout.CENTER);
        CustomPanel footerPanel = PanelFactory.createPanel(PanelFactory.PanelType.FOOTER, null);
        footerPanel.buildUi();
        CustomLoadingBar progressBar = new CustomLoadingBar(this);
        footerPanel.add(progressBar);
        add(footerPanel, BorderLayout.SOUTH);
    }

}
