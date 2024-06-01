public interface IVisitor {
    void visit(GPU gpu);
    void visit(CPU cpu);
    void visit(Motherboard mb);

    void visit(PcSystem pcSystem);
}
