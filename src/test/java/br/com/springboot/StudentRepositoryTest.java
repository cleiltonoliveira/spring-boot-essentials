package br.com.springboot;

import br.com.springboot.model.Student;
import br.com.springboot.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void createShouldPersistData() {
        Student student = new Student("Santo Agostinho", "emaildoagostinho@gmail.com");
        studentRepository.save(student);
        Assertions.assertThat(student.getId()).isNotNull();
        Assertions.assertThat(student.getName()).isEqualTo("Santo Agostinho");
        Assertions.assertThat(student.getEmail()).isEqualTo("emaildoagostinho@gmail.com");
    }

    @Test
    public void deleteShouldRemoveData() {
        Student student = new Student("Santo Agostinho", "emaildoagostinho@gmail.com");
        studentRepository.save(student);
        studentRepository.delete(student);
        Assertions.assertThat(studentRepository.findById(student.getId())).isEmpty();
    }

    @Test
    public void UpdateShouldChangeAndPersistData() {
        Student student = new Student("Santo Agostinho", "emaildoagostinho@gmail.com");

        this.studentRepository.save(student);

        student.setName("Santo Agostinho 2");
        student.setEmail("emaildoagostinho2@gmail.com");

        student = this.studentRepository.save(student);

        Assertions.assertThat(student.getName()).isEqualTo("Santo Agostinho 2");
        Assertions.assertThat(student.getEmail()).isEqualTo("emaildoagostinho2@gmail.com");
    }

    @Test
    public void findByNameIgnoreCaseContainingShoulIgnoreCase() {
        Student student = new Student("Santo Agostinho", "emaildoagostinho@gmail.com");
        Student student2 = new Student("santo agostinho", "emaildoagostinho2@gmail.com");

        studentRepository.save(student);
        studentRepository.save(student2);

        List<Student> students = this.studentRepository.findByNameIgnoreCaseContaining("santo agostinho");

        student.setName("Santo Agostinho 2");
        student.setEmail("emaildoagostinho2@gmail.com");

        student = this.studentRepository.save(student);

        Assertions.assertThat(students.size()).isEqualTo(2);
    }

    @Test
    public void createWhenNameIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("O campo nome do estudante é obrigatório");

        this.studentRepository.save(new Student());

        entityManager.flush();
    }

    @Test
    public void createWhenEmailIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        Student student = new Student();
        student.setName("Cleilton");
        this.studentRepository.save(student);

        entityManager.flush();
    }

    @Test
    public void createWhenEmailIsNotValidShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Digite um email válido");

        Student student = new Student();
        student.setName("Cleilton");
        student.setEmail("Cleilton");

        this.studentRepository.save(student);

        entityManager.flush();
    }
}
