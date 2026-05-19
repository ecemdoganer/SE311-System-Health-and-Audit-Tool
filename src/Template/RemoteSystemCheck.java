package Template;
import Singleton.ReportManager;

public class RemoteSystemCheck extends SystemCheckTemplate {
    @Override
    protected void setup() {
        ReportManager.getInstance().addLog("--- 1. SETUP STEP ---");
        ReportManager.getInstance().addLog("Establishing secure SSH connection to remote server...");
    }
}