class SystemHealthFacade {

    public void runSecurityAudit(OSType os, MachineType machine) {
        SystemCheckTemplate check = createCheckInstance(machine);
        check.setMetricsProvider(OSAbstractionLayer.createProvider(os, machine));
        check.addTask(new SecurityAuditor());
        check.runSystemCheck();
    }

    public void runResourceOptimization(OSType os, MachineType machine) {
        SystemCheckTemplate check = createCheckInstance(machine);
        check.setMetricsProvider(OSAbstractionLayer.createProvider(os, machine));
        check.addTask(new ResourceOptimizer());
        check.runSystemCheck();
    }

    public void runFullDiagnostics(OSType os, MachineType machine) {
        SystemCheckTemplate check = createCheckInstance(machine);
        check.setMetricsProvider(OSAbstractionLayer.createProvider(os, machine));
        check.addTask(new SecurityAuditor());
        check.addTask(new ResourceOptimizer());
        check.runSystemCheck();
    }

    private SystemCheckTemplate createCheckInstance(MachineType machine) {
        if (machine == MachineType.LOCAL) {
            return new LocalSystemCheck();
        } else {
            return new RemoteSystemCheck();
        }
    }
}