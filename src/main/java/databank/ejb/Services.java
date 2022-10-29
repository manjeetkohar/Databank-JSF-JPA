package databank.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databank.model.PersonPojo;
@Singleton 
public class Services {
	
	//get the log4j2 logger for this class
	private static final Logger LOG = LogManager.getLogger();
	@PersistenceContext(name = "DataBank")
	protected EntityManager em;
	
	public List<PersonPojo> readAllPeople(){
		LOG.debug("reading all people");
		TypedQuery< PersonPojo> allPeopleQuery = em.createNamedQuery( PersonPojo.PERSON_FIND_ALL, PersonPojo.class);
		return allPeopleQuery.getResultList();	
	}
	@Transactional
	public PersonPojo createPerson(PersonPojo person) {
		LOG.debug("Creating a person = "+person);
		em.persist(person);
		return person;
	}
	@Transactional
	public void deletePersonById(int id) {
		LOG.debug("deleting person by id= {}",id);
		PersonPojo person = readPersonById(id);
		if(person !=null) {
			em.refresh(person);
			em.remove(person);
		}
	}
	public PersonPojo readPersonById(int id) {
		LOG.debug("Reading a person by id={}",id);
		return em.find(PersonPojo.class,id);
	}
	@Transactional
	public PersonPojo updatePerson(PersonPojo person) {
		LOG.debug("updating a specific person = {}",person);
		PersonPojo updatePersonPojo = em.merge(person);
		return updatePersonPojo;
		
	}

}
