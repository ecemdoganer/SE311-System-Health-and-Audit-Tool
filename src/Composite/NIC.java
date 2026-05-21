package Composite;

import Visitor.SystemVisitor;

public class NIC extends AbstractHardwareComponent {
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