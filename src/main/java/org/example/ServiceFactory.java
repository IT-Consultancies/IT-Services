package org.example;

public class ServiceFactory {

    public Service getService(int x){
        if(x == 1){
            return  new Network("Network","",500);
        } else if (x == 2) {
            return new Cloud("Cloud","",1000);
        }else if (x == 3) {
            return new Security("Security","",1500);
        }else if (x == 4) {
            return new Database("Database","",1300);
        }else if (x == 5) {
            return new Server("Server","",700);
        }else{
            return  null;
        }
    }
}
