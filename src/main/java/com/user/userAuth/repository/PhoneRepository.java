package com.user.userAuth.repository;

import com.user.userAuth.model.entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    List<Phone> findAll();

    Phone findById(int phoneid);


}
