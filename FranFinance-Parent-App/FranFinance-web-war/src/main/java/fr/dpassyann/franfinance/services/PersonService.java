/**
 * 
 */
package fr.dpassyann.franfinance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.frf.franfinance.rsi.red.ref.data.entity.Person;
import fr.frf.franfinance.rsi.red.ref.data.repository.impl.PersonRepository;

/**
 * @author yanndeungoue
 *
 */
@RestController
@RequestMapping(path="/person")
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody List<Person> getPerson(){
		return Lists.newArrayList( personRepository.findPersonByName("ngoue") );
	}
}
