package locationdistancefinder.Widgets.CustomPanel;

import locationdistancefinder.View.HomeFrame;
import locationdistancefinder.Widgets.HomeWidgets.HomeBodyPanel;

public class PanelFactory {

    public enum PanelType {
        FOOTER,
        BODY,
        HOME_BODY_PANEL,
        PANEL_BACKGROUND
    }

    public static CustomPanel createPanel(PanelType type,HomeFrame frame) {
        return switch (type) {
            case BODY ->
                new BodyPanel();
            case FOOTER ->
                new FooterPanel();
            case HOME_BODY_PANEL ->
                new HomeBodyPanel(frame);
                 case PANEL_BACKGROUND ->
                new ImageBackgroundPanel();
        };
    }
}
