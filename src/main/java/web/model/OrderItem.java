package web.model;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public class OrderItem {

    private int order_id;

    private int food_id;

    private int food_num;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_num() {
        return food_num;
    }

    public void setFood_num(int food_num) {
        this.food_num = food_num;
    }
}
