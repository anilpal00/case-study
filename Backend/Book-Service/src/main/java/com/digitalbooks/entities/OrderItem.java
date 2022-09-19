//package com.digitalbooks.entities;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name="order_item")
//@Data
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//
//    @Column(name="image_url")
//    private String imageUrl;
//
//    @Column(name="unit_price")
//    private BigDecimal unitPrice;
//
//    @Column(name="quantity")
//    private int quantity;
//
//    @Column(name="product_id")
//    private Long productId;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//}