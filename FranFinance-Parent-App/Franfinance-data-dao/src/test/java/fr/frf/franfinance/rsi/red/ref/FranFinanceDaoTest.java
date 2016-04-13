/**
 * 
 */
package fr.frf.franfinance.rsi.red.ref;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.mysema.commons.lang.Assert;

import fr.frf.franfinance.rsi.red.ref.data.FranFinancePersistenceApplicationConfig;
import fr.frf.franfinance.rsi.red.ref.data.entity.Person;
import fr.frf.franfinance.rsi.red.ref.data.repository.impl.PersonRepository;

/**
 * @author yanndeungoue
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FranFinancePersistenceApplicationConfig.class})
public class FranFinanceDaoTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void getPersonByNameTest(){
		Iterable<Person> result =  personRepository.findPersonByName("ngoue");
		List<Person> personArrayList = Lists.newArrayList(result);
		Person p = result.iterator().next();
		System.out.println(p);
		Assert.isTrue(personArrayList.size() == 2, "Error");
	}

}
