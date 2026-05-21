package Visitor;

import Composite.*;
import Singleton.ReportManager;

public class ResourceOptimizer implements SystemVisitor {

    @Override
    public void visitComputer(Computer computer) {
        ReportManager.getInstance().addLog("=== RESOURCE OPTIMIZATION ===");
    }

    @Override
    public void visitCPU(CPU cpu) {
        if (cpu.getUsagePercentage() > 80) {
            ReportManager.getInstance().addLog("WARNING: High CPU usage detected! ("
                    + cpu.getUsagePercentage() + "%)");
        }
    }

    @Override
    public void visitMemory(Memory memory) {
        if (memory.getUsedMemoryMB() > 8000) {
            ReportManager.getInstance().addLog("WARNING: High memory consumption! ("
                    + memory.getUsedMemoryMB() + " MB)");
        }
    }

    @Override
    public void visitDisk(Disk disk) {
        if (disk.getUsagePercentage() > 90) {
            ReportManager.getInstance().addLog("WARNING: Disk capacity critical! ("
                    + disk.getUsagePercentage() + "%)");
        }
    }

    @Override
    public void visitProcess(ProcessInfo process) {
        if (process.getMemoryUsageMB() > 500) {
            ReportManager.getInstance().addLog("Heavy process detected: " + process.getName()
                    + " using " + process.getMemoryUsageMB() + " MB");
        }
    }

    @Override
    public void visitNIC(NIC nic) {
        // NIC optimization is not required in this demo.
    }
}