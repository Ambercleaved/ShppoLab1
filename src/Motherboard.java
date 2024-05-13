public class Motherboard extends Component{


    protected String port;
    protected String socket;

    public Motherboard(int id,String type , String manufacturer, String name, String port, String socket){
        super(id,type,manufacturer,name);
        this.port = port;
        this.socket = socket;

    }


    public String getPort(){
        return port;
    }

    public void setPort(String port){
        this.port = port;
    }

    public String getSocket(){
        return socket;
    }

    public void setSocket(String clock){
        this.socket = socket;
    }

    public void accept(ComponentVisitor visitor){
        visitor.visit(this);
    };
}
