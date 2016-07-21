package quest;

import java.lang.reflect.Method;

import main.*;

public class UQuest {
	protected int mId;
	protected String mURI;
	public Object mObject;
	public Ubiquri.Method mMethod;
	
	public UbiquriDelegate mDelegate;
	
	public UQuest(int id,String uri){
		mId = id;
		mURI = uri;
	}
	public int getId() {
		return mId;
	}
	public String getURI() {
		return mURI;
	}
	
	public void execute(){
		
	}
}
