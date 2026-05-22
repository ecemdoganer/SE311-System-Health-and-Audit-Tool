interface SystemVisitor {
    void visitComputer(Computer computer);
    void visitCPU(CPU cpu);
    void visitMemory(Memory memory);
    void visitDisk(Disk disk);
    void visitProcess(ProcessInfo process);
    void visitNIC(NIC nic);
}

class SecurityAuditor implements SystemVisitor {

    @Override
    public void visitComputer(Computer computer) {
        ReportManager.getInstance().addLog("=== SECURITY AUDIT ===");
    }

    @Override
    public void visitCPU(CPU cpu) {
        // Not used
    }

    @Override
    public void visitMemory(Memory memory) {
        // Not used
    }

    @Override
    public void visitDisk(Disk disk) {
        if (!disk.isEncrypted()) {
            ReportManager.getInstance().addLog("WARNING: Disk encryption disabled!");
        }
    }

    @Override
    public void visitProcess(ProcessInfo process) {
        if (process.getName().equalsIgnoreCase("malware.exe")) {
            ReportManager.getInstance().addLog("CRITICAL: Suspicious process detected! -> " + process.getName());
        }
    }

    @Override
    public void visitNIC(NIC nic) {
        if (nic.hasOpenPortDetected()) {
            ReportManager.getInstance().addLog("WARNING: Open port detected on NIC "
                    + nic.getName() + " with IP " + nic.getIpAddress());
        }
    }
}

class ResourceOptimizer implements SystemVisitor {

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
        // Not used
    }
}