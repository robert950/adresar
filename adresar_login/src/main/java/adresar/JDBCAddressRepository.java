package adresar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCAddressRepository implements AddressRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCAddressRepository(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Address findById(int id) {
		return jdbcTemplate.queryForObject(("select id, street, streetNo, cityId from Address where id=?"), new AddressRowMapper(), id);
	}

	@Override
	public List<Address> findAll() {
		return jdbcTemplate.query("select id, street, streetNo, cityId from Address", new AddressRowMapper());
	}

	private static final class AddressRowMapper implements RowMapper<Address> {
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			String street = rs.getString("street");
			String streetNo = rs.getString("streetNo");
			int id = rs.getInt("id");
			int cityId = rs.getInt("cityId");
			return new Address(street, streetNo, id, cityId);
		}
	}

}
