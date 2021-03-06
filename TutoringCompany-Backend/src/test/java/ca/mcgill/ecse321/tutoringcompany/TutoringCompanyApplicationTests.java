//package ca.mcgill.ecse321.tutoringcompany;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
////import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
//import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
//import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
//import ca.mcgill.ecse321.tutoringcompany.dao.*;
//import ca.mcgill.ecse321.tutoringcompany.model.Course;
//import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Subject;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
//import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
//import ca.mcgill.ecse321.tutoringcompany.service.*;
////import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyOfferingService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorReviewsService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;
///**
// * 
// * @author Elias Tamraz
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TutoringCompanyApplicationTests {
///**
// * @Autowiring services
// */
//	@Autowired
//	private TutoringCompanyTutorService TutorService;
//	@Autowired
//	private TutoringCompanyStudentService StudentService;
//	@Autowired
//	private TutoringCompanyManagerService ManagerService;
////	@Autowired
////	private TutoringCompanyRoomService RoomService;
//	@Autowired
//
//	private TutoringCompanyCourseService CourseService;
//	
//	@Autowired
//	private TutoringCompanyOfferingService OfferingService;
//	@Autowired
//	private TutoringCompanyTutorReviewsService TutorReviewsService;
///**
// * @Autowiring repos
// */
//	@Autowired
//	private StudentRepository studentRepository;
//	@Autowired
//	private TutorRepository tutorRepository;
//	@Autowired
//	private OfferingRepository offeringRepository;
//	
//	@Autowired
//	private CourseRepository courseRepository;
//	@Autowired
//	private TutorReviewsRepository tutorReviewsRepository;
//	@Autowired
//	private SessionRepository sessionRepository;
////	@Autowired
////	private ManagerRepository managerRepository;
////	@Autowired
////	private RoomRepository roomRepository;
//	
////@After
////	public void clearDatabase() {
////		// Fisrt, we clear registrations to avoid exceptions due to inconsistencies
////		studentRepository.deleteAll();
////		
////		}
////	@Test
////	public void deleteAll() {
////		sessionRepository.deleteAll();
////	}
////	@Test
////	public void testCreateStudent() {
////	studentRepository.deleteAll();
////	assertEquals(0, StudentService.getAllStudents().size());
////	String name = "elias";
////	try {
////		StudentService.createStudent(name,"k", "eliasi@gmail.com", "oj", "ijm");
////	} catch (IllegalArgumentException e) {
////	// Check that no error occurred
////	fail();
////	}
////	List<Student> allStudents = StudentService.getAllStudents();
////	assertEquals(1, allStudents.size());
////  assertEquals(name, allStudents.get(0).getFirst_name());
////	}
//	
////@Test
////public void testDeleteStudent() {
////StudentService.deleteStudent("samra@gmail.com");
////}
//
////	@Test
////	public void updateStudent() {
////		StudentService.updateStudent("eliasi@gmail.com", "eliasso", "samo", "450", "thepass");
////	}
////	
////	@Test
////	public void testCreateTutor() {
////		TutorService.createTutor("John", "smith", "john@gmail.com", "450878", "123");
////	}
////	
////
////	@Test
////	public void testCreatManager(){
////		ManagerService.createManager("george", "kandalaft", "george@gmail.com", "4389883384", "123456");
////	}
////	@Test
////	public void testCreatStudent(){
////		StudentService.createStudent("george", "kandalaft", "ELias@gmail.com", "4389883384", "123456");
////	}
////	
////@Test
////public void testCreatRoom() {
////	RoomService.createRoom(156, RoomType.INDIVIDUAL_ROOM);
////}
//
////@Test
////public void testCreateOffering() {
////	Tutor tutor = new Tutor();
////	tutor.setEmail("George.kandalaft@gmail");
////	tutor.setFirst_name("George");
////	tutor.setLast_name("Kandlaft");
////	tutor.setPassword("george");
////	tutor.setPhone_number("5146993256");
////	tutorRepository.save(tutor);
////	
////	Course course = new Course();
////	course.setName("Math");
////	course.setCourse_id("41");
////	courseRepository.save(course);
////	
////	OfferingService.createOffering(14,20,course,tutor);
////}
//
////	public RoomType roomType;
////	@Test
////	public void testCreatRoom() {
////		RoomService. (RoomType.INDIVIDUAL_ROOM);
//	
////	}
////	@Test 
////	public void lk() {
////		Optional<TutorReviews> review = tutorReviewsRepository.findById(1);
////		 Set g =TutorService.getTutor("okis").getReview();
////		g.add(review.get());
////		TutorService.getTutor("okis").setReview(g);
////	}
//}
