package org.example;

public class ServiceFactory {

    public Service getService(int x){
        if(x == 1){
            return  new Network(0,"Network","",500);
        } else if (x == 2) {
            return new Cloud(1,"Cloud","",1000);
        }else if (x == 5) {
            return new Security(4,"Security","",1500);
        }else if (x == 3) {
            return new Database(2,"Database","",1300);
        }else if (x == 4) {
            return new Server(4,"Server","",700);
        }else{
            return  null;
        }
    }
}
