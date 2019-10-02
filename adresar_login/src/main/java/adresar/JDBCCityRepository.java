package adresar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCCityRepository implements CityRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityRepository(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public City findById(int id) {
		return jdbcTemplate.queryForObject(("select id, name, zipCode, countryId from City where id=?"), new CityRowMapper(), id);
	}

	@Override
	public List<City> findAll() {
		return jdbcTemplate.query("select id, name, zipCode, countryId from City", new CityRowMapper());
	}

	private static final class CityRowMapper implements RowMapper<City> {
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			String zipCode = rs.getString("zipCode");
			int id = rs.getInt("id");
			int countryId = rs.getInt("countryId");
			return new City(name, zipCode, id, countryId);
		}
	}
}
