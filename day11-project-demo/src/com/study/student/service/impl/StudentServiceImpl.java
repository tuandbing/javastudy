package com.study.student.service.impl;


import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;
import com.study.student.service.StudentService;
import com.study.student.test.*;

import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private MyTest myTest = new MyTest();

    public StudentServiceImpl() throws IOException {
    }

    @Override
    public List<Student> getStudentList(String likeName) {

        return myTest.findStudent(likeName);
    }

    @Override
    public List<Clazz> findClassAll() {

        return myTest.findClassAll();
    }

    @Override
    public String toAdd(Student student) {
        return myTest.toAddStudent(student);
    }

    @Override
    public Student findStuById(int i) {
        return myTest.findStuById(i);
    }

    @Override
    public String toUpdate(Student student) {
        return myTest.UpdateStudent(student);
    }

    @Override
    public String deleteById(int sid) {
        return myTest.deleteById(sid);
    }

    @Override
    public String deleteStuBySids(String sids) {
        return myTest.deleteStuBySids(Integer.parseInt(sids));
    }
}
