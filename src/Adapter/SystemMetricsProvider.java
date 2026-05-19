package Adapter;

public interface SystemMetricsProvider {
    String getProcessorInfo();
    String getMemoryUsage();
    String getProcessUsage();
    String getNICInformation();
    String getFreeDiskSpace();
}