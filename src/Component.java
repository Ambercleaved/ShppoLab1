public interface Component {
    int getId();
    String getType();
    String getManufacturer();
    String getName();
    void accept(ComponentVisitor visitor);
}
