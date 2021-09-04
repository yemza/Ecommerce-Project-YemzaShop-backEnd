package com.yemzashop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.ClientEntityDAO;

public interface ClientEntityDAORepository extends JpaRepository<ClientEntityDAO, Long> {

}
