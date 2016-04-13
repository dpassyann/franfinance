package fr.frf.franfinance.rsi.red.ref.data.entity.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Generated;

import org.springframework.jdbc.core.RowMapper;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.PathMetadataFactory;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import fr.frf.franfinance.rsi.red.ref.data.entity.Person;

//import fr.frf.franfinance.rsi.red.ref.data.entity.Person;

@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QPerson extends RelationalPathBase<QPerson> {

	private static final long serialVersionUID = 686368063595693113L;
	
	public static final QPerson person = new QPerson("PERSON");
	
	public final NumberPath<Long> id = createNumber("ID", Long.class);
	public final StringPath name = createString("NAME");
	public final StringPath surname = createString("SURNAME");
	public final StringPath email = createString("EMAIL");
	public final PrimaryKey<QPerson> pkID = createPrimaryKey(id);

	public QPerson(Class<? extends QPerson> type, String variable, String schema, String table) {
		super(type, variable, schema, table);
	}
	
	public QPerson(Class<? extends QPerson> type, PathMetadata<?> metadata, String schema, String table) {
		super(type, metadata, schema, table);
	}

	public QPerson(String variable){
		super(QPerson.class, PathMetadataFactory.forVariable(variable), "FRANFINANCE", "PERSON");
	}
	
	private static String columnLabel(Path<?> path) {
		return path.toString();
	}
	
	public static class PersonMapper implements RowMapper<Person> {

		private static final QPerson qPerson = QPerson.person;

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person p = new Person();
			p.setId(rs.getLong(columnLabel(qPerson.id)));
			p.setName(rs.getString(columnLabel(qPerson.name)));
			p.setSurname(rs.getString(columnLabel(qPerson.surname)));
			p.setEmail(rs.getString(columnLabel(qPerson.email) ));
			return p;
		}
	}
	
	
}
