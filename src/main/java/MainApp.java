import jakarta.persistence.EntityManager;
import gerbut.homework.dao.PersonDAO;
import gerbut.homework.dao.RecordBookDAO;
import gerbut.homework.dao.StudentDAO;
import gerbut.homework.entity.Person;
import gerbut.homework.entity.RecordBook;
import gerbut.homework.entity.Student;
import gerbut.homework.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;




public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateSessionFactory.getSessionFactory().createEntityManager();
        PersonDAO personDAO = new PersonDAO(entityManager);
        RecordBookDAO recordBookDAO = new RecordBookDAO(entityManager);
        StudentDAO studentDAO = new StudentDAO(entityManager);

        entityManager.getTransaction().begin();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(55551, 55555, "МММ1", "МММ1", "Андреевич"));
        persons.add(new Person(55552, 55555, "МММ2", "МММ1", "Михайлович"));
        persons.add(new Person(55553, 6666, "МММ3", "МММ1", "Денисович"));
        persons.add(new Person(55554, 55555, "МММ4", "МММ1", "Андреевич"));
        persons.add(new Person(55555, 55555, "МММ5", "МММ1", "Андреева"));
        persons.add(new Person(55556, 55555, "МММ6", "МММ1", "Алексеевич"));
        persons.add(new Person(55557, 55555, "МММ7", "Виктория", "Денисовна"));
        persons.add(new Person(55558, 55555, "МММ81", "Степан", "Михайлович"));
        persons.add(new Person(55559, 55555, "СМММ9", "Андрей", "Мамедович"));
        persons.add(new Person(55550, 55555, "МММ10", "Мухтар", "Михайловна"));

        persons.forEach(personDAO::save);


        List<RecordBook> recordBooks = new ArrayList<>();
        RecordBook recordBook1 = new RecordBook(3);
        recordBooks.add(recordBook1);
        recordBookDAO.save(recordBook1);

        RecordBook recordBook2 = new RecordBook(4);
        recordBooks.add(recordBook2);
        recordBookDAO.save(recordBook2);

        RecordBook recordBook3 = new RecordBook(5);
        recordBooks.add(recordBook3);
        recordBookDAO.save(recordBook3);

        RecordBook recordBook4 = new RecordBook(6);
        recordBooks.add(recordBook4);
        recordBookDAO.save(recordBook4);

        Student student1 = new Student();
        student1.setPerson(persons.get(0));
        student1.setGroup("232322");
        studentDAO.save(student1);

        Student student2 = new Student();
        student2.setPerson(persons.get(2));
        student2.setGroup("232322");
        student2.setRecordBook(recordBooks.get(0));
        studentDAO.save(student2);

        Student student3 = new Student();
        student3.setPerson(persons.get(3));
        student3.setGroup("232321");
        student3.setRecordBook(recordBooks.get(1));
        studentDAO.save(student3);

        Student student4 = new Student();
        student4.setPerson(persons.get(3));
        student4.setGroup("232327");
        student4.setRecordBook(recordBooks.get(2));
        studentDAO.save(student4);

        Student student5 = new Student();
        student5.setPerson(persons.get(3));
        student5.setGroup("232324");
        student5.setRecordBook(recordBooks.get(3));
        studentDAO.save(student5);

        Student student6 = new Student();
        student6.setPerson(persons.get(4));
        student6.setGroup("232321");
        studentDAO.save(student6);

        Student student7 = new Student();
        student5.setPerson(persons.get(7));
        student5.setGroup("232321");
        studentDAO.save(student7);

        Student student8 = new Student();
        student5.setPerson(persons.get(9));
        student5.setGroup("232321");
        studentDAO.save(student8);

        Student student9 = new Student();
        student5.setPerson(persons.get(3));
        student5.setGroup("232321");
        studentDAO.save(student9);

        Student student10 = new Student();
        student5.setPerson(persons.get(4));
        student5.setGroup("232323");
        studentDAO.save(student10);

        entityManager.getTransaction().commit();


        System.out.println("------------5.4 HQL------------");
        studentDAO.findByFioLikeWithHQL("%а%").forEach(System.out::println);
        System.out.println("------------5.4 Criteria------------");
        studentDAO.findByFioLikeWithCriteria("%а%").forEach(System.out::println);

        System.out.println("------------5.5 HQL------------");
        studentDAO.findByRecordBookNotNullWithHQL().forEach(System.out::println);
        System.out.println("------------5.5 Criteria------------");
        studentDAO.findByRecordBookNotNullWithCriteria().forEach(System.out::println);

        entityManager.close();
    }
}
