package Template;

import Adapter.SystemMetricsProvider;
import Composite.*;
import Singleton.ReportManager;
import Visitor.SystemVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class SystemCheckTemplate {
    protected SystemMetricsProvider metricsProvider;
    protected Computer systemComputer;
    protected List<SystemVisitor> activeTasks = new ArrayList<>();

    public void setMetricsProvider(SystemMetricsProvider provider) {
        this.metricsProvider = provider;
    }

    public void addTask(SystemVisitor visitor) {
        this.activeTasks.add(visitor);
    }

    public final void runSystemCheck() {
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

        // Yeni SystemModel yapısına göre simüle veri ataması
        systemComputer = new Computer("Mainframe Computer");
        systemComputer.add(new CPU("Intel Core i9", 8, 90));
        systemComputer.add(new Memory("Corsair Vengeance", 16, 10000));
        systemComputer.add(new Disk("Samsung NVMe", 512, 95, false));
        systemComputer.add(new ProcessInfo("malware.exe", 300));

        ReportManager.getInstance().addLog("Hardware component tree initialized.");
    }

    protected void checkData() {
        ReportManager.getInstance().addLog("--- 3. DATA VERIFICATION STEP ---");
        if (systemComputer != null) {
            ReportManager.getInstance().addLog("System data verified for analysis.");
        }
    }

    protected void performAnalysis() {
        ReportManager.getInstance().addLog("--- 4. ANALYSIS STEP ---");
        for (SystemVisitor task : activeTasks) {
            systemComputer.accept(task);
        }
    }

    protected void generateReport() {
        ReportManager.getInstance().printReport();
    }
}