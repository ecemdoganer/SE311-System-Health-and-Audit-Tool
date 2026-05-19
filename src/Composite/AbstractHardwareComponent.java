package Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHardwareComponent implements HardwareComponent {
    private String name;
    protected List<HardwareComponent> children;

    public AbstractHardwareComponent(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(HardwareComponent component) {
        children.add(component);
    }

    public void remove(HardwareComponent component) {
        children.remove(component);
    }

    public void display(String indent) {
        System.out.println(indent + "- " + name);
        for (HardwareComponent child : children) {
            child.display(indent + "  ");
        }
    }
}