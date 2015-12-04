package introsde.assignment.soap;
import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.assignment.model.CustomMeasureDefinition;
import introsde.assignment.model.HealthMeasureHistory;
import introsde.assignment.model.LifeStatus;
import introsde.assignment.model.Person;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
	
	/**
	 * Return the list of all the people in the database
	 * @return
	 */
	@WebMethod(operationName="readPersonList")
    @WebResult(name="person") 
    public List<Person> getPeople();
	
	/**
	 * Return the person specified by an id
	 * @param id
	 * @return
	 */
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") int id);

    /**
     * Update the person's information. Not the healthProfile
     * @param person
     * @return
     * @throws ParseException 
     */
    @WebMethod(operationName="updatePerson")
    @WebResult(name="person") 
    public Person updatePerson(@WebParam(name="person") Person person);

    /**
     * Create a new person and return the information related to the newly person
     * @param person
     * @return
     */
    @WebMethod(operationName="createPerson")
    @WebResult(name="person") 
    public Person createPerson(@WebParam(name="person") Person person);

    /**
     * Delete the person identified by the id from the system
     * @param id
     * @return
     */
    @WebMethod(operationName="deletePerson")
    @WebResult(name="personId") 
    public int deletePerson(@WebParam(name="personId") int id);
    
    
    /**
	 * Return the history of measurements regarding a person id
	 * @param id
	 * @return
	 */
    @WebMethod(operationName="readPersonHistory")
    @WebResult(name="measure") 
    public List<HealthMeasureHistory> getMeasureHistory(@WebParam(name="personId") int id, @WebParam(name="measureType") String measure);
    
    
	/**
	 * Return the list of all the measurements
	 * @return
	 */
	@WebMethod(operationName="readMeasureTypes")
    @WebResult(name="measureType") 
    public CustomMeasureDefinition getMeasureTypes();
	
	
	/**
	 * return the value of {measureType} (e.g. weight) identified by {mid} for Person identified by {id}
	 * @param id
	 * @return
	 */
    @WebMethod(operationName="readPersonMeasure")
    @WebResult(name="measure") 
    public HealthMeasureHistory getMeasureHistoryMid(@WebParam(name="personId") int id, @WebParam(name="measureType") String measure, @WebParam(name="mid") int mid);
    

    /**
     * Create a new person and return the information related to the newly person
     * @param person
     * @return
     * @throws ParseException 
     */
    @WebMethod(operationName="savePersonMeasure")
    @WebResult(name="newValueMeasurement") 
    public LifeStatus savePersonMeasure(@WebParam(name="personId") int idPerson, @WebParam(name="lifeStatus") LifeStatus ls) throws ParseException;
    
    
    
    /**
     * update the measure identified with {m.mid}, related to the Person identified by {id}
     * @param person
     * @return
     */
    @WebMethod(operationName="updatePersonMeasure")
    @WebResult(name="updatedValueMeasurement") 
    public HealthMeasureHistory updatePersonMeasure(@WebParam(name="personId") int idPerson, @WebParam(name="measure") HealthMeasureHistory hmh);
    
    
    /*@WebMethod(operationName="updatePersonHealthProfile")
    @WebResult(name="hpId") 
    public int updatePersonHP(@WebParam(name="personId") int id, @WebParam(name="lifeStatus") LifeStatus hp);
    */
}