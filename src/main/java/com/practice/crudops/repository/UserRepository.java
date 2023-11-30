package com.practice.crudops.repository;

import com.practice.crudops.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

//Crud repository is pre-defined interface which has methods to create, update, insert, delete tables.
/*CrudRepository<User, Integer>  - This interface accepts two Generics User and Integer, Therefore
it creates User table and whose primary key is of Integer type
 */
