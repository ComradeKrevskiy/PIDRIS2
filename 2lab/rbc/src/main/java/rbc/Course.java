package rbc;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Entity
@Table(name="course")
public class Course {

    private final DateFormat simpleDateFormat = new SimpleDateFormat("EEE MM dd kk:mm:ss zzzz yyyy", Locale.ENGLISH);

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Double course;
    private String date;

    public Course() {}

    public Course(Double course, Date date) {
        this.course = course;
        this.date = simpleDateFormat.format(date);
    }

    public Double getCourse() {
        return course;
    }
}