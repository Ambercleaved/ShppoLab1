public class GPU implements Component {
    protected int id;
    protected String type;
    protected String manufacturer;
    protected String name;
    protected String port;
    protected double clock;

    public GPU(int id, String type, String manufacturer, String name, String port, double clock) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;
        this.port = port;
        this.clock = clock;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}