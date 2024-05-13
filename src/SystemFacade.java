import java.util.List;

public class SystemFacade {
    private List<Motherboard> motherboards;
    private List<CPU> cpus;
    private List<GPU> gpus;

    public SystemFacade(List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        this.motherboards = motherboards;
        this.cpus = cpus;
        this.gpus = gpus;
    }

    public void buildAndOutputSystems(ComponentVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("ComponentVisitor cannot be null");
        }

        // Create a SystemIterator to iterate over all combinations of components
        SystemIterator iterator = new SystemIterator(motherboards, cpus, gpus);

        // Iterate over each combination and build systems
        while (iterator.hasNext()) {
            SystemBuilder builder = iterator.next();
            if (builder != null) {
                // Build system
                PcSystem pcsystem = builder.build();
                // Output system details using the ComponentVisitor
                pcsystem.accept(visitor);
            }
        }
    }
}
