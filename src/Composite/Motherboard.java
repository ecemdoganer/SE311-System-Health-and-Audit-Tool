package Composite;

import Visitor.SystemVisitor;

public class Motherboard extends AbstractHardwareComponent {
    public Motherboard(String name) {
        super(name);
    }

    @Override
    public void accept(SystemVisitor visitor) {
        for (HardwareComponent child : children) {
            child.accept(visitor);
        }
    }
}