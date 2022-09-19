//package com.digitalbooks.entities;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name="book_category")
//// @Data -- known bug
//@Getter
//@Setter
//public class BookCategory {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "category_name")
//    private String categoryName;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
//    private Set<Book> books;
//    
//}
