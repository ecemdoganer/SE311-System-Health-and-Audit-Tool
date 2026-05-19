package Composite;

import Visitor.SystemVisitor;

public interface HardwareComponent {
    String getName();
    void add(HardwareComponent component);
    void remove(HardwareComponent component);
    void display(String indent);
    void accept(SystemVisitor visitor);
}