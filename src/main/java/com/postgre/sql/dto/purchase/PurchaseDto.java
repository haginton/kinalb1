package com.postgre.sql.dto.purchase;

import java.io.Serializable;

public class PurchaseDto implements Serializable {

    private static final long serialVersionUID= 1L;

    private String idUser;
    private Double totalPurchase;

    public PurchaseDto(String idUser, Double totalPurchase) {
        this.idUser = idUser;
        this.totalPurchase = totalPurchase;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "idUser=" + idUser +
                ", totalPurchase=" + totalPurchase +
                '}';
    }
}
