package com.jikelab.repository;

import com.jikelab.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void insertData() {
        Student student = new Student();
        student.setAddress("beijing");
        student.setAge(11);
        student.setName("小明");
        student.setSchool("北理工");

        studentRepository.save(student);
    }

    @Test
    public void testBaseRepository() {

        //直接使用BaseRepository中的方法
        List<Object[]> list = studentRepository.listBySQL("select address,count(*) from student group by address");
        System.out.println(list.toString());
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("beijing",list.get(0)[0]);


        //原JpaRepository的方法依然可以使用
        List<Student> list2 = studentRepository.findByNameAndAddress("小明","beijing");
        Assert.assertEquals(1,list2.size());

    }

}
