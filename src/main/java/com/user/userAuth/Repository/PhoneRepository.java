package com.user.userAuth.Repository;

import com.user.userAuth.Model.Entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    public List<Phone> findAll();

    public Phone findById(int phoneid);



}
