package log.examples;

import log.DiaryXL;
import log.LogType;

/**
 * An example to show how to generate log files with log information 
 * 
 * @author Xingpeng Li, xplipower@gmail.com 
 * 
 */
public class Example1 {
	
	int _memberInt;
	DiaryXL _diary;

	public Example1()
	{
		_memberInt = 0;
	}

	void runPF() {
		// do something
		timeDelay(0.25f);	
		if (_diary != null) _diary.hotLine("PF is succefully completed");
	}
	
	void runOPF() {
		// do something
		timeDelayby1sec();
		if (_diary != null) _diary.hotLine(LogType.CheckPoint, "OPF is succefully completed");
	}
	
	void runRTCA() {
		// do something
		timeDelay(0.31f);
		if (_diary != null) _diary.hotLine(LogType.MileStone, "RTCA is succefully completed");
	}
	
	void timeDelayby1sec() {
		float deltaT = 1f;
		timeDelay(deltaT);
	}

	void timeDelay(float deltaT) {
		long t_start = System.nanoTime();
		do {
		    if ((System.nanoTime() - t_start)/1e9f > deltaT) break;
		} while(true);
	}
	
	void setDiary(DiaryXL diary) {_diary = diary;}
	
	
	public static void main(String[] agrc)
	{
		DiaryXL diary = new DiaryXL();
		diary.initial();
		
		Example1 exmaple1 = new Example1();
		exmaple1.setDiary(diary);
		
		exmaple1.runPF();
		exmaple1.runOPF();
		exmaple1.runRTCA();

		/* Program ends here */
		diary.done();
		System.out.println("Program ends here.");
	}
	
}
