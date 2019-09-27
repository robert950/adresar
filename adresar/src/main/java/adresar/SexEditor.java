package adresar;

import java.beans.PropertyEditorSupport;

public class SexEditor extends PropertyEditorSupport{
	
	private SexRepository sexRepository;
	
	public SexEditor (SexRepository sexRepository) {
		this.sexRepository = sexRepository;
	}
	
	
	@Override
	public void setAsText(String text) {
		Sex sex = null;
		for (Sex s : sexRepository.findAll()) {
			if (s.getId()==Integer.parseInt(text)) {
				sex = s;
				break;
			}
		}
		this.setValue(sex);
	}


	@Override
	public String getAsText() {
		Sex sex = (Sex) this.getValue();
		return (sex != null ? Integer.toString(sex.getId()) : "");
	}

}
