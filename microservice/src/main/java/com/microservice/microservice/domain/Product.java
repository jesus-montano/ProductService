package com.microservice.microservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="products")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "getAll", procedureName="productList"),
        @NamedStoredProcedureQuery(name= "insertProduct", procedureName="InsertProduct", parameters={
                @StoredProcedureParameter(name ="@name",type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name ="@description",type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name ="@price",type =Integer.class, mode = ParameterMode.IN)
        })})
public class Product implements Serializable {


    private int id;
    private String name;
    private String description;
    private Double price;
    public Product(){

    }

    public Product(String name, String description, Double price){

        this.name =name;
        this.description=description;
        this.price=price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "product_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name= "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name= "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id: "+ id +"," +
                "name: "+ name +"," +
                "description: " + description + "," +
                "price: "+ price+
                "}";
    }
}
