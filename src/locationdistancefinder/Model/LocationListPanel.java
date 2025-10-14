package locationdistancefinder.Model;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import locationdistancefinder.Theme.Themes;
import locationdistancefinder.Widgets.CustomLabel.CustomLabel;
import locationdistancefinder.Widgets.CustomLabel.LabelFactory;

public class LocationListPanel extends JPanel {

    private final List<Location> locations = new ArrayList<>();
    private LocationClickListener clickListener;

    public LocationListPanel() {
        setAlignmentY(TOP_ALIGNMENT);
        setAlignmentX(LEFT_ALIGNMENT);
        setAutoscrolls(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Themes.containerBackgroundColor);
    }

    public void setLocationClickListener(LocationClickListener listener) {
        this.clickListener = listener;
    }

    private JPanel createRow(Location loc) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 4));

        row.setMaximumSize(new Dimension(300, 50));
        row.setPreferredSize(new Dimension(300, 50));

        row.setBackground(Themes.normalColor);
        CustomLabel name = LabelFactory.createLabel(LabelFactory.LabelType.ITEM_ICON, "" + loc.getLocationName(), "/Assets/images/logo.png", 15, 15);
        CustomLabel lat = LabelFactory.createLabel(LabelFactory.LabelType.ITEM, "Lat: " + loc.getLatValue(), "", WIDTH, WIDTH);
        CustomLabel lon = LabelFactory.createLabel(LabelFactory.LabelType.ITEM, "Lon: " + loc.getLonValue(), "", WIDTH, WIDTH);

        row.add(name);
        row.add(Box.createHorizontalStrut(12));
        row.add(lat);
        row.add(Box.createHorizontalStrut(12));
        row.add(lon);

        row.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                row.setBackground(Themes.hoverColor);
                row.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                row.setBackground(Themes.normalColor);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (clickListener != null) {
                    clickListener.onLocationClicked(loc);
                    row.setBackground(Themes.pressedColor);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {

                if (row.getBounds().contains(e.getPoint())) {
                    row.setBackground(Themes.hoverColor);
                } else {
                    row.setBackground(Themes.pressedColor);
                }
            }
        });

        return row;
    }

    public void addLocation(Location loc) {

        locations.add(loc);

        JPanel row = createRow(loc);
        add(row);
        add(Box.createVerticalStrut(6));
        revalidate();
        repaint();

        SwingUtilities.invokeLater(() -> {
            Container parent = getParent();
            if (parent instanceof javax.swing.JViewport viewport) {
                viewport.setViewPosition(new Point(0, getHeight()));
            }

        });
    }

    public void setLocations(List<Location> locationsList) {
        locations.clear();
        removeAll();

        for (Location loc : locationsList) {
            add(createRow(loc));
            add(Box.createVerticalStrut(6));
            locations.add(loc);
        }

        revalidate();
        repaint();
    }
}
