orm mapping

Many employees to one department

manytomany

CREATE TABLE student (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE course (
    id BIGINT PRIMARY KEY,
    title VARCHAR(100)
);

CREATE TABLE enrollment (
    id BIGINT PRIMARY KEY,
    student_id BIGINT,
    course_id BIGINT,
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);

jpa

@Entity
public class Student {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();
}


@Entity
public class Course {

    @Id
    private Long id;

    private String title;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();
}


@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}


How to know, which entity have which annotation

Ask Where is the FOREIGN KEY?
There use @ManyToOne

Employee -> @ManyToOne (FK present here)
Department -> @OneToMany

also under ManyToOne add
@JoinColumn(name = "department_id")




Composite key

@Embeddable
public class EnrollmentId implements Serializable {

    private Long studentId;
    private Long courseId;

    // equals() and hashCode() REQUIRED
}


@Entity
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
