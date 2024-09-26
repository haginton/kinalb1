package com.postgre.sql.controller.purchase;

import com.postgre.sql.dto.purchase.PurchaseDto;
import com.postgre.sql.dto.purchase.PurchaseUserDto;
import com.postgre.sql.service.purchase.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseUserDto> doPurchase(@RequestBody PurchaseDto purchaseDto){
        return new ResponseEntity<>(purchaseService.doPurchase(purchaseDto.getIdUser(), purchaseDto.getTotalPurchase()), HttpStatus.OK);
    }
}
