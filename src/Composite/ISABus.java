package Composite;

import Visitor.SystemVisitor;

public class ISABus extends AbstractHardwareComponent {
    public ISABus(String name) {
        super(name);
    }

    @Override
    public void accept(SystemVisitor visitor) {
        for (HardwareComponent child : children) {
            child.accept(visitor);
        }
    }
}