package main;

import quest.*;

public class Ubiquri {
	public enum ErrorId{
		OK,
		InvalidCall,
		Max
	}
	public enum Method{
		GET,
		POST,
		PUT,
		PATCH,
		DELETE
	}
	
	static protected Ubiquri mInst;
	public static Ubiquri shared(){
		if(mInst != null){
			mInst = new Ubiquri();
		}
		return mInst;
	}
	
	public Method mBufferMethod;
	public Object mBufferData;
	
	
	
	protected UQuestManager mQuestManager = new UQuestManagerInstant();
	
	
	
	public void setMethod(Method m) {mBufferMethod = m;}
	public void setData(Object data) {mBufferData = data;}
	
	
	public int request(String uri, UbiquriDelegate delegate){
		UQuest quest = mQuestManager.createQuest(uri, delegate);
		if (quest != null) {
			return quest.getId();
		}
		else return -1;
	}

}
