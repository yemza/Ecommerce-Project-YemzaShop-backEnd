package com.yemzashop.Services;

import java.util.List;

import com.yemzashop.Entities.BasketEntityDAO;

public interface BasketService {

	List<BasketEntityDAO> getAllClientBasket();

	BasketEntityDAO addBasket(BasketEntityDAO myBasket);

	List<BasketEntityDAO> getBasketByIdUser(Long idUser);


}
