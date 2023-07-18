package com.user.userAuth.Repository;

import com.user.userAuth.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /** Finds user by email
     *
     * @param email
     * @return User
     */
    public User findByEmail(String email);

}
