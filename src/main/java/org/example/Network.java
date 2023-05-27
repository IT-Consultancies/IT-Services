package org.example;

public class Network extends Service{


    public Network(String serviceName, String subServiceName, int price) {
        super(serviceName, subServiceName, price);
    }

    @Override
    public void requestConfiguration() {
            super.setPrice(super.getPrice() + 500);
    }
    @Override
    public void requestDesign() {
        super.setPrice(super.getPrice() + 300);

    }
    @Override
    public void requestImplementation() {
        super.setPrice(super.getPrice() + 800);
    }

    @Override
    public void requestTroubleshooting() {
        super.setPrice(super.getPrice() + 650);
    }

    @Override
    public void requestConsulting() {
        super.setPrice(super.getPrice() + 150);
    }

    @Override
    public void getService() {
        System.out.println(super.getServiceName()+super.getPrice());
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
