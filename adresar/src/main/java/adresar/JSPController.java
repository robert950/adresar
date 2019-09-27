package adresar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"newDataForm"})
public class JSPController {
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private SexRepository sexRepository;
	
	@Autowired
	private DataRepository dataRepository;
	
	
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Contact.class, new ContactEditor(contactRepository));
		binder.registerCustomEditor(Address.class, new AddressEditor(addressRepository));
		binder.registerCustomEditor(Country.class, new CountryEditor(countryRepository));
		binder.registerCustomEditor(City.class, new CityEditor(cityRepository));
		binder.registerCustomEditor(Sex.class, new SexEditor(sexRepository));	
	}
	
	@GetMapping("/enterData")
	public String showForm(Model model) {
		
		model.addAttribute("contacts", contactRepository.findAll()); 
		model.addAttribute("addresses", addressRepository.findAll());
		model.addAttribute("countries", countryRepository.findAll());
		model.addAttribute("cities", cityRepository.findAll());
		model.addAttribute("sexes", sexRepository.findAll());
		
		return "enterData";
	}
	
	
	@PostMapping("/enterData")
	public String processForm(@ModelAttribute NewDataForm newDataForm, Model model) {
		return "confirmData";
	}
	
	
	@ModelAttribute("newDataForm")
	public NewDataForm getNewDataForm() {
		return new NewDataForm();
	}
		
	
	@RequestMapping(value="/enterData", method=RequestMethod.GET, params="confirm")
	public String showFormAfterConfirm(Model model, NewDataForm newDataForm) {
				
		Contact contact = new Contact (newDataForm.getFirstName(), newDataForm.getLastName(), newDataForm.getPhone(), newDataForm.geteMail(), newDataForm.getContactId(), newDataForm.getSexId(), newDataForm.getAddressId());
		Address address = new Address(newDataForm.getStreet(), newDataForm.getStreetNo(), newDataForm.getAddressId(), newDataForm.getCityId());
		Country country = new Country (newDataForm.getCountryName(), newDataForm.getCountryId());
		City city = new City (newDataForm.getCityName(), newDataForm.getZipCode(), newDataForm.getCityId(), newDataForm.getCountryId());
		Sex sex = new Sex (newDataForm.getSex(), newDataForm.getSexId());
		
		Data data = new Data(1, contact, country, city, address, sex);	
				
		dataRepository.save(data);
		
		return "redirect:/enterData";
	}
	
	
	@GetMapping("/savedData")
	public String showSavedData(Model model) {
				
		model.addAttribute("data", dataRepository.findAll());
		
		return "savedData";
	}
	
	@RequestMapping(value="/savedData", method=RequestMethod.GET, params="back")
	public String returnFromSavedData (SessionStatus status) {
		status.setComplete();		
		return "redirect:/enterData";
	}
	

}
