

interface SystemMetricsProvider {
    String getProcessorInfo();
    String getMemoryUsage();
    String getProcessUsage();
    String getNICInformation();
    String getFreeDiskSpace();
}

class WindowsMetricsAdapter implements SystemMetricsProvider {
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

class LinuxMetricsAdapter implements SystemMetricsProvider {
    private String prefix;

    public LinuxMetricsAdapter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getProcessorInfo() {
        return prefix + "LINUX (uname): Linux 5.15.0-generic, x86_64, GNU/Linux";
    }

    @Override
    public String getMemoryUsage() {
        return prefix + "LINUX (/proc/meminfo): MemTotal: 16384000 kB, MemFree: 4194304 kB";
    }

    @Override
    public String getProcessUsage() {
        return prefix + "LINUX (/proc/stat): PID 2048 [python3] - user 450, system 120, idle 3000";
    }

    @Override
    public String getNICInformation() {
        return prefix + "LINUX (getifaddrs): eth0 - inet 10.0.0.5, netmask 255.255.255.0";
    }

    @Override
    public String getFreeDiskSpace() {
        return prefix + "LINUX (statvfs): /dev/sda1 - Block Size 4096, Blocks Free 15000000";
    }
}

class MacOSMetricsAdapter implements SystemMetricsProvider {
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