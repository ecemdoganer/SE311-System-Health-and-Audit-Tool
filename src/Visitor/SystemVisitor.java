package Visitor;

import Composite.*;

public interface SystemVisitor {
    void visitComputer(Computer computer);
    void visitCPU(CPU cpu);
    void visitMemory(Memory memory);
    void visitDisk(Disk disk);
    void visitProcess(ProcessInfo process);
    void visitNIC(NIC nic);
}