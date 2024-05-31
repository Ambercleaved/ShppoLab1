public class ComponentVisitor implements IVisitor {
    @Override
    public void visit(CPU cpu) {
        System.out.println("Id: " + cpu.getId() + " , type: " + cpu.getType() +
                " , manufacturer: " + cpu.getManufacturer() + " , name: " + cpu.getName()
                + " , Amount of cores: " + cpu.getAmountCores() + " , Socket: " + cpu.getSocket()
                + " , Clock: " + cpu.getClock());
    }

    @Override
    public void visit(GPU gpu) {
        System.out.println("Id: " + gpu.getId() + " , type: " + gpu.getType() +
                " , manufacturer: " + gpu.getManufacturer() + " , name: " + gpu.getName()
                + " , Port: " + gpu.getPort() + " , Clock: " + gpu.getClock());
    }

    @Override
    public void visit(Motherboard mb) {
        System.out.println("Id: " + mb.getId() + " , type: " + mb.getType() +
                " , manufacturer: " + mb.getManufacturer() + " , name: " + mb.getName()
                + " , Port: " + mb.getPort() + " , Socket: " + mb.getSocket());
    }

    public void visit(PcSystem pcSystem) {
        System.out.println("Visiting PcSystem:");
        for (Component component : pcSystem.getComponents()) {
            component.accept(this);
        }
    }
}
