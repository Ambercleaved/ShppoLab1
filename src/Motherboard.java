public class Motherboard implements Component {
    protected int id;
    protected String type;
    protected String manufacturer;
    protected String name;
    protected String port;
    protected String socket;

    public Motherboard(int id, String type, String manufacturer, String name, String port, String socket) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;
        this.port = port;
        this.socket = socket;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}