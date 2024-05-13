public class CPU extends Component{

    protected int amountCores;
    protected String socket;
    protected double clock;

    public CPU(int id,String type , String manufacturer, String name, int amountCores, String socket, double clock){
        super(id,type,manufacturer,name);
        this.amountCores = amountCores;
        this.socket = socket;
        this.clock = clock;

    }
    public int getAmountCores(){
        return amountCores;
    }

    public void setAmountCores(int amountCores){
        this.amountCores = amountCores;
    }

    public String getSocket(){
        return socket;
    }

    public void setSocket(String socket){
        this.socket = socket;
    }

    public double getCLock(){
        return clock;
    }

    public void setClock(double clock){
        this.clock = clock;
    }

    public void accept(ComponentVisitor visitor){
        visitor.visit(this);
    };
}
