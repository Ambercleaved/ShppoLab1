public class Factory {
    public static CPU createCPU(int id,String type , String manufacturer, String name, int amountCores, String socket, double clock){
        return new CPU(id, type, manufacturer, name, amountCores, socket, clock);
    }
    public static GPU createGPU(int id,String type , String manufacturer, String name, String port, double clock){
        return new GPU(id, type, manufacturer, name, port, clock);
    }
    public static Motherboard createMotherboard(int id,String type , String manufacturer, String name, String port, String socket){
        return new Motherboard(id, type, manufacturer, name, port, socket);
    }
}
