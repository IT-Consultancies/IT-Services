package org.example;

public class EmailMsgListener {
    private String email;

    public String getEmail() {
        return email;
    }

    public EmailMsgListener(String email) {
        this.email = email;
    }

    public void update(String promotion){
        System.out.println("An Email sent to :"+email+"\n"+promotion+"\n");
    }
}
