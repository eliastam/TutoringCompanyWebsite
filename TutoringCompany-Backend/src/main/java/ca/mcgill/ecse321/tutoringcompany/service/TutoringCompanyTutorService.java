package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyTutorService {
	Pattern patternEmail = Pattern.compile(("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$"));
	@Autowired
	TutorRepository tutorRepository;

	/*------- Creation methods -------*/
	/**
	 * Create Tutor instance with the given parameters, save it, and return it
	 * 
	 * @param first_name   : first name of the tutor that will be created
	 * @param last_name    : last name of the tutor that will be created
	 * @param email        : email address of the tutor that will be created
	 * @param phone_number : phone number of the tutor that will be created
	 * @param password     : password of the tutor that will be created
	 * @return the created tutor
	 * @exception EntityExistsException     if the tutor is existed or the email is
	 *                                      used
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public Tutor createTutor(String first_name, String last_name, String email, String phone_number, String password) {
		tutorUnique(email);
		regexEmail(email);
		if (invalidTutorInfo(first_name, last_name, email, phone_number, password)) {
			throw new InvalidParameterException("Your tutor details are incomplete!");
		}
		Tutor tutor = new Tutor();
		tutor.setVerified(false);
		tutor.setFirst_name(first_name);
		tutor.setLast_name(last_name);
		tutor.setEmail(email);
		tutor.setPhone_number(phone_number);
		tutor.setPassword(password);
		tutorRepository.save(tutor);
		return tutor;
	}
	/*-------  Delete methods -------*/

	/**
	 * Delete specific tutor with the given email
	 * 
	 * @param email: email address of the tutor to delete
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public void deleteTutor(String email) {
		tutorExist(email);
		Tutor tutor = getTutor(email);
		tutor.setVerified(false);
		tutorRepository.save(tutor);

	}	/*------- Update methods -------*/

	/**
	 * Update all information for the tutor with the given email
	 * 
	 * @param currentemail: email address of the tutor that we will update his/her
	 *                      information
	 * @param first_name:   new first name
	 * @param last_name:    new last name
	 * @param phone_number: new phone number
	 * @param password:     new password
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutor(String email, String first_name, String last_name, String phone_number, String password) {
		tutorExist(email);
		if (invalidTutorInfo(first_name, last_name, email, phone_number, password)) {
			throw new InvalidParameterException("Your tutor details are incomplete!");
		}
		Tutor tutor = getTutor(email);
		tutor.setFirst_name(first_name);
		tutor.setLast_name(last_name);
		tutor.setPhone_number(phone_number);
		tutor.setPassword(password);
		tutorRepository.save(tutor);

	}

	/**
	 * Update password for the specific tutor whose email is given
	 * 
	 * @param email:    email address of the tutor that we will update his/her
	 *                  password
	 * @param password: new password
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorPassword(String email, String password) {
		tutorExist(email);
		if (password == null || password.trim().length() == 0) {
			throw new InvalidParameterException("Your password input is not correct");
		}
		getTutor(email).setPassword(password);
		tutorRepository.save(getTutor(email));
	}

	/**
	 * Update first name for the specific tutor whose email is given
	 * 
	 * @param email:      email address of the tutor that we will update his/her
	 *                    first name
	 * @param first_name: new first name
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorFirstName(String email, String first_name) {
		getTutor(email).setFirst_name(first_name);
		tutorRepository.save(getTutor(email));

	}

	/**
	 * Update last name for the specific tutor whose email is given
	 * 
	 * @param email:     email address of the tutor that we will update his/her last
	 *                   name
	 * @param last_name: new last name
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorLastName(String email, String last_name) {
		getTutor(email).setLast_name(last_name);
		tutorRepository.save(getTutor(email));
	}
	/*------- Get methods -------*/

	/**
	 * Read specific tutor by its given email
	 * 
	 * @param email: email address of the tutor that will be returned
	 * @return tutor
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public Tutor getTutor(String email) {
		return tutorRepository.findByEmail(email);
	}

//	    public List<Tutor> getAllVerifiedTutors() {
//	    	List<Tutor> verifiedTutors = new ArrayList<Tutor>();
//	    	for (int i = 0; i < getAllTutors().size(); i++) {
//	    		if (getAllTutors().get(i).isVerified() ==true) {
//	    			verifiedTutors.add(getAllTutors().get(i));
//	    		}
//	    	}
//		    return verifiedTutors;
//		    }
	/**
	 * Read list of all the tutors in the tutor repository
	 * 
	 * @return list of all tutors
	 */
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}

	/**
	 * Read list of all verified tutors
	 * 
	 * @return list of all verified tutors
	 */
	public List<Tutor> getVerifiedTutors() {

		List<Tutor> results = new ArrayList<Tutor>();

		for (Tutor tutor : getAllTutors()) {
			if (tutor.isVerified()) {
				results.add(tutor);
			}

		}
		return results;
	}

	/**
	 * this method create a list of type <T>
	 * 
	 * @param <T>
	 * @param iterable
	 * @return a list of type <T>
	 */
	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

	/*------- Assert methods -------*/
	/**
	 * throws an exception if tutor already exists
	 * 
	 * @param email: email address of tutor
	 * @exception EntityExistsException if tutor already exists
	 */
	@Transactional
	public void tutorUnique(String email) {
		if (tutorRepository.existsById(email))
			throw new EntityExistsException("Tutor Already Exists");
	}

	/**
	 * throws an exception if tutor does not exist
	 * 
	 * @param : email address of tutor
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public void tutorExist(String email) {
		if (tutorRepository.existsById(email) == false)
			throw new NullPointerException("Tutor Does not Exist");
	}

	/**
	 * this method makes sure that the input follows the correct pattern
	 * 
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param phone_number
	 * @param password
	 * @return true if in input is not correct, false otherwise
	 */
	private boolean invalidTutorInfo(String first_name, String last_name, String email, String phone_number,
			String password) {
		if (first_name == null || first_name.trim().length() == 0 || last_name == null || last_name.trim().length() == 0
				|| email == null || email.trim().length() == 0 || phone_number == null || phone_number == null
				|| password == null || password.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/*------------- other methods*************/
//	        
//	        public void verifyTutor(String email) {
//	        	getTutor(email).setVerified(true);;
//	        }
	@Transactional
	public Tutor verifyTutor(String email) {
		Tutor t = getTutor(email);
		t.setVerified(true);
		tutorRepository.save(t);
		return t;
	}
	public void regexEmail (String email){
		Matcher Emailmatcher = patternEmail.matcher(email);
		if(!Emailmatcher.matches()) {
			throw new InvalidParameterException("invalid email style");
		}
	}   

}
