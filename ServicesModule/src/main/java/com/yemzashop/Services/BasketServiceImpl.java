package com.yemzashop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemzashop.Entities.BasketEntityDAO;
import com.yemzashop.Repository.BasketEntityDAORepository;

@Service
public class BasketServiceImpl  implements BasketService {

	@Autowired 
	BasketEntityDAORepository basketEntityDAORepository;
	
	
	
	@Override
	public List<BasketEntityDAO> getAllClientBasket() {
		return basketEntityDAORepository.findAll();
	}



	@Override
	public BasketEntityDAO addBasket(BasketEntityDAO myBasket) {
	List<BasketEntityDAO> myBasketList = basketEntityDAORepository.findAllByUserId(myBasket.getUser().getId());
	
		for (BasketEntityDAO basket: myBasketList) {
			if(basket.getProduct().getId().equals(myBasket.getProduct().getId())) {
				basket.setQuantity(basket.getQuantity() + myBasket.getQuantity());
				return basketEntityDAORepository.save(basket);
			}
		}
		
		 return basketEntityDAORepository.save(myBasket);
	}



	@Override
	public List<BasketEntityDAO> getBasketByIdUser(Long idUser) {
		return basketEntityDAORepository.findAllByUserId(idUser);
	}


	
	//Delete product from list of User Basket
	@Override
	public void deleteProductFromBasketById(Long idBaskest) {
		 basketEntityDAORepository.deleteById(idBaskest);
	}



	@Override
	public int getListBasketLenght(Long idUser) {
		return basketEntityDAORepository.findAllByUserId(idUser).size();
	}

	
	
	

}
