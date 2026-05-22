import java.util.ArrayList;
import java.util.List;

abstract class SystemCheckTemplate {
    protected SystemMetricsProvider metricsProvider;
    protected Computer systemComputer;
    protected List<SystemVisitor> activeTasks = new ArrayList<>();

    public void setMetricsProvider(SystemMetricsProvider provider) {
        this.metricsProvider = provider;
    }

    public void addTask(SystemVisitor visitor) {
        activeTasks.add(visitor);
    }

    public final void runSystemCheck() {
        ReportManager.getInstance().clearReport();

        setup();
        collectData();
        checkData();
        performAnalysis();
        generateReport();
    }

    protected abstract void setup();

    protected void collectData() {
        ReportManager.getInstance().addLog("--- 2. DATA COLLECTION STEP ---");

        if (metricsProvider != null) {
            ReportManager.getInstance().addLog(metricsProvider.getProcessorInfo());
            ReportManager.getInstance().addLog(metricsProvider.getMemoryUsage());
            ReportManager.getInstance().addLog(metricsProvider.getProcessUsage());
            ReportManager.getInstance().addLog(metricsProvider.getNICInformation());
            ReportManager.getInstance().addLog(metricsProvider.getFreeDiskSpace());
        }

        systemComputer = new Computer("System Computer");

        Motherboard motherboard = new Motherboard("Main Motherboard");
        CPU cpu = new CPU("Intel Core i9", 8, 90);
        Memory memory = new Memory("System Memory", 16, 10000);
        Disk disk = new Disk("Samsung NVMe Disk", 512, 95, false);
        ISABus isaBus = new ISABus("ISA Bus");
        NIC nic = new NIC("Ethernet NIC", "192.168.1.55", true);
        ProcessInfo suspiciousProcess = new ProcessInfo("malware.exe", 300);
        ProcessInfo heavyProcess = new ProcessInfo("chrome.exe", 900);

        isaBus.add(nic);

        motherboard.add(cpu);
        motherboard.add(memory);
        motherboard.add(isaBus);

        systemComputer.add(motherboard);
        systemComputer.add(disk);
        systemComputer.add(suspiciousProcess);
        systemComputer.add(heavyProcess);

        ReportManager.getInstance().addLog("Hardware component tree initialized.");
    }

    protected void checkData() {
        ReportManager.getInstance().addLog("--- 3. DATA VERIFICATION STEP ---");

        if (systemComputer != null) {
            ReportManager.getInstance().addLog("System data verified");
        } else {
            ReportManager.getInstance().addLog("System data could not be verified.");
        }
    }

    protected void performAnalysis() {
        ReportManager.getInstance().addLog("--- 4. ANALYSIS STEP ---");

        for (SystemVisitor task : activeTasks) {
            systemComputer.accept(task);
        }
    }

    protected void generateReport() {
        ReportManager.getInstance().addLog("--- 5. REPORT GENERATION STEP ---");
        ReportManager.getInstance().printReport();
    }
}

class LocalSystemCheck extends SystemCheckTemplate {
    @Override
    protected void setup() {
        ReportManager.getInstance().addLog("--- 1. SETUP STEP ---");
        ReportManager.getInstance().addLog("Verifying local machine privileges...");
    }
}

class RemoteSystemCheck extends SystemCheckTemplate {
    @Override
    protected void setup() {
        ReportManager.getInstance().addLog("--- 1. SETUP STEP ---");
        ReportManager.getInstance().addLog("Establishing secure SSH connection to remote server...");
    }
}