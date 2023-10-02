package ru.softmedialab.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.softmedialab.testtask.model.Student;

@Repository
public interface StudentListRepository extends JpaRepository<Student, Integer> {
}
