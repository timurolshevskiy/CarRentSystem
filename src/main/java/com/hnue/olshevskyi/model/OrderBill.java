package com.hnue.olshevskyi.model;


import javax.persistence.*;

@Entity
@Table(name = "order_bill")
public class OrderBill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "car_order", nullable = false)
    private Order order;

    private double price;

    private boolean paid;

    public OrderBill() {

    }

    public OrderBill(long id, String description, Order order, double price, boolean paid) {
        this.id = id;
        this.description = description;
        this.order = order;
        this.price = price;
        this.paid = paid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderBill orderBill = (OrderBill) o;

        return id == orderBill.id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
