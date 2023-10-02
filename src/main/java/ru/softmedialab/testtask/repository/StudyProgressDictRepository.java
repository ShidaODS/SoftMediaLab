package ru.softmedialab.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.softmedialab.testtask.model.StudyProgressDict;

import java.util.Optional;

@Repository
public interface StudyProgressDictRepository extends JpaRepository<StudyProgressDict, Integer> {
    Optional<StudyProgressDict> findStudyProgressDictByProgressTextLikeIgnoreCase(String text);
}
