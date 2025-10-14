package locationdistancefinder.Widgets.HomeWidgets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import locationdistancefinder.Model.Location;
import locationdistancefinder.Model.LocationListPanel;
import locationdistancefinder.Model.ResizeHelper;
import locationdistancefinder.Theme.Themes;
import locationdistancefinder.View.HomeFrame;
import locationdistancefinder.Widgets.CustomButton.*;
import locationdistancefinder.Widgets.CustomLabel.*;
import locationdistancefinder.Widgets.CustomPanel.*;
import locationdistancefinder.Widgets.CustomTextField.*;
import static locationdistancefinder.Theme.Themes.*;

public class HomeBodyPanel extends CustomPanel {

    private final HomeFrame frame;
    private double distance;
    private Location selectedLocation;
    // UI Comp
    private JTextArea textArea;
    private JTextField locationField, latField, lonField;
    private JTextField latFieldLeft, lonFieldLeft, speedField, timeField;
    private CustomLabel sideBarTitle;
    private LocationListPanel locationListPanel = new LocationListPanel();
    private CustomPanel bodyPanel, bodyPanelRight, bodyPanelLeft, bodyPanelTop, bodyPanelBottom, sidePanel;

    public HomeBodyPanel(HomeFrame frame) {

        this.frame = frame;
    }

    @Override
    public void buildUi() {
        setLayout(new BorderLayout());
        buildSideBar();
        buildBody();
    }

    //BUILD UI PARTS
    private void buildSideBar() {
        sidePanel = PanelFactory.createPanel(PanelFactory.PanelType.PANEL_BACKGROUND, null);
        sidePanel.buildUi();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(primaryColor);

        add(sidePanel, BorderLayout.WEST);

        addVerticalSpace(sidePanel, 16);
        addSideBarHeader();
        addFormInputs();
        addSubmitButton();
    }

    private void buildBody() {
        bodyPanel = PanelFactory.createPanel(PanelFactory.PanelType.BODY, frame);
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(containerBackgroundColor);

        add(bodyPanel, BorderLayout.CENTER);
        buildBodyTop();
        intialLocations();
        buildBodyRight();

        buildBodyLeft();
        buildBodyBottom();
    }

    //SIDE BAR
    private void addSideBarHeader() {
        sideBarTitle = LabelFactory.createLabel(
                LabelFactory.LabelType.ICON_LABEL,
                "Location Distance Calculator",
                "/Assets/images/logo.png",
                70,
                70
        );
        sideBarTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(sideBarTitle);
    }

    private void addFormInputs() {
        addVerticalSpace(sidePanel, 108);
        addLabel(sidePanel, "Add New Location");
        addVerticalSpace(sidePanel, 24);

        locationField = createInput(sidePanel, "Enter Location Name", "/Assets/images/locationname.png");
        addVerticalSpace(sidePanel, 12);
        latField = createInput(sidePanel, "Enter Latitude", "/Assets/images/lat.png");
        addVerticalSpace(sidePanel, 12);
        lonField = createInput(sidePanel, "Enter Longitude", "/Assets/images/lon.png");

        addVerticalSpace(sidePanel, 16);
    }

    private void addSubmitButton() {
        CustomButton customBtn = ButtonFactory.createButton(ButtonFactory.ButtonType.ADD);
        JButton addButton = customBtn.createButtton(
                sidePanel,
                "Add",
                "/Assets/images/add.png",
                302,
                40
        );
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new AddLocationListener());
        sidePanel.add(addButton);
    }

    //BODY PARST
    private void buildBodyTop() {
        bodyPanelTop = PanelFactory.createPanel(PanelFactory.PanelType.BODY, frame);
        bodyPanelTop.setLayout(new BorderLayout());
        bodyPanelTop.setBackground(Themes.containerBackgroundColor);
        bodyPanelTop.setPreferredSize(new Dimension(0, 100));

        CustomLabel changeThemeLabel = LabelFactory.createLabel(
                LabelFactory.LabelType.ICON_LABEL,
                " ",
                Themes.mode == Themes.ThemeMode.DARK
                        ? "/Assets/images/D.png"
                        : "/Assets/images/L.png",
                25,
                25
        );

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        rightPanel.setBackground(Themes.containerBackgroundColor);
        rightPanel.add(changeThemeLabel);
        bodyPanelTop.add(rightPanel, BorderLayout.NORTH);

        changeThemeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Themes.toggleTheme();
                frame.dispose();
                new HomeFrame();
            }
        });

        bodyPanel.add(bodyPanelTop, BorderLayout.NORTH);
    }
    private List<Location> initialList = new ArrayList<>();

    private void buildBodyRight() {
        bodyPanelRight = PanelFactory.createPanel(PanelFactory.PanelType.BODY, frame);
        ResizeHelper.autoResizeSide(bodyPanel, bodyPanelRight, 0.5);

        bodyPanelRight.setBackground(Themes.containerBackgroundColor);
        bodyPanel.add(bodyPanelRight, BorderLayout.EAST);
        bodyPanelRight.setLayout(new BoxLayout(bodyPanelRight, BoxLayout.Y_AXIS));
        CustomLabel title = LabelFactory.createLabel(LabelFactory.LabelType.TITLE, "Locations", "", 1, 1);
        bodyPanelRight.add(title);
        addVerticalSpace(bodyPanelRight, 18);

        JScrollPane scroll = new JScrollPane(locationListPanel);

        scroll.setMaximumSize(new Dimension(315, 400));
        scroll.setPreferredSize(new Dimension(315, 400));
        locationListPanel.setLocations(initialList);
        bodyPanelRight.add(scroll);

    }

    private void buildBodyLeft() {

        bodyPanelLeft = PanelFactory.createPanel(PanelFactory.PanelType.BODY, frame);
        bodyPanelLeft.setLayout(new BoxLayout(bodyPanelLeft, BoxLayout.Y_AXIS));
        bodyPanelLeft.setBackground(Themes.containerBackgroundColor);
        CustomLabel title = LabelFactory.createLabel(
                LabelFactory.LabelType.TITLE,
                "My Location",
                "",
                0,
                0
        );
        bodyPanelLeft.add(title);
        addVerticalSpace(bodyPanelLeft, 18);
        addFormInputsLeft();
        textArea = new JTextArea();
        textArea.setEditable(false);

        textArea.setText("Select a Location...");
        textArea.setFont(new Font("Segeo", Font.PLAIN, 18));
        addVerticalSpace(bodyPanelLeft, 12);
        textArea.setBackground(Themes.normalColor);
        textArea.setForeground(primaryColor);

        ResizeHelper.autoResizeSide(bodyPanel, bodyPanelLeft, 0.5);
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setMaximumSize(new Dimension(305, 275));
        textAreaScroll.setPreferredSize(new Dimension(305, 275));
        bodyPanelLeft.add(textAreaScroll);
        bodyPanel.add(bodyPanelLeft, BorderLayout.WEST);
        locationListPanel.setLocationClickListener(location -> {
            selectedLocation = location;
            textArea.setText(
                    "🌍 " + location.getLocationName() + "\n"
                    + "Latitude: " + location.getLatValue() + "\n"
                    + "Longitude: " + location.getLonValue()
            );
        });
    }

    private void buildBodyBottom() {
        bodyPanelBottom = PanelFactory.createPanel(PanelFactory.PanelType.BODY, frame);
        bodyPanelBottom.setPreferredSize(new Dimension(0, 75));
        bodyPanelBottom.setBackground(Themes.containerBackgroundColor);

        bodyPanelBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        CustomButton customBtn = ButtonFactory.createButton(ButtonFactory.ButtonType.ADD);
        JButton calcBtn = customBtn.createButtton(
                bodyPanelBottom,
                "Calculate Distance",
                "/Assets/images/dis.png",
                305,
                40
        );
        calcBtn.addActionListener(e -> calculateDistance());
        JButton calcSpeedTimeBtn = customBtn.createButtton(
                bodyPanelBottom,
                "Calculate Speed/Time",
                "/Assets/images/ts.png",
                315,
                40
        );

        bodyPanelBottom.add(calcBtn);
        bodyPanelBottom.add(Box.createHorizontalStrut(0));
        bodyPanelBottom.add(calcSpeedTimeBtn);
        calcSpeedTimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSpeedOrTime(distance);
            }
        });
        bodyPanel.add(bodyPanelBottom, BorderLayout.SOUTH);

    }

    private void addFormInputsLeft() {
        latFieldLeft = createInput(bodyPanelLeft, "Enter Latitude", "/Assets/images/lat.png");
        addVerticalSpace(bodyPanelLeft, 12);
        lonFieldLeft = createInput(bodyPanelLeft, "Enter Longitude", "/Assets/images/lon.png");
        addVerticalSpace(bodyPanelLeft, 12);
        addSpeedAndTimeFields();
    }

    private void addSpeedAndTimeFields() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.setMaximumSize(new Dimension(350, 40));
        container.add(Box.createHorizontalStrut(20));
        container.setBackground(Themes.containerBackgroundColor);
        speedField = createInput(container, "Enter Speed", "/Assets/images/speed.png");
        speedField.setFont(new Font("", 0, 14));
        container.add(Box.createHorizontalStrut(12));
        timeField = createInput(container, "Enter Time min", "/Assets/images/time.png");
        timeField.setFont(new Font("", 0, 14));
        container.add(Box.createHorizontalStrut(20));
        bodyPanelLeft.add(container);
    }

    //Reuse Componnents
    private JTextField createInput(JPanel panel, String hint, String iconPath) {
        return TextFieldFactory.createTextField(
                TextFieldFactory.TextFieldType.HINT_ICON_FIELD,
                panel,
                hint,
                iconPath,
                350,
                50
        );
    }

    private void addVerticalSpace(JPanel panel, int height) {
        panel.add(Box.createVerticalStrut(height));
    }

    private void addLabel(JPanel panel, String text) {
        CustomLabel label = LabelFactory.createLabel(LabelFactory.LabelType.BODY, text, "", 0, 0);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
    }

    private class AddLocationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = locationField.getText().trim();
            String latText = latField.getText().trim();
            String lonText = lonField.getText().trim();

            if (isInvalidInput(name, latText, lonText)) {
                showError("All fields must be filled.");
                return;
            }

            try {
                double lat = Double.parseDouble(latText);
                double lon = Double.parseDouble(lonText);

                if (!isValidCoordinate(lat, lon)) {
                    return;
                }

                Location newLocation = new Location(name, lat, lon);

                JOptionPane.showMessageDialog(sidePanel, "Location added successfully\n" + newLocation);
                locationListPanel.addLocation(newLocation);

            } catch (NumberFormatException ex) {
                showError("Latitude and Longitude must be valid numbers.");
            }
        }

        private boolean isInvalidInput(String name, String lat, String lon) {
            return name.isEmpty() || lat.isEmpty() || lon.isEmpty()
                    || name.equals("Enter Location Name")
                    || lat.equals("Enter Latitude")
                    || lon.equals("Enter Longitude");
        }

        private boolean isValidCoordinate(double lat, double lon) {
            if (lat < -90 || lat > 90) {
                showError("Latitude must be between -90 and 90.");
                return false;
            }
            if (lon < -180 || lon > 180) {
                showError("Longitude must be between -180 and 180.");
                return false;
            }
            return true;
        }

        private void showError(String msg) {
            JOptionPane.showMessageDialog(sidePanel, msg, "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void intialLocations() {
        initialList.add(new Location("Tripoli", 32.8872, 13.1913));
        initialList.add(new Location("Benghazi", 32.1167, 20.0667));
        initialList.add(new Location("Sabratah", 32.7934, 12.4885));
        initialList.add(new Location("Al Jmail", 32.8400, 12.2500));
        initialList.add(new Location("IT College of Tripoli", 32.8277, 13.1830));
        initialList.add(new Location("Misrata", 32.3783, 15.0906));
        initialList.add(new Location("Zawiya", 32.7522, 12.7278));
        initialList.add(new Location("Sabha", 27.0377, 14.4283));
        initialList.add(new Location("Derna", 32.7670, 22.6367));
        initialList.add(new Location("Zliten", 32.4674, 14.5687));
        initialList.add(new Location("Al Khums", 32.6500, 14.2667));

    }

    private void calculateDistance() {
        if (selectedLocation == null) {
            JOptionPane.showMessageDialog(bodyPanel, "Please select a location first.");
            return;
        }

        String latText = latFieldLeft.getText().trim();
        String lonText = lonFieldLeft.getText().trim();

        if (latText.isEmpty() || lonText.isEmpty()
                || latText.equals("Enter Latitude") || lonText.equals("Enter Longitude")) {
            JOptionPane.showMessageDialog(bodyPanel, "Please enter valid coordinates for your location.");
            return;
        }

        try {
            double myLat = Double.parseDouble(latText);
            double myLon = Double.parseDouble(lonText);

            if (myLat < -90 || myLat > 90 || myLon < -180 || myLon > 180) {
                JOptionPane.showMessageDialog(bodyPanel, "Coordinates must be within valid ranges:\nLatitude: -90 to 90\nLongitude: -180 to 180");
                return;
            }

            double targetLat = selectedLocation.getLatValue();
            double targetLon = selectedLocation.getLonValue();
            distance = haversine(myLat, myLon, targetLat, targetLon);
            String resultText = String.format(
                    "🌍 %s\nLatitude: %.4f\nLongitude: %.4f\n\nDistance between your location and %s:\n%.2f km%n",
                    selectedLocation.getLocationName(),
                    selectedLocation.getLatValue(),
                    selectedLocation.getLonValue(),
                    selectedLocation.getLocationName(),
                    distance
            );
            JOptionPane.showMessageDialog(bodyPanel, resultText);
            textArea.setText(
                    resultText
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(bodyPanel, "Latitude and Longitude must be valid numbers.");
        }
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    private void calculateSpeedOrTime(double distance) {
        if (distance == 0) {
            JOptionPane.showMessageDialog(bodyPanel, "Distance must be calculated first!.");
            return;
        }
        String speedText = speedField.getText().trim();
        String timeText = timeField.getText().trim();

        boolean hasSpeed = !speedText.isEmpty() && !speedText.equals("Enter Speed");
        boolean hasTime = !timeText.isEmpty() && !timeText.equals("Enter Time min");

        if (!hasSpeed && !hasTime) {
            JOptionPane.showMessageDialog(bodyPanel, "Please enter Speed or Time.");
            return;
        }

        try {
            if (hasSpeed && !hasTime) {
                double speed = Double.parseDouble(speedText);
                if (speed <= 0) {
                    JOptionPane.showMessageDialog(bodyPanel, "Speed must be positive.");
                    return;
                }
                double timeHours = distance / speed;
                double timeMinutes = timeHours * 60;
                String msg;
                if (timeMinutes >= 60) {
                    double hours = timeMinutes / 60.0;
                    msg = String.format("Time needed: %.2f hours", hours);
                } else {
                    msg = String.format("Time needed: %.2f minutes", timeMinutes);
                }
                JOptionPane.showMessageDialog(bodyPanel, msg);
                textArea.append("\n" + msg);
            } else if (!hasSpeed && hasTime) {
                double timeMinutes = Double.parseDouble(timeText);
                if (timeMinutes <= 0) {
                    JOptionPane.showMessageDialog(bodyPanel, "Time must be positive.");
                    return;
                }
                double timeHours = timeMinutes / 60;
                double speed = distance / timeHours;
                String msg = String.format("Required speed: %.2f km/h%n", speed);
                JOptionPane.showMessageDialog(bodyPanel, msg);
                textArea.append("\n" + msg);
            } else {
                JOptionPane.showMessageDialog(bodyPanel, "Enter only one field (Speed or Time), not the two of them.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(bodyPanel, "Speed and Time must be valid numbers.");
        }
    }
}
