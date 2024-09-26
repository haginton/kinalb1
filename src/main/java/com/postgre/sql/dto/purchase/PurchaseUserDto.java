package com.postgre.sql.dto.purchase;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PurchaseUserDto implements Serializable {

    private static final long serialVersionUID= 1L;

    private String idPurchase;
    private LocalDateTime datePurchase;
    private Double totalPurchase;
    private String idUser;
    private String username;

    public PurchaseUserDto(String idPurchase, LocalDateTime datePurchase, Double totalPurchase, String idUser, String username) {
        this.idPurchase = idPurchase;
        this.datePurchase = datePurchase;
        this.totalPurchase = totalPurchase;
        this.idUser = idUser;
        this.username = username;
    }



    public String getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(String idPurchase) {
        this.idPurchase = idPurchase;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PurchaseUserDto{" +
                "idPurchase=" + idPurchase +
                ", datePurchase=" + datePurchase +
                ", totalPurchase=" + totalPurchase +
                ", idUser=" + idUser +
                ", username='" + username + '\'' +
                '}';
    }
}
