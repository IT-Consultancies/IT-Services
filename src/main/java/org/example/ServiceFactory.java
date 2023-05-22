package org.example;

public class ServiceFactory {

    public Service getService(int x){
        if(x == 1){
            return  new Network("Network","","600");
        } else if (x == 2) {
            return new Cloud("Cloud","","1200");
        }else if (x == 3) {
            return new Security("Security","","1600");
        }else if (x == 4) {
            return new Database("Database","","1800");
        }else if (x == 5) {
            return new Server("Server","","500");
        }else{
            return  null;
        }
    }
}
