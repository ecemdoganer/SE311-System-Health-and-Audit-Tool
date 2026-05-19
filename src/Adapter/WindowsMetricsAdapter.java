package Adapter;

public class WindowsMetricsAdapter implements SystemMetricsProvider {
    private String prefix;

    public WindowsMetricsAdapter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getProcessorInfo() {
        return prefix + "WINDOWS (GetSystemInfo): 8 Cores, x64 Architecture, Page Size 4096 Bytes";
    }

    @Override
    public String getMemoryUsage() {
        return prefix + "WINDOWS (GlobalMemoryStatusEx): Total 16GB, Free 4GB, Memory Load 75%";
    }

    @Override
    public String getProcessUsage() {
        return prefix + "WINDOWS (GetProcessTimes): PID 1024 [chrome.exe] - CPU Time 120s, RAM 1.2GB";
    }

    @Override
    public String getNICInformation() {
        return prefix + "WINDOWS (GetAdaptersAddresses): Ethernet0 - IPv4 192.168.1.55, Status: Up";
    }

    @Override
    public String getFreeDiskSpace() {
        return prefix + "WINDOWS (GetDiskFreeSpace): C:\\ Drive - Total 512GB, Free 120GB";
    }
}