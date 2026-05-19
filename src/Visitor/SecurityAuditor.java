package Visitor;

import Composite.*;
import Singleton.ReportManager;

public class SecurityAuditor implements SystemVisitor {

    @Override
    public void visitComputer(Computer computer) {
        ReportManager.getInstance().addLog("=== SECURITY AUDIT ===");
    }

    @Override
    public void visitCPU(CPU cpu) {
        // CPU şimdilik boş
    }

    @Override
    public void visitMemory(Memory memory) {
        // Memory şimdilik boş
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
}