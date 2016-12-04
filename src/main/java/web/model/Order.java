package web.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public class Order {

    private Date create_time;

    private int user_id;

    private BigDecimal price;

    private int ticket_info;

    private int bowl_info;

    private int pay_type;

    public int getTicket_info() {
        return ticket_info;
    }

    public void setTicket_info(int ticket_info) {
        this.ticket_info = ticket_info;
    }

    public int getBowl_info() {
        return bowl_info;
    }

    public void setBowl_info(int bowl_info) {
        this.bowl_info = bowl_info;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
