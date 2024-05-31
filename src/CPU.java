public class CPU implements Component {
    protected int id;
    protected String type;
    protected String manufacturer;
    protected String name;
    protected int amountCores;
    protected String socket;
    protected double clock;

    public CPU(int id, String type, String manufacturer, String name, int amountCores, String socket, double clock) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;
        this.amountCores = amountCores;
        this.socket = socket;
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

    public int getAmountCores() {
        return amountCores;
    }

    public void setAmountCores(int amountCores) {
        this.amountCores = amountCores;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
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
