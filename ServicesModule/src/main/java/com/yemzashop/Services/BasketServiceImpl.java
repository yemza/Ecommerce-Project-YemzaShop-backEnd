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
		return basketEntityDAORepository.save(myBasket);
	}



	@Override
	public List<BasketEntityDAO> getBasketByIdUser(Long idUser) {
		return basketEntityDAORepository.findAllByUserId(idUser);
	}

	
	
	

}
