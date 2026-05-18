package Composite;

import java.util.ArrayList;
import java.util.List;

interface HardwareComponent {
    String getName();

    void add(HardwareComponent component);

    void remove(HardwareComponent component);

    void display(String indent);
}

abstract class AbstractHardwareComponent implements HardwareComponent {
    private String name;
    private List<HardwareComponent> children;

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
}

class Motherboard extends AbstractHardwareComponent {
    public Motherboard(String name) {
        super(name);
    }
}

class ISABus extends AbstractHardwareComponent {
    public ISABus(String name) {
        super(name);
    }
}

class CPU extends AbstractHardwareComponent {
    private int coreCount;

    public CPU(String name, int coreCount) {
        super(name);
        this.coreCount = coreCount;
    }

    public int getCoreCount() {
        return coreCount;
    }
}

class Memory extends AbstractHardwareComponent {
    private int sizeGB;

    public Memory(String name, int sizeGB) {
        super(name);
        this.sizeGB = sizeGB;
    }

    public int getSizeGB() {
        return sizeGB;
    }
}

class Disk extends AbstractHardwareComponent {
    private int capacityGB;

    public Disk(String name, int capacityGB) {
        super(name);
        this.capacityGB = capacityGB;
    }

    public int getCapacityGB() {
        return capacityGB;
    }
}

class NetworkInterfaceCard extends AbstractHardwareComponent {
    private String ipAddress;

    public NetworkInterfaceCard(String name, String ipAddress) {
        super(name);
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}

class ProcessInfo {
    private String processName;
    private int memoryUsageMB;

    public ProcessInfo(String processName, int memoryUsageMB) {
        this.processName = processName;
        this.memoryUsageMB = memoryUsageMB;
    }

    public String getProcessName() {
        return processName;
    }

    public int getMemoryUsageMB() {
        return memoryUsageMB;
    }
}