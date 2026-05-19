package Adapter;

public class LinuxMetricsAdapter implements SystemMetricsProvider {
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