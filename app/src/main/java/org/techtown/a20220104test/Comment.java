package org.techtown.a20220104test;

public class Comment {

    String id;
    String reply;
    int time;

    public Comment(String id, String reply, int time) {
        this.id = id;
        this.reply = reply;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
