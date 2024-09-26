package com.postgre.sql.dto.purchase;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PurchaseRepositoryDto implements Serializable {

    private static final long serialVersionUID= 1L;

    private String idPurchase;

    private String idUser;

    private LocalDateTime datePurchase;

    private Double totalPurchase;

    public PurchaseRepositoryDto(String idPurchase, String idUser, LocalDateTime datePurchase, Double totalPurchase) {
        this.idPurchase = idPurchase;
        this.idUser = idUser;
        this.datePurchase = datePurchase;
        this.totalPurchase = totalPurchase;
    }


    public String getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(String idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}
