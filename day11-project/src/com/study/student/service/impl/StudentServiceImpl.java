package com.study.student.service.impl;


import com.study.student.dao.StudentDao;
import com.study.student.dao.impl.StudentDaoImpl;
import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;
import com.study.student.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //聚合持久层的引用
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> getStudentList(String likeName) {

        return studentDao.getStudentList(likeName);
    }

    @Override
    public List<Clazz> findClassAll() {

        return studentDao.findClassAll();
    }

    @Override
    public String toAdd(Student student) {

        return studentDao.toAdd(student);
    }

    @Override
    public Student findStuById(int i) {
        return studentDao.findStuById(i);
    }

    @Override
    public String toUpdate(Student student) {
        return studentDao.toUpdate(student);
    }

    @Override
    public String deleteById(int sid) {
        return studentDao.deleteById(sid);
    }

    @Override
    public String deleteStuBySids(String sids) {
        return studentDao.deleteStuBySids(sids);
    }


}
