package com.layers.services;

import java.util.Comparator;

import com.layers.model.Student;

public class CompareStudentsByName implements Comparator<Student>{
	
	public int compare(Student s1, Student s2)
    {
        return s1.getName().compareTo(s2.getName());
    }

}
