package Template;

import Singleton.ReportManager;

public class RemoteSystemCheck extends SystemCheckTemplate {

    @Override
    protected void setup() {
        System.out.println("--- [Remote] Uzak Sunucu Bağlantısı Kuruluyor ---");
        System.out.println("SSH/IP bağlantısı simüle ediliyor... Bağlantı başarılı.");

        ReportManager.getInstance().addLog("Uzak sunucu bağlantısı sağlandı ve kurulum yapıldı.");
    }
}
