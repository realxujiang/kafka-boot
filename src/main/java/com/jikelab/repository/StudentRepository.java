package com.jikelab.repository;

import com.jikelab.entity.Student;
import com.jikelab.repository.base.BaseRepository;

import java.util.List;

/**
 * @author whoami
 */
public interface StudentRepository extends BaseRepository<Student,Integer> {
    /**
     * 原来JPARepository的方法依然可以使用
     * */
    List<Student> findByNameAndAddress(String name, String address);
}