package com.study.student.dao;

import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentList(String likeName);

    List<Clazz> findClassAll();

    String toAdd(Student student);

    Student findStuById(int i);

    String toUpdate(Student student);

    String deleteById(int sid);

    String deleteStuBySids(String sids);
}
