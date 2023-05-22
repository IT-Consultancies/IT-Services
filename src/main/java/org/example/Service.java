package org.example;

public abstract class  Service {
    private String serviceName;
    private String subServiceName;
    private String price;

    public abstract void requestConfiguration();
    public abstract void requestDesign();

    public abstract void requestImplementation();
    public abstract void requestTroubleshooting();


    public String getServiceName() {
        return serviceName;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public String getPrice() {
        return price;
    }

    public abstract void requestConsulting();
}
