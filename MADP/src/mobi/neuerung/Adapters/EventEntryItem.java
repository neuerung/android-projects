package mobi.neuerung.Adapters;

import mobi.neuerung.Wrapper.EventsWrapper;


public class EventEntryItem implements EventItem{

	public final String title;
	public final String time;
	public EventsWrapper _objEventsWrapper;
	public EventEntryItem(String title, String subtitle,EventsWrapper _objEventsWrapper) {
		this.title = title;
		this.time = subtitle;
		this._objEventsWrapper = _objEventsWrapper;
	}


	public boolean isSection() {
		return false;
	}

}
