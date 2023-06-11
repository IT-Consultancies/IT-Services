package org.example;

public class Security extends Service{
    public Security(String serviceName, String subServiceName, int price) {
        super(serviceName, subServiceName, price);
    }

    @Override
    public void requestConfiguration() {
        super.setPrice(super.getPrice() + 400);
    }
    @Override
    public void requestDesign() {
        super.setPrice(super.getPrice() + 550);

    }
    @Override
    public void requestImplementation() {
        super.setPrice(super.getPrice() + 750);
    }

    @Override
    public void requestTroubleshooting() {
        super.setPrice(super.getPrice() + 1800);
    }

    @Override
    public void requestConsulting() {
        super.setPrice(super.getPrice() + 600);
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
