package org.example;

public class Server extends Service{
    public Server(String serviceName, String subServiceName, int price) {
        super(serviceName, subServiceName, price);
    }

    @Override
    public void requestConfiguration() {
        super.setPrice(super.getPrice() + 1200);
    }
    @Override
    public void requestDesign() {
        super.setPrice(super.getPrice() + 1000);

    }
    @Override
    public void requestImplementation() {
        super.setPrice(super.getPrice() + 900);
    }

    @Override
    public void requestTroubleshooting() {
        super.setPrice(super.getPrice() + 540);
    }

    @Override
    public void requestConsulting() {
        super.setPrice(super.getPrice() + 250);
    }

    @Override
    public void getService() {
        if(super.getSubServiceName().equalsIgnoreCase("Configuration")){
            requestConfiguration();
        } else if (super.getSubServiceName().equalsIgnoreCase("Design")) {
            requestDesign();
        }else if (super.getSubServiceName().equalsIgnoreCase("Implementation")) {
            requestImplementation();
        }else if (super.getSubServiceName().equalsIgnoreCase("Troubleshooting")) {
            requestTroubleshooting();
        }else if (super.getSubServiceName().equalsIgnoreCase("Consulting")) {
            requestConsulting();
        }else{
            return;
        }
    }


}
