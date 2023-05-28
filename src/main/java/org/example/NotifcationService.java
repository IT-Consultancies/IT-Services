package org.example;
import java.util.ArrayList;
import java.util.List;
public class NotifcationService {

    private List<EmailMsgListener> customers;

    public NotifcationService() {
        this.customers = DatabaseManager.getSubsrcibers();
    }

    public void subscribe(EmailMsgListener listener) {
        DatabaseManager.updateSubsriber(1,listener.getEmail());
        customers.add(listener);
    }

    public void unsubscribe(EmailMsgListener listener) {
        DatabaseManager.updateSubsriber(-1,listener.getEmail());
        customers.remove(listener);
    }

    public void notifys(String promotion) {
        customers.forEach(listner -> listner.update(promotion));
    }

}
