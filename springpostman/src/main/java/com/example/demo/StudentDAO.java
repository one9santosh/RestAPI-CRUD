package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	@Autowired
	StudentRepository repo;

	// insert a single object
	public Student insert(Student s) {
		return repo.save(s);
	}

	public List<Student> insertall(List<Student> s) {
		return repo.saveAll(s);
	}

	// delete
	public String deleteByid(int id) {
		repo.deleteById(id);
		return "deleted the id value:" + id;
	}

	public Student update(Student s) {
		Student ss = repo.findById(s.getSid()).orElse(null);

		ss.setName(s.getName());
		return repo.save(ss);
	}

	public List<Student> getall() {
		return repo.findAll();
	}
	// public List<Student> getByName(String name) {
	// return repo.findByName(name);
	// }

}
