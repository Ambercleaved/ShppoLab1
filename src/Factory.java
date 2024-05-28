public class Factory {
    private static int nextId = 1;

    public static int getNextId() {
        return nextId++;
    }



    public static CPU createCPU(String manufacturer, String name, int amountCores, String socket, double clock){
        int id = getNextId();
        return new CPU(id, "cpu", manufacturer, name, amountCores, socket, clock);
    }
    public static GPU createGPU(String manufacturer, String name, String port, double clock){
        int id = getNextId();
        return new GPU(id, "gpu", manufacturer, name, port, clock);
    }
    public static Motherboard createMotherboard(String manufacturer, String name, String port, String socket){
        int id = getNextId();
        return new Motherboard(id, "motherboard", manufacturer, name, port, socket);
    }
}
