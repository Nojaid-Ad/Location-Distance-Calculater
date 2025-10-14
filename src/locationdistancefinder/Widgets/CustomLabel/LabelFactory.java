/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locationdistancefinder.Widgets.CustomLabel;

import java.awt.Color;
import java.awt.Font;
import locationdistancefinder.Theme.Themes;
import static locationdistancefinder.Theme.Themes.hintColor;
import static locationdistancefinder.Theme.Themes.primaryColor;
import static locationdistancefinder.Theme.Themes.textColor;
import locationdistancefinder.Widgets.ImageAssets;

public class LabelFactory {

    public enum LabelType {
        TITLE,
        HINT,
        BODY,
        FOOTER,
        ICON_LABEL,
        WHITE_LABEL,
        HINT_TEXTFIELD,
        ITEM,
        ITEM_ICON
    }

    public static CustomLabel createLabel(LabelType type, String txt, String imagePath, int w, int h) {
        ImageAssets image = new ImageAssets();
        return switch (type) {
            case ICON_LABEL ->

                new CustomLabel(txt, image.getImage(imagePath, w, h), primaryColor, 29);
            case HINT_TEXTFIELD ->

                new CustomLabel(image.getImage(imagePath, w, h));

            case TITLE ->
                new CustomLabel(txt, textColor, Font.BOLD, 28);
            case BODY ->
                new CustomLabel(txt, textColor, Font.PLAIN, 22);
            case HINT ->
                new CustomLabel(txt, hintColor, Font.PLAIN, 14);
            case FOOTER ->
                new CustomLabel(txt, textColor, Font.PLAIN, 12);
            case WHITE_LABEL ->
                new CustomLabel(txt, Color.white, Font.PLAIN, 12);
            case ITEM ->
                new CustomLabel(txt, textColor, Font.PLAIN, 14);
            case ITEM_ICON ->
                new CustomLabel(txt, image.getImage(imagePath, w, h), 15);

        };

    }

}
