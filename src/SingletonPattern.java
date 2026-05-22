import java.util.ArrayList;
import java.util.List;

class ReportManager {
    private static ReportManager instance;
    private List<String> logs;

    private ReportManager() {
        logs = new ArrayList<>();
    }

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    public void addLog(String message) {
        logs.add(message);
    }

    public void printReport() {
        System.out.println("=== SYSTEM HEALTH AND AUDIT REPORT ===");
        for (String log : logs) {
            System.out.println("- " + log);
        }
        System.out.println("======================================");
    }

    public void clearReport() {
        logs.clear();
    }
}