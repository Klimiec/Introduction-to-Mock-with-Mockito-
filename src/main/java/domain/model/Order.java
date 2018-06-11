package domain.model;

public class Order {

    private OrderItem orderItem;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
