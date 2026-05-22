//Yağız Efe VARLI
//Ecem DOĞANER
//Cihat DİKYER
//Eren AYAS
// System Health and Audit Tool

public class SystemHealthAuditDemo {
    public static void main(String[] args) {
        SystemHealthFacade facade = new SystemHealthFacade();

        facade.runFullDiagnostics(OSType.WINDOWS, MachineType.LOCAL);
    }
}