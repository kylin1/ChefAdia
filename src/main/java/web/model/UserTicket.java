package web.model;

import java.util.Date;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public class UserTicket {

    private int user_id;

    private int ticket_id;

    private Date bought_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getBought_time() {
        return bought_time;
    }

    public void setBought_time(Date bought_time) {
        this.bought_time = bought_time;
    }
}


