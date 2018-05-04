package com.terms.domen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MailInfo {

    private final String body;
    private final String address;
    private final String protocol;
    private final String port;
    private final String subject;
    private final String from;
    private final String confirm;
    private final String reset;
    private String to;
    private String message;

    @Autowired
    public MailInfo(Environment environment){
        this.body = environment.getProperty("mail.body");
        this.address = environment.getProperty("server.path");
        this.protocol = environment.getProperty("server.protocol");
        this.port = environment.getProperty("server.port");
        this.subject = environment.getProperty("mail.registration.subject");
        this.from = environment.getProperty("mail.from");
        this.confirm = environment.getProperty("mail.confirmUser.path");
        this.reset = environment.getProperty("mail.resetPass.path");
    }


    public String getBody() {
        return body;
    }

    public String getAddress() {
        return address;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPort() {
        return port;
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getReset() {
        return reset;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
