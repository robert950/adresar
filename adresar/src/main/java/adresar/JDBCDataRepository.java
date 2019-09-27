package adresar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JDBCDataRepository implements DataRepository{
	
	private static final String SELECT_ALL_DATA = "select data1.id as dataId, data1.contactFirstName, data1.contactLastName, data1.contactPhone, data1.contactEmail, data1.addressStreetName, data1.addressStreetNO, "
			+ "country.id as countryId, country.name as countryName, "
			+ "city.id as cityId, city.name as cityName, city.zipCode, "
			+ "sex.id as sexId, sex.name as sexName "
			+ "from data1, country, city, sex "
			+ "where data1.cityName = city.name and data1.countryName = country.name and data1.sexName = sex.name";
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDataRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	 }
	
	@Override
	public List<Data> findAll() {
						
		return jdbcTemplate.query(SELECT_ALL_DATA, new DataRowMapper());
	}
	
	@Override
	public Data save(Data d){
		Integer dataId = insertDataAndReturnId(d);		
		Data data = new Data(dataId, d.getContact(), d.getCountry(), d.getCity(), d.getAddress(),d.getSex());

		return data;
	}
	
	
	private static final class DataRowMapper implements RowMapper<Data> {

		 public Data mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			
			
			String fName = resultSet.getString("contactFirstName");
			String lName = resultSet.getString("contactLastName");
			String phone = resultSet.getString("contactPhone");
			String eMail = resultSet.getString("contactEmail");
			
			int id = resultSet.getInt("dataId");
			int addressId = resultSet.getInt("dataId");	
			
			int sexId = resultSet.getInt("sexId");
						
			Contact contact = new Contact (fName, lName, phone, eMail, id, sexId, addressId);
			
			String street = resultSet.getString("addressStreetName");
			String street_NO = resultSet.getString("addressStreetNO");
			int cityId = resultSet.getInt("cityId");			
			Address address = new Address(street, street_NO, addressId, cityId); 
			
			String countryName = resultSet.getString("countryName");
			int countryId = resultSet.getInt("countryId");			
			Country country = new Country(countryName, countryId);
			
			String cityName = resultSet.getString("cityName");
			String cityZip = resultSet.getString("zipCode");			
			City city = new City (cityName, cityZip, cityId, countryId);
			
			String sexName =  resultSet.getString("sexName");		
			Sex sex = new Sex (sexName, sexId);		
			
			int dataId = resultSet.getInt("dataId");			
			Data data = new Data (dataId, contact, country, city, address, sex);
						
			return data;		
		 }
	}
	
	
	private Integer insertDataAndReturnId(Data data) {
		

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("data1");
		jdbcInsert.setGeneratedKeyName("id");

		Map<String, Object> args = new HashMap<String, Object>();
		
		args.put("contactFirstName", data.getContact().getFirstName());
		args.put("contactLastName", data.getContact().getLastName());
		args.put("contactPhone", data.getContact().getPhone());
		args.put("contactEmail", data.getContact().geteMail());
		args.put("addressStreetName", data.getAddress().getStreet());
		args.put("addressStreetNO", data.getAddress().getStreet_NO());
		args.put("countryName", data.getCountry().getName());
		args.put("cityName", data.getCity().getName());
		args.put("cityZip", data.getCity().getZipCode());
		args.put("sexName", data.getSex().getName());
		
		Integer dataId = jdbcInsert.executeAndReturnKey(args).intValue();
						
		return dataId;
	}
	
	
	
	
}
