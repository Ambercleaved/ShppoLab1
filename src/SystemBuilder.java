public class SystemBuilder {
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;

    public SystemBuilder addMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    public SystemBuilder addCPU(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public SystemBuilder addGPU(GPU gpu) {
        this.gpu = gpu;
        return this;
    }

    public PcSystem build() {
        return new PcSystem(motherboard, cpu, gpu);
    }
}
