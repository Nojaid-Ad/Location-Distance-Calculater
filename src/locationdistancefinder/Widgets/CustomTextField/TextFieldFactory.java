/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locationdistancefinder.Widgets.CustomTextField;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nojai
 */
public class TextFieldFactory {

    public enum TextFieldType {
        HINT_FIELD,
        ICON_FIELD,
        HINT_ICON_FIELD
    }

    public static JTextField createTextField(TextFieldType type, JPanel panel, String hint, String icon, int width, int height) {
        return switch (type) {
            case HINT_FIELD ->
                null;

            case ICON_FIELD ->
                null;

            case HINT_ICON_FIELD ->
                new HintIconTextField(panel, hint, icon, width, height);

        };
    }
}
