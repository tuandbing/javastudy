package com.study.student.service;

import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Clazz> findClassAll();

    List<Student> getStudentList(String likeName);

    String toAdd(Student student);

    Student findStuById(int i);

    String toUpdate(Student student);

    String deleteById(int sid);

    String deleteStuBySids(String sids);
}
