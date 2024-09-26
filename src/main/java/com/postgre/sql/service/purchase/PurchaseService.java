package com.postgre.sql.service.purchase;

import com.postgre.sql.dto.purchase.PurchaseUserDto;

public interface PurchaseService {

    PurchaseUserDto doPurchase(String idUser, Double totalPurchase);
}
