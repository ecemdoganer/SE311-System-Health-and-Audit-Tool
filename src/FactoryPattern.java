enum MachineType {
    LOCAL, REMOTE
}

enum OSType {
    WINDOWS, LINUX, MACOS
}

class OSAbstractionLayer {

    public static SystemMetricsProvider createProvider(OSType os, MachineType machineType) {

        String connectionType = (machineType == MachineType.REMOTE)
                ? "[REMOTE CONNECTION ESTABLISHED] "
                : "[LOCAL EXECUTION] ";

        switch (os) {
            case WINDOWS:
                return new WindowsMetricsAdapter(connectionType);
            case LINUX:
                return new LinuxMetricsAdapter(connectionType);
            case MACOS:
                return new MacOSMetricsAdapter(connectionType);
            default:
                throw new IllegalArgumentException("Unsupported OS: " + os);
        }
    }
}