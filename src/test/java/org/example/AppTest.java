package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AppTest {



    @Test
    public void cloudGetService1(){
        Service service = new Cloud(0,"Cloud","Configuration",1000);
        service.getService();
        assertEquals(2300,service.getPrice());
    }
    @Test
    public void cloudGetService2(){
        Service service = new Cloud(0,"Cloud","Design",1000);
        service.getService();
        assertEquals(2600,service.getPrice());
    }
    @Test
    public void cloudGetService3(){
        Service service = new Cloud(0,"Cloud","Implementation",1000);
        service.getService();
        assertEquals(3500,service.getPrice());
    }

    @Test
    public void cloudGetService4(){
        Service service = new Cloud(0,"Cloud","Troubleshooting",1000);
        service.getService();
        assertEquals(2450,service.getPrice());
    }

    @Test
    public void cloudGetService5(){
        Service service = new Cloud(0,"Database","Consulting",1000);
        service.getService();
        assertEquals(1900,service.getPrice());
    }

    @Test
    public void databaseGetService1(){
        Service service = new Database(0,"Database","Configuration",0);
        service.getService();
        assertEquals(600,service.getPrice());
    }
    @Test
    public void databaseGetService2(){
        Service service = new Database(0,"Database","Design",0);
        service.getService();
        assertEquals(1150,service.getPrice());
    }
    @Test
    public void databaseGetService3(){
        Service service = new Database(0,"Database","Implementation",0);
        service.getService();
        assertEquals(1300,service.getPrice());
    }

    @Test
    public void databaseGetService4(){
        Service service = new Database(0,"Database","Troubleshooting",0);
        service.getService();
        assertEquals(600,service.getPrice());
    }

    @Test
    public void databaseGetService5(){
        Service service = new Database(0,"Database","Consulting",0);
        service.getService();
        assertEquals(400,service.getPrice());
    }

    @Test
    public void networkGetService1(){
        Service service = new Network(0,"Network","Configuration",0);
        service.getService();
        assertEquals(500,service.getPrice());
    }
    @Test
    public void networkGetService2(){
        Service service = new Network(0,"Network","Design",0);
        service.getService();
        assertEquals(300,service.getPrice());
    }
    @Test
    public void networkGetService3(){
        Service service = new Network(0,"Network","Implementation",0);
        service.getService();
        assertEquals(800,service.getPrice());
    }

    @Test
    public void networkGetService4(){
        Service service = new Network(0,"Network","Troubleshooting",0);
        service.getService();
        assertEquals(650,service.getPrice());
    }

    @Test
    public void networkGetService5(){
        Service service = new Network(0,"Network","Consulting",0);
        service.getService();
        assertEquals(150,service.getPrice());
    }

    @Test
    public void securityGetService1(){
        Service service = new Security(0,"Security","Configuration",0);
        service.getService();
        assertEquals(400,service.getPrice());
    }
    @Test
    public void securityGetService2(){
        Service service = new Security(0,"Security","Design",0);
        service.getService();
        assertEquals(550,service.getPrice());
    }
    @Test
    public void securityGetService3(){
        Service service = new Security(0,"Security","Implementation",0);
        service.getService();
        assertEquals(750,service.getPrice());
    }

    @Test
    public void securityGetService4(){
        Service service = new Security(0,"Security","Troubleshooting",0);
        service.getService();
        assertEquals(1800,service.getPrice());
    }

    @Test
    public void securityGetService5(){
        Service service = new Security(0,"Security","Consulting",0);
        service.getService();
        assertEquals(600,service.getPrice());
    }

    @Test
    public void serverGetService1(){
        Service service = new Server(0,"Server","Configuration",0);
        service.getService();
        assertEquals(1200,service.getPrice());
    }
    @Test
    public void serverGetService2(){
        Service service = new Server(0,"Server","Design",0);
        service.getService();
        assertEquals(1000,service.getPrice());
    }
    @Test
    public void serverGetService3(){
        Service service = new Server(0,"Server","Implementation",0);
        service.getService();
        assertEquals(900,service.getPrice());
    }

    @Test
    public void serverGetService4(){
        Service service = new Server(0,"Server","Troubleshooting",0);
        service.getService();
        assertEquals(540,service.getPrice());
    }

    @Test
    public void serverGetService5(){
        Service service = new Server(0,"Server","Consulting",0);
        service.getService();
        assertEquals(250,service.getPrice());
    }

    @Test
    public void testPerson(){
       Person p1 = new Customer("Malek","55","d",1,0);
       p1.getId();
       p1.getMajor();
       p1.getName();
       p1.getArrayList();
       p1.getArrayList();
       p1.viewOrder();
       p1.setMajor("Network");
       p1.toString();
       ((Customer) p1).getEmailAddress();
       ((Customer) p1).getSubscribed();
       ((Customer) p1).setSubscribed(1);
       ((Customer) p1).setEmailAddress("ff");
        Service service = new Server(0,"Server","Troubleshooting",0);

        ((Customer) p1).putOrder(new Order(1,"a","a", service));

        p1 = new Employee("m","05",1,"Network");

        p1.toString();
        p1.toString();
        p1.dropOrder(0);
        p1.putOrder(new Order(1,"a","a", service));
        service.getId();
        service.getSubServiceName();
        service.getServiceName();
        service.setServiceName("ff");
        new Order(1,"a","a", service).getId();

        ServiceFactory sf  = new ServiceFactory();
        Service s = sf.getService(2);
        s = sf.getService(3);
        s = sf.getService(4);
        s = sf.getService(5);
        s = sf.getService(52);

    }



}

