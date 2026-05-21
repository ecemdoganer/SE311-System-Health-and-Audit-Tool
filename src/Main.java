import Facade.SystemHealthFacade;
import Factory.MachineType;
import Factory.OSType;

public class Main {
    public static void main(String[] args) {
        SystemHealthFacade facade = new SystemHealthFacade();

        facade.runFullDiagnostics(OSType.WINDOWS, MachineType.LOCAL);
    }
}