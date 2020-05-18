package rbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseCrudRepository extends CrudRepository<Course, Long> {
    Course findByDate(String dateString);
    Optional<Course> findById(int id);

}
