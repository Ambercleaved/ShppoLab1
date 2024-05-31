public class SystemBuilder {
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;

    public SystemBuilder() {
    }

    public SystemBuilder withMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    public SystemBuilder withCPU(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public SystemBuilder withGPU(GPU gpu) {
        this.gpu = gpu;
        return this;
    }

    public PcSystem build() {
        PcSystem pcSystem = new PcSystem();
        if (motherboard != null) pcSystem.addComponent(motherboard);
        if (cpu != null) pcSystem.addComponent(cpu);
        if (gpu != null) pcSystem.addComponent(gpu);
        return pcSystem;
    }
}
