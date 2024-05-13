public class GPU extends Component{


    protected String port;
    protected double clock;

    public GPU(int id,String type , String manufacturer, String name, String port, double clock){
        super(id,type,manufacturer,name);
        this.port = port;
        this.clock = clock;

    }


    public String getPort(){
        return port;
    }

    public void setPort(String port){
        this.port = port;
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