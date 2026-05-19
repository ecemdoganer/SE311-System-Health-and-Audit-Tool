import Facade.SystemHealthFacade;
import Factory.MachineType;
import Factory.OSType;
import Singleton.ReportManager;

public class Main {
    public static void main(String[] args) {

        SystemHealthFacade facade = new SystemHealthFacade();

        System.out.println(">>>> SCENARIO 1: Security Audit only on Windows Local Machine");
        facade.runSecurityAudit(OSType.WINDOWS, MachineType.LOCAL);
        ReportManager.getInstance().clearReport();

        System.out.println("\n>>>> SCENARIO 2: Resource Optimization on Linux Remote Server");
        facade.runResourceOptimization(OSType.LINUX, MachineType.REMOTE);
        ReportManager.getInstance().clearReport();

        System.out.println("\n>>>> SCENARIO 3: Full Diagnostics on macOS Local Machine");
        facade.runFullDiagnostics(OSType.MACOS, MachineType.LOCAL);
        ReportManager.getInstance().clearReport();
    }
}