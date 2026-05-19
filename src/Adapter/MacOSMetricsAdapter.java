package Adapter;

public class MacOSMetricsAdapter implements SystemMetricsProvider {
    private String prefix;

    public MacOSMetricsAdapter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getProcessorInfo() {
        return prefix + "MACOS (sysctl hw.machine): Apple M2, 8 Cores, ARM64";
    }

    @Override
    public String getMemoryUsage() {
        return prefix + "MACOS (vm_stat): Pages free 1048576, Page size 16384 bytes";
    }

    @Override
    public String getProcessUsage() {
        return prefix + "MACOS (proc_pidinfo): PID 555 [safari] - CPU Time 85s";
    }

    @Override
    public String getNICInformation() {
        return prefix + "MACOS (ifconfig): en0 - inet 192.168.0.12, status: active";
    }

    @Override
    public String getFreeDiskSpace() {
        return prefix + "MACOS (statfs): /System/Volumes/Data - Free 200GB";
    }
}