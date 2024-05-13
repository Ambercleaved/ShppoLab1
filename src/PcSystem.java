public class PcSystem {
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;

    public PcSystem(Motherboard motherboard, CPU cpu, GPU gpu) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public CPU getCPU() {
        return cpu;
    }

    public GPU getGPU() {
        return gpu;
    }
    public void accept(IVisitor visitor) {
        visitor.visit(cpu);
        visitor.visit(gpu);
        visitor.visit(motherboard);
    }
}