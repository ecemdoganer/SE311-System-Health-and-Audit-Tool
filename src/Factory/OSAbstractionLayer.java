package Factory;

import Adapter.SystemMetricsProvider;
import Adapter.WindowsMetricsAdapter;
import Adapter.LinuxMetricsAdapter;
import Adapter.MacOSMetricsAdapter;

public class OSAbstractionLayer {

    public static SystemMetricsProvider createProvider(OSType os, MachineType machineType) {

        String connectionType = (machineType == MachineType.REMOTE) ? "[REMOTE CONNECTION ESTABLISHED] "
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