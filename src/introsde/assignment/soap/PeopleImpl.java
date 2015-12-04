package introsde.assignment.soap;
import java.text.ParseException;
import java.util.List;

import javax.jws.WebService;

import introsde.assignment.model.CustomMeasureDefinition;
import introsde.assignment.model.HealthMeasureHistory;
import introsde.assignment.model.LifeStatus;
import introsde.assignment.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.People",
    serviceName="People")
public class PeopleImpl implements People {
	
	 //Method #1 => readPersonList()
	 @Override
	    public List<Person> getPeople() {
	        return Person.getAll();
	    }

	 
	//Method #2 => readPerson(Long id)
    @Override
    public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getName());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        
        return p;
    }


    //Method #3 => updatePerson(Person p)
    @Override
    public Person updatePerson(Person person) {

    	System.out.println("--------"+person);
        Person existing = Person.getPersonById(person.getIdPerson());
        Person newPerson = Person.getPersonById(person.getIdPerson());

        if (existing == null) {
            return null;
        } else {
            newPerson.setIdPerson(person.getIdPerson());
            
            if (person.getName() == null){
            	newPerson.setName(existing.getName());
            }
            else if (!(person.getName().equals(existing.getName()))){
            	newPerson.setName(person.getName());
            }
            else{
            	newPerson.setName(existing.getName());
            }
            
            if (person.getBirthdate() == null){
            	newPerson.setBirthdate(existing.getBirthdate());
            }
            else if (!(person.getBirthdate().equals(existing.getBirthdate()))){
            	newPerson.setBirthdate(person.getBirthdate());
            }
            else{
            	newPerson.setBirthdate(existing.getBirthdate());
            }
            
            if (person.getLastname() == null){
            	newPerson.setLastname(existing.getLastname());
            }
            else if (!(person.getLastname().equals(existing.getLastname()))){
            	newPerson.setLastname(person.getLastname());
            }
            else{
            	newPerson.setLastname(existing.getLastname());
            }
            
            if (person.getEmail() == null){
            	newPerson.setEmail(existing.getEmail());
            }
            else if (!(person.getEmail().equals(existing.getEmail()))){
            	newPerson.setEmail(person.getEmail());
            }
            else{
            	newPerson.setEmail(existing.getEmail());
            }
            
            if (person.getUsername() == null){
            	newPerson.setUsername(existing.getUsername());
            }
            else if (!(person.getUsername().equals(existing.getUsername()))){
            	newPerson.setUsername(person.getUsername());
            }
            else{
            	newPerson.setUsername(existing.getUsername());
            }
            
            Person.updatePerson(newPerson);
        }

        return Person.updatePerson(newPerson);
    }

    //Method #4 => createPerson(Person p)
    @Override
    public Person createPerson(Person person) {
    	
    	List <LifeStatus> life = person.getLifeStatus();
    	
    	if (life == null){
    		return Person.savePerson(person);
    	}
    	
    	int size = person.getLifeStatus().size();
    	
    	for(int i = 0; i<size; i++){
    		LifeStatus singleLifeStatus = life.get(i);
    		singleLifeStatus.setPerson(person);
    	}
    	
        Person newPerson = Person.savePerson(person);

        return newPerson;
    }
    
    //Method #5 => deletePerson(Long id)
    @Override
    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }
    
    //Method #6 => readPersonHistory(Long id, String measureType)
    @Override
    public List<HealthMeasureHistory> getMeasureHistory(int idPerson, String measure) {
    	return HealthMeasureHistory.getAllByName(idPerson, measure);
    }
    
    //Method #7 => readMeasureTypes()
    @Override
    public CustomMeasureDefinition getMeasureTypes(){
    	CustomMeasureDefinition cmd = new CustomMeasureDefinition();
    	return cmd;
    }
    
    //Method #8 => readPersonMeasure(Long id, String measureType, Long mid)
    @Override
    public HealthMeasureHistory getMeasureHistoryMid(int idPerson, String measureType, int mid) {
    	return HealthMeasureHistory.getAllByNameByMid(idPerson, measureType, mid);
    }
    
    //Method #9 => savePersonMeasure(Long id, Measure m)
    @Override
    public LifeStatus savePersonMeasure(int idPerson, LifeStatus ls) throws ParseException {
    	return LifeStatus.savePersonMeasure(idPerson, ls);
    }
    
    //Method #10 => updatePersonMeasure(Long id, Measure m)
    @Override
    public HealthMeasureHistory updatePersonMeasure(int idPerson, HealthMeasureHistory hmh) {
    	return HealthMeasureHistory.updateHealthMeasureHistory(idPerson, hmh);
    }

}