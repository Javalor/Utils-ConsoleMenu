package lang.JaVALOR.utils.ConsoleMenu;

import java.util.function.BiConsumer;

public class MenuItem {
    private String label;
    private Object data;
    private BiConsumer<Integer, MenuItem> action;

    public MenuItem(String label, Object data, BiConsumer<Integer, MenuItem> action) {
        this.label = label;
        this.data = data;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public Object getData() {
        return data;
    }

    public BiConsumer<Integer, MenuItem> getAction() {
        return action;
    }
}
