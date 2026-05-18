package Template;

import Singleton.ReportManager;

public class LocalSystemCheck extends SystemCheckTemplate {

    @Override
    protected void setup() {
        System.out.println("--- [Local] Yerel Makine Ayarları Yapılıyor ---");
        ReportManager.getInstance().addLog("Yerel makine için sistem kontrol kurulumu yapıldı.");
    }
}