/**
 * 
 */
package fr.frf.franfinance.rsi.red.ref.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.frf.franfinance.rsi.red.ref.data.entity.Person;

/**
 * @author yanndeungoue
 *
 */
public interface IPersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public Iterable<Person> findPersonByName( final String name);

}
