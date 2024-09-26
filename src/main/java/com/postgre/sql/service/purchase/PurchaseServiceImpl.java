package com.postgre.sql.service.purchase;

import com.postgre.sql.dto.mapper.DataMapper;
import com.postgre.sql.dto.purchase.PurchaseRepositoryDto;
import com.postgre.sql.dto.purchase.PurchaseUserDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.Purchase;
import com.postgre.sql.model.sql.User;
import com.postgre.sql.repository.UserRepository;
import com.postgre.sql.repository.postgresql.purchase.PurchaseRepositoryJpa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepositoryJpa purchaseRepositoryJpa;
    private final UserRepository userRepository;

    public PurchaseServiceImpl(PurchaseRepositoryJpa purchaseRepositoryJpa, @Qualifier("userRepositoryImpl") UserRepository userRepository) {
        this.purchaseRepositoryJpa = purchaseRepositoryJpa;
        this.userRepository = userRepository;
    }

    @Override
    public PurchaseUserDto doPurchase(String idUser, Double totalPurchase) {

        UserRepositoryDto userFound = userRepository.findUserById(idUser);
        if (userFound != null){
            Purchase purchase = new Purchase(Long.parseLong(idUser), totalPurchase);
            PurchaseRepositoryDto purchaseRealized = DataMapper.convertPurchaseToPurchaseRepositoryDto(purchaseRepositoryJpa.save(purchase));
            return new PurchaseUserDto(
                    purchaseRealized.getIdPurchase(),
                    purchaseRealized.getDatePurchase(),
                    purchaseRealized.getTotalPurchase(),
                    userFound.getIdUser(),
                    userFound.getUsername()
            );
        }

        return null;
    }
}
