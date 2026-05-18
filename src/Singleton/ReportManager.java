package Singleton;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {

    // Static so it can be accessed by the static getInstance() method ensuring it remains the only global instance
    private static ReportManager instance;
    private List<String> logs;


    // Constructor MUST BE PRIVATE that way the system cannot get "new ReportManager()" call from anywhere else
    private ReportManager() {
        logs = new ArrayList<>();
    }

    // Global Access Point
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