package adresar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCContactRepository implements ContactRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCContactRepository(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Contact findById(int id) {
		return jdbcTemplate.queryForObject(("select firstName, lastName, phone, email, sexId, addressId, id from Contact where id=?"), new ContactRowMapper(), id);
	}

	@Override
	public List<Contact> findAll() {
		return jdbcTemplate.query("select firstName, lastName, phone, email, sexId, addressId, id from Contact", new ContactRowMapper());
	}
	

	private static final class ContactRowMapper implements RowMapper<Contact> {
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			int sexId = rs.getInt("sexId");
			int addressId = rs.getInt("addressId");
			int id = rs.getInt("id");
			return new Contact(firstName, lastName, phone, email, id, sexId, addressId);
		}
	}
	
	/*
	private Integer insertDataAndReturnId(Contact contact) {
		

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("contact");
		jdbcInsert.setGeneratedKeyName("id");

		Map<String, Object> args = new HashMap<String, Object>();
		
		args.put("firstName", contact.getFirstName());
		args.put("lastName", contact.getLastName());
		args.put("phone", contact.getPhone());
		args.put("email", contact.geteMail());

		
		Integer dataId = jdbcInsert.executeAndReturnKey(args).intValue();
						
		return dataId;
	}
*/
}
