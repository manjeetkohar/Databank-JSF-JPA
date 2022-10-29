/*****************************************************************
 * File: PersonPojo.java Course materials (22W) CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import databank.ejb.Services;
import databank.model.PersonPojo;

/**
 * Description: Implements the C-R-U-D API for the database
 * 
 */
@Named
@ApplicationScoped
public class PersonDaoImpl implements PersonDao, Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	@EJB
	protected Services ps;

	@Override
	public List< PersonPojo> readAllPeople() {
		return ps.readAllPeople();
	}

	@Override
	public PersonPojo createPerson( PersonPojo person) {
		return ps.createPerson(person);
	}

	@Override
	public PersonPojo readPersonById( int personId) {
		return ps.readPersonById( personId);
	}

	@Override
	public PersonPojo updatePerson( PersonPojo personWithUpdates) {
		return ps.updatePerson(personWithUpdates);
	}

	@Override
	public void deletePersonById( int personId) {
		ps.deletePersonById(personId);
		
	}

}