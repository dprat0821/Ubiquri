package quest;

import java.util.Queue;

import main.*;

public abstract class UQuestManager {
	Queue<UQuest> mQuests;
//	static private UQuestManager mInstance;
//	
//	static public UQuestManager shared(){
//		if (mInstance == null) {
//			mInstance = new UQuestManager();
//		}
//		return mInstance;
//	}
	
	protected abstract void onQuestCreated ();
	
	public UQuest createQuest(String uri){return createQuest(uri,null);}
	
	public UQuest createQuest(String uri, UbiquriDelegate delegate){
		int newId = 0;
		if (!mQuests.isEmpty()) {
			newId = mQuests.peek().getId()+1;
		}
		UQuest quest = new UQuest(newId, uri);
		if(quest!= null){
			mQuests.add(quest);
			quest.mMethod = Ubiquri.shared().mBufferMethod;
			quest.mObject = Ubiquri.shared().mBufferData;
			quest.mDelegate = delegate;
		}
		return quest;
	}
	
	public void executeQuest(){
		UQuest quest = mQuests.poll();
		
		if (quest!= null) {
			quest.execute();
			
		}
	}
}
