public class ComponentVisitor implements IVisitor{
    @Override
    public void visit(CPU cpu){
        System.out.println("Id: " + cpu.getId() + " , type: " + cpu.getType() +
                " , manufacturer: " + cpu.getType()+ " , name: " + cpu.getName()
                + " , Amount of cores: " + cpu.getAmountCores() +" , Socket: " + cpu.getSocket()
                + " , Clock: " + cpu.getCLock());


    }
    @Override
    public void visit(GPU gpu){
        System.out.println("Id: " + gpu.getId() + " , type: " + gpu.getType() +
                " , manufacturer: " + gpu.getType()+ " , name: " + gpu.getName()
                +" , Port: " + gpu.getPort() + " , Clock: " + gpu.getCLock());


    }
    @Override
    public void visit(Motherboard mb){
        System.out.println("Id: " + mb.getId() + " , type: " + mb.getType() +
                " , manufacturer: " + mb.getType()+ " , name: " + mb.getName()
                +" , Port: " + mb.getPort() + " , Socket: " + mb.getSocket());


    }
}
