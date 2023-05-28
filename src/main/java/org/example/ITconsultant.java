package org.example;

public class ITconsultant {
    private NotifcationService notifcationService;

    public ITconsultant() {
        this.notifcationService = new NotifcationService();
    }
    public void newItemPromotion(String promotion){
        notifcationService.notifys(promotion);
    }
    public NotifcationService getNotifcationService() {
        return notifcationService;
    }
}
