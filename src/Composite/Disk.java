package Composite;

import Visitor.SystemVisitor;

public class Disk extends AbstractHardwareComponent {
    private int capacityGB;
    private int usagePercentage;
    private boolean encrypted;

    public Disk(String name, int capacityGB, int usagePercentage, boolean encrypted) {
        super(name);
        this.capacityGB = capacityGB;
        this.usagePercentage = usagePercentage;
        this.encrypted = encrypted;
    }

    public int getUsagePercentage() { return usagePercentage; }
    public boolean isEncrypted() { return encrypted; }

    @Override
    public void accept(SystemVisitor visitor) { visitor.visitDisk(this); }
}