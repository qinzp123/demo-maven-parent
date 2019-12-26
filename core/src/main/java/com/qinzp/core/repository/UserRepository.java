package com.qinzp.core.repository;

import com.qinzp.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//继承JpaRepository来完成对数据库的操作 integer是主键类型
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLastNameAndAge(String lastName, Integer age);
}
