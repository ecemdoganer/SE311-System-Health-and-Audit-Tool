package Composite;

import Visitor.SystemVisitor;

public class ProcessInfo extends AbstractHardwareComponent {
    private int memoryUsageMB;

    public ProcessInfo(String name, int memoryUsageMB) {
        super(name);
        this.memoryUsageMB = memoryUsageMB;
    }

    public int getMemoryUsageMB() { return memoryUsageMB; }

    @Override
    public void accept(SystemVisitor visitor) { visitor.visitProcess(this); }
}