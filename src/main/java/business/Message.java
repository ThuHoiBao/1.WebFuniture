package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Message implements Serializable {

    @Id
    private String messID;
    private String content;
    private LocalDateTime sentTime;

    @ManyToOne
    @JoinColumn(name = "sender_id") 
    private Customer sender;

    public Message() {
    }

    public Message(String messID, String content, LocalDateTime sentTime, Customer sender) {
        this.messID = messID;
        this.content = content;
        this.sentTime = sentTime;
        this.sender = sender;
    }

    public String getMessID() {
        return messID;
    }

    public void setMessID(String messID) {
        this.messID = messID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }
}