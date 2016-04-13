/**
 * 
 */
package fr.frf.franfinance.rsi.red.ref.data.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.core.OneToManyResultSetExtractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.QBean;

import fr.frf.franfinance.rsi.red.ref.data.entity.Person;
import fr.frf.franfinance.rsi.red.ref.data.entity.query.QPerson;
import fr.frf.franfinance.rsi.red.ref.data.repository.IPersonRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yanndeungoue
 *
 */
@Repository
@Slf4j
public class PersonRepository implements IPersonRepository {
	

	@Autowired
	private DataSource dataSource;
	
	public Iterable<Person> findAll(Sort arg0){
		return null;
	}

	public Page<Person> findAll(Pageable arg0) {
		return null;
	}

	public long count() {
		return 0;
	}

	public void delete(Long arg0) {

	}

	public void delete(Person arg0) {

	}

	public void delete(Iterable<? extends Person> arg0) {
		delete(arg0);
	}

	public void deleteAll() {

	}

	public boolean exists(Long arg0) {
		return false;
	}

	public Iterable<Person> findAll() {
		return null;
	}

	public Iterable<Person> findAll(Iterable<Long> arg0) {
		return null;
	}

	public Person findOne(Long arg0) {
		return null;
	}

	public <S extends Person> S save(S arg0) {
		return null;
	}

	public <S extends Person> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@SuppressWarnings("static-access")
	public Iterable<Person> findPersonByName(String name) {
		List<Person> people = new ArrayList<Person>();
		QPerson qPerson = QPerson.person;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		SQLTemplates dialect = new MySQLTemplates();
		SQLQuery query = new SQLQuery(dialect)
		.from(qPerson)
		.where(qPerson.name.like("%"+name+"%"));
		//Long count = query.count();
		System.out.println(query.toString());
		people = jdbcTemplate.queryForList("Select PERSON.ID, PERSON.NAME,PERSON.SURNAME,PERSON.EMAIL from Person PERSON where PERSON.NAME LIKE '%"+name+"%';", Person.class);
				//query.list( new QBean<Person>(Person.class, qPerson.id, qPerson.name, qPerson.email, qPerson.surname));
		return people;
	}
}
