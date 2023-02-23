package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestBatch {
		public static void main(String[] args) {
			StudentDao studentDao=new StudentDao();
			ArrayList<Student> al=new ArrayList<Student>();
			
			Student student=new Student();
			student.setId(114);
			student.setName("Anshil");
			student.setEmail("anshil@email.com");
			
			Student student1=new Student();
			student1.setId(115);
			student1.setName("Vikash");
			student1.setEmail("vikash@email.com");
			
			
			Student student2=new Student();
			student2.setId(116);
			student2.setName("Vicky");
			student2.setEmail("vicky@email.com");
					
			al.add(student);
			al.add(student1);
			al.add(student2);
			studentDao.addMultipleStudents(al);		
	}
}
