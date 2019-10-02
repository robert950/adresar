package adresar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCSexRepository implements SexRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSexRepository(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Sex findById(int id) {
		return jdbcTemplate.queryForObject(("select id, name from Sex where id=?"), new SexRowMapper(), id);
	}

	@Override
	public List<Sex> findAll() {
		return jdbcTemplate.query("select id, name from Sex", new SexRowMapper());
	}
	

	private static final class SexRowMapper implements RowMapper<Sex> {
		public Sex mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			return new Sex(name, id);
		}
	}

}
