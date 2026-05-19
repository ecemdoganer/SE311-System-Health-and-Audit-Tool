package Template;
import Singleton.ReportManager;

public class LocalSystemCheck extends SystemCheckTemplate {
    @Override
    protected void setup() {
        ReportManager.getInstance().addLog("--- 1. SETUP STEP ---");
        ReportManager.getInstance().addLog("Verifying local machine privileges...");
    }
}