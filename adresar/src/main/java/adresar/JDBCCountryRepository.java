package adresar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCCountryRepository implements CountryRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCountryRepository(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Country findById(int id) {
		return jdbcTemplate.queryForObject(("select id, name from Country where id=?"), new CountryRowMapper(), id);
	}

	@Override
	public List<Country> findAll() {
		return jdbcTemplate.query("select id, name from Country", new CountryRowMapper());
	}
	

	private static final class CountryRowMapper implements RowMapper<Country> {
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			return new Country(name, id);
		}
	}

}
