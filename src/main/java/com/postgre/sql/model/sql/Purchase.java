package com.postgre.sql.model.sql;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Long idPurchase;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "date_purchase")
    private LocalDateTime datePurchase;
    @Column(name = "total_purchase")
    private Double totalPurchase;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    public Purchase() {
    }

    public Purchase(Long idUser, Double totalPurchase) {
        this.idUser = idUser;
        this.datePurchase = LocalDateTime.now();
        this.totalPurchase = totalPurchase;
    }

    public Long getIdPurchase() {
        return idPurchase;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;
        return Objects.equals(idPurchase, purchase.idPurchase) && Objects.equals(idUser, purchase.idUser) && Objects.equals(datePurchase, purchase.datePurchase) && Objects.equals(totalPurchase, purchase.totalPurchase);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(idPurchase);
        result = 31 * result + Objects.hashCode(idUser);
        result = 31 * result + Objects.hashCode(datePurchase);
        result = 31 * result + Objects.hashCode(totalPurchase);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "idPurchase=" + idPurchase +
                ", idUser=" + idUser +
                ", datePurchase=" + datePurchase +
                ", totalPurchase=" + totalPurchase +
                '}';
    }
}
