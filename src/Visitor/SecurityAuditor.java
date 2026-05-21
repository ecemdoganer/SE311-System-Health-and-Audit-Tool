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
        // No security rule is applied to CPU in this demo.
    }

    @Override
    public void visitMemory(Memory memory) {
        // No security rule is applied to memory in this demo.
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