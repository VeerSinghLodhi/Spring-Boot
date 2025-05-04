package com.sagarmp.sagar.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserMaster,Integer> {
    public List<UserMaster>getByUsername(String username);
}
