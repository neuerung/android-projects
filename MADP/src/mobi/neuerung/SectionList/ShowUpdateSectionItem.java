package mobi.neuerung.SectionList;

public class ShowUpdateSectionItem implements ShowUpdateItem{

	private final String title;
	
	public ShowUpdateSectionItem(String title) {
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	
	public boolean isSection() {
		return true;
	}

}
