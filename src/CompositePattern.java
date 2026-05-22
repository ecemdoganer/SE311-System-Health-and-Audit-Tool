import java.util.ArrayList;
import java.util.List;

interface HardwareComponent {
    String getName();
    void add(HardwareComponent component);
    void remove(HardwareComponent component);
    void display(String indent);
    void accept(SystemVisitor visitor);
}

abstract class AbstractHardwareComponent implements HardwareComponent {
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

class Computer extends AbstractHardwareComponent {
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

class Motherboard extends AbstractHardwareComponent {
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

class CPU extends AbstractHardwareComponent {
    private int coreCount;
    private int usagePercentage;

    public CPU(String name, int coreCount, int usagePercentage) {
        super(name);
        this.coreCount = coreCount;
        this.usagePercentage = usagePercentage;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public int getUsagePercentage() {
        return usagePercentage;
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitCPU(this);
    }
}

class Memory extends AbstractHardwareComponent {
    private int sizeGB;
    private int usedMemoryMB;

    public Memory(String name, int sizeGB, int usedMemoryMB) {
        super(name);
        this.sizeGB = sizeGB;
        this.usedMemoryMB = usedMemoryMB;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public int getUsedMemoryMB() {
        return usedMemoryMB;
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitMemory(this);
    }
}

class Disk extends AbstractHardwareComponent {
    private int capacityGB;
    private int usagePercentage;
    private boolean encrypted;

    public Disk(String name, int capacityGB, int usagePercentage, boolean encrypted) {
        super(name);
        this.capacityGB = capacityGB;
        this.usagePercentage = usagePercentage;
        this.encrypted = encrypted;
    }

    public int getCapacityGB() {
        return capacityGB;
    }

    public int getUsagePercentage() {
        return usagePercentage;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitDisk(this);
    }
}

class ISABus extends AbstractHardwareComponent {
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

class NIC extends AbstractHardwareComponent {
    private String ipAddress;
    private boolean openPortDetected;

    public NIC(String name, String ipAddress, boolean openPortDetected) {
        super(name);
        this.ipAddress = ipAddress;
        this.openPortDetected = openPortDetected;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean hasOpenPortDetected() {
        return openPortDetected;
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitNIC(this);
    }
}

class ProcessInfo extends AbstractHardwareComponent {
    private int memoryUsageMB;

    public ProcessInfo(String name, int memoryUsageMB) {
        super(name);
        this.memoryUsageMB = memoryUsageMB;
    }

    public int getMemoryUsageMB() {
        return memoryUsageMB;
    }

    @Override
    public void accept(SystemVisitor visitor) {
        visitor.visitProcess(this);
    }
}