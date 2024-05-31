import java.util.Iterator;
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


    public void displayComponents(){
        ComponentVisitor visitor = new ComponentVisitor();

        System.out.println("Процессоры:");
        Iterator<CPU> cpuIterator = cpus.iterator();
        while (cpuIterator.hasNext()) {
            CPU cpu = cpuIterator.next();
            cpu.accept(visitor);
        }

        System.out.println("Видеокарты:");
        Iterator<GPU> gpuIterator = gpus.iterator();
        while (gpuIterator.hasNext()) {
            GPU gpu = gpuIterator.next();
            gpu.accept(visitor);
        }

        System.out.println("Материнские платы:");
        Iterator<Motherboard> motherboardIterator = motherboards.iterator();
        while (motherboardIterator.hasNext()) {
            Motherboard motherboard = motherboardIterator.next();
            motherboard.accept(visitor);
        }
    }



    public void buildAndOutputSystems(ComponentVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("ComponentVisitor cannot be null");
        }

        // Create a SystemIterator to iterate over all combinations of components
        SystemIterator systemiterator = new SystemIterator(motherboards, cpus, gpus);
        // Iterate over each combination and build systems
        while (systemiterator.hasNext()) {
            SystemBuilder builder = systemiterator.next();
            if (builder != null) {
                // Build system
                PcSystem pcSystem = builder.build();
                // Output system details using the ComponentVisitor
                pcSystem.accept(visitor);
            }
        }
    }
}
