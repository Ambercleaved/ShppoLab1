import java.util.ArrayList;
import java.util.List;

public class PcSystem implements Component {
    private List<Component> components;

    public PcSystem() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public int getId() {
        return 0; // Composite doesn't have a single ID
    }

    @Override
    public String getType() {
        return "PcSystem";
    }

    @Override
    public String getManufacturer() {
        return "Various";
    }

    @Override
    public String getName() {
        return "PcSystem";
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}