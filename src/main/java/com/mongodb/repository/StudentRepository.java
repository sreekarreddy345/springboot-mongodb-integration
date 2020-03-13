package com.mongodb.repository;

import com.mongodb.model.students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<students, String> {
    students findByFirstName(String firstName);
}
