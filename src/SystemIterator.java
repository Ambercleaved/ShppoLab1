import java.util.Iterator;
import java.util.List;

public class SystemIterator implements Iterator<SystemBuilder> {
    private List<Motherboard> motherboards;
    private List<CPU> cpus;
    private List<GPU> gpus;
    private Iterator<Motherboard> motherboardIterator;
    private Iterator<CPU> cpuIterator;
    private Iterator<GPU> gpuIterator;
    private Motherboard currentMotherboard;
    private CPU currentCPU;
    private GPU currentGPU;

    public SystemIterator(List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        this.motherboards = motherboards;
        this.cpus = cpus;
        this.gpus = gpus;
        this.motherboardIterator = motherboards.iterator();
        this.cpuIterator = cpus.iterator();
        this.gpuIterator = gpus.iterator();
    }

    @Override
    public boolean hasNext() {
        while (currentMotherboard == null || !cpuIterator.hasNext() || !gpuIterator.hasNext()) {
            if (!motherboardIterator.hasNext()) {
                return false; // No more combinations
            }
            currentMotherboard = motherboardIterator.next();
            cpuIterator = cpus.iterator(); // Reset CPU iterator
            gpuIterator = gpus.iterator(); // Reset GPU iterator
        }
        return true;
    }

    @Override
    public SystemBuilder next() {
        while (currentMotherboard == null || !cpuIterator.hasNext() || !gpuIterator.hasNext()) {
            if (!motherboardIterator.hasNext()) {
                return null; // No more combinations
            }
            currentMotherboard = motherboardIterator.next();
            cpuIterator = cpus.iterator(); // Reset CPU iterator
            gpuIterator = gpus.iterator(); // Reset GPU iterator
        }
        currentCPU = cpuIterator.next();
        while (!gpuIterator.hasNext()) {
            if (!cpuIterator.hasNext()) {
                return next(); // Try next CPU
            }
            currentCPU = cpuIterator.next();
            gpuIterator = gpus.iterator(); // Reset GPU iterator
        }
        currentGPU = gpuIterator.next();
        if (isCompatible(currentMotherboard, currentCPU, currentGPU)) {
            return new SystemBuilder()
                    .addMotherboard(currentMotherboard)
                    .addCPU(currentCPU)
                    .addGPU(currentGPU);
        }
        return next(); // Try next GPU
    }

    private boolean isCompatible(Motherboard motherboard, CPU cpu, GPU gpu) {
        // Perform compatibility checks here
        return motherboard.getSocket().equals(cpu.getSocket()) &&
                motherboard.getPort().equals(gpu.getPort());
    }
}