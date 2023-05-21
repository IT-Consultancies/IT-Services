package src.main.java.org.example;

public abstract class  Service {
    private String serviceName;
    private String subServiceName;
    private String price;

    public abstract void requestConfiguration();
    public abstract void requestDesign();

    public abstract void requestImplementation();
    public abstract void requestTroubleshooting();

    public abstract void requestConsulting();
}
