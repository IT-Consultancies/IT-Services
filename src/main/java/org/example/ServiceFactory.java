package org.example;

public class ServiceFactory {

    public Service getService(String service){
        if(service.equalsIgnoreCase("Network")){
            return  new Network("Network","",500);
        } else if (service.equalsIgnoreCase("Cloud")) {
            return new Cloud("Cloud","",1000);
        }else if (service.equalsIgnoreCase("Security")) {
            return new Security("Security","",1500);
        }else if (service.equalsIgnoreCase("Database")) {
            return new Database("Database","",1300);
        }else if (service.equalsIgnoreCase("Server")) {
            return new Server("Server","",700);
        }else{
            return  null;
        }
    }
}
