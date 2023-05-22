package org.example;

public abstract class  Service {
    private String serviceName;
    private String subServiceName;
    private String price;

    public Service(String serviceName, String subServiceName, String price) {
        this.serviceName = serviceName;
        this.subServiceName = subServiceName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", subServiceName='" + subServiceName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }

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
