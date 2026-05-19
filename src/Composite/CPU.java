package Composite;

import Visitor.SystemVisitor;

public class CPU extends AbstractHardwareComponent {
    private int coreCount;
    private int usagePercentage;

    public CPU(String name, int coreCount, int usagePercentage) {
        super(name);
        this.coreCount = coreCount;
        this.usagePercentage = usagePercentage;
    }

    public int getUsagePercentage() { return usagePercentage; }

    @Override
    public void accept(SystemVisitor visitor) { visitor.visitCPU(this); }
}