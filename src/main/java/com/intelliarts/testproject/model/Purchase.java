package com.intelliarts.testproject.model;

import java.time.LocalDate;

public class Purchase {
    private Product product;
    private LocalDate date;

    public Purchase(Product product, LocalDate date) {
        this.product = product;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
