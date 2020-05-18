package weather.DAO;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="Course")
public class Course {

    private final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double course;
    private String date;

    public Course() {}

    public Course(Double rate, Date date) {
        this.course = course;
        this.date = simpleDateFormat.format(date);
    }

    public Double getCourse() {
        return course;
    }
}