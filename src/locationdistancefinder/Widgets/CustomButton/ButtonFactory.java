package locationdistancefinder.Widgets.CustomButton;

public class ButtonFactory {

    public enum ButtonType {
        ADD,
        DELETE,
        UPDATE,
        OK
    }

    public static CustomButton createButton(ButtonType type) {
        switch (type) {
            case ADD:
                new AddButton();
        }
        return new AddButton();
    }
}
