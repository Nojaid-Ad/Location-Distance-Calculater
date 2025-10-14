package locationdistancefinder.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Location {

    private String locationName;
    private double lat;
    private double lon;

    public Location(String lName, double lat, double lon) {
        this.locationName = lName;
        this.lat = lat;
        this.lon = lon;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLatValue() {
        return this.lat;
    }

    public double getLonValue() {
        return this.lon;
    }

    @Override
    public String toString() {
        return "" + this.locationName + "(" + lat + " " + lon + ").";
    }
}

