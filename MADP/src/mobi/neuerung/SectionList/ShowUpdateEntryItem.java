package mobi.neuerung.SectionList;

import mobi.neuerung.Wrapper.ShowUpdatesWrapper;



public class ShowUpdateEntryItem implements ShowUpdateItem{

	public final String title;
	public final String time;
	public ShowUpdatesWrapper _objShowUpdatesWrapper;
	
	public ShowUpdateEntryItem(String title, String subtitle,ShowUpdatesWrapper _objShowUpdatesWrapper) {
		this.title = title;
		this.time = subtitle;
		this._objShowUpdatesWrapper = _objShowUpdatesWrapper;
	}


	public boolean isSection() {
		return false;
	}

}
