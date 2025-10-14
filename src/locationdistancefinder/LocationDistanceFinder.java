package locationdistancefinder;

import javax.swing.SwingUtilities;
import locationdistancefinder.View.LoadingFrame;

public class LocationDistanceFinder {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoadingFrame frame = new LoadingFrame();
            frame.setVisible(true);
        });
    }
}
