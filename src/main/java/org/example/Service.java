package org.example;

public abstract class  Service {
    private String serviceName;
    private String subServiceName;
    private int price;
    private int id;

    public Service(int id ,String serviceName, String subServiceName, int price) {
        this.serviceName = serviceName;
        this.subServiceName = subServiceName;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", subServiceName='" + subServiceName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }



    public abstract void requestConfiguration();
    public abstract void requestDesign();
    public abstract void requestImplementation();
    public abstract void requestTroubleshooting();
    public abstract void requestConsulting();
    public abstract void getService();



    public String getServiceName() {
        return serviceName;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }


}
