package com.postgre.sql.dto.mapper;

import com.postgre.sql.dto.purchase.PurchaseRepositoryDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.mongo.UserMongo;
import com.postgre.sql.model.sql.Purchase;
import com.postgre.sql.model.sql.User;

public class DataMapper {

    public static User convertUserMongoToUser(UserMongo userMongo){
        return new User(
                userMongo.getUsername(),
                userMongo.getPassword(),
                userMongo.getEmail()
        );
    }

    public static UserMongo convertUserToUserMongo(User user){
        return new UserMongo(
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }

    public static UserRepositoryDto convertUserToUserRepositoryDto(User user){
        return new UserRepositoryDto(
                String.valueOf(user.getIdUser()),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getDateCreation(),
                user.getDateUpdate()
        );
    }

    public static UserRepositoryDto convertUserMongoToUserRepositoryDto(UserMongo userMongo){
        return new UserRepositoryDto(
                userMongo.getIdUser(),
                userMongo.getUsername(),
                userMongo.getPassword(),
                userMongo.getEmail(),
                userMongo.getDateCreation(),
                userMongo.getDateUpdate()
        );
    }

    public static PurchaseRepositoryDto convertPurchaseToPurchaseRepositoryDto(Purchase purchase){
        return new PurchaseRepositoryDto(
                String.valueOf(purchase.getIdPurchase()),
                String.valueOf(purchase.getIdUser()),
                purchase.getDatePurchase(),
                purchase.getTotalPurchase()
        );
    }

}
