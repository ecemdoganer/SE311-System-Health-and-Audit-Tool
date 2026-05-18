package Template;

import Singleton.ReportManager;

public abstract class SystemCheckTemplate {

    protected Computer systemComputer;

    // Kişi 1'in OS soyutlama arayüzü
    protected SystemMetricsProvider metricsProvider;

    // Constructor veya Setter ile metricsProvider'ı dışarıdan (Facade'den) alacağız
    public void setMetricsProvider(SystemMetricsProvider provider) {
        this.metricsProvider = provider;
    }

    public final void runSystemCheck() {
        setup();
        collectData();
        checkData();
        performAnalysis();
        generateReport();
    }

    protected abstract void setup();

    protected void collectData() {
        System.out.println("--- [Template] Veri Toplama Adımı Başladı ---");

        if (metricsProvider == null) {
            ReportManager.getInstance().addLog("HATA: OS Metrics Provider bulunamadı!");
            return;
        }

        // KİŞİ 1'İN METOTLARINI CAGIRDIK
        String cpuData = metricsProvider.getProcessorInfo();
        String memoryData = metricsProvider.getMemoryUsage();
        String processData = metricsProvider.getProcessUsage();
        String nicData = metricsProvider.getNICInformation();
        String diskData = metricsProvider.getFreeDiskSpace();

        ReportManager.getInstance().addLog("İşletim Sistemi Ham Verileri Çekildi:");
        ReportManager.getInstance().addLog(" - CPU: " + cpuData);
        ReportManager.getInstance().addLog(" - Memory: " + memoryData);
        ReportManager.getInstance().addLog(" - Processes: " + processData);
        ReportManager.getInstance().addLog(" - NIC: " + nicData);
        ReportManager.getInstance().addLog(" - Disk: " + diskData);

        systemComputer = new Computer();
        systemComputer.addComponent(new CPU(85)); // Örn: %85 kullanım (Kritik uyarı tetikler)
        systemComputer.addComponent(new Memory(9000)); // Örn: 9000 MB kullanım
        systemComputer.addComponent(new Disk(95, false)); // Şifresiz ve %95 dolu
        systemComputer.addComponent(new ProcessInfo("chrome.exe", 700));
        systemComputer.addComponent(new ProcessInfo("malware.exe", 300));

        ReportManager.getInstance().addLog("Donanım nesne modeli başarıyla oluşturuldu.");
    }

    // ... (checkData, performAnalysis ve generateReport metotları önceki mesajdaki gibi kalacak)
}