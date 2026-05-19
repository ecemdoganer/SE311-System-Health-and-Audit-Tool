package Composite;

import Visitor.SystemVisitor;

public class Computer extends AbstractHardwareComponent {
    public Computer(String name) {
        super(name);
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitComputer(this);
        for (HardwareComponent child : children) {
            child.accept(visitor);
        }
    }
}