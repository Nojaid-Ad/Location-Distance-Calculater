package locationdistancefinder.Model;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComponent;

public class ResizeHelper {

    public static void autoResizeSide(JComponent parent, JComponent component, double ratio) {
        parent.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = parent.getWidth();
                int sideWidth = (int) (width * ratio);
                component.setPreferredSize(new Dimension(sideWidth, 0));
                parent.revalidate();
            }
        });
    }
}
