package Composite;

import Visitor.SystemVisitor;

public class Memory extends AbstractHardwareComponent {
    private int sizeGB;
    private int usedMemoryMB;

    public Memory(String name, int sizeGB, int usedMemoryMB) {
        super(name);
        this.sizeGB = sizeGB;
        this.usedMemoryMB = usedMemoryMB;
    }

    public int getUsedMemoryMB() { return usedMemoryMB; }

    @Override
    public void accept(SystemVisitor visitor) { visitor.visitMemory(this); }
}