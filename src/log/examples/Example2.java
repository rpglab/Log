package log.examples;

import log.DiaryXL;
import log.LogType;

/**
 * An example to show how to generate log files with log information 
 * 
 * @author Xingpeng Li, xplipower@gmail.com 
 *         Website: https://rpglab.github.io/
 * 
 */
public class Example2 {

	DiaryXL _diary;
	boolean _memberBool = true;

	public Example2(DiaryXL diary)
	{
		_diary = diary;
		timeDelay(0.17f);
		_diary.hotLine(LogType.CheckPoint, "an object of Example 2 is instantiated");
	}

	void runPF() {
		// do something
		timeDelay(0.25f);	
		_diary.hotLine("PF is succefully completed");
	}
	
	void runOPF() {
		// do something
		timeDelayby1sec();
		_diary.hotLine(LogType.CheckPoint, "OPF is succefully completed");
	}
	
	void runRTCA() {
		// do something
		timeDelay(0.31f);
		_diary.hotLine(LogType.MileStone, "RTCA is succefully completed");
		if (_memberBool == true) _diary.hotLine(LogType.Warning, "the RTCA violations are too large to be correct");
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
	
	
	public static void main(String[] agrc)
	{
		DiaryXL diary = new DiaryXL();
		diary.initial("C:\\Users\\xli83\\Workspace\\Java_Projects\\PSSE-Raw_Loader\\Logger\\log\\log_xyz.txt");
		
		Example2 exmaple2 = new Example2(diary);
		
		diary.disableLog();
		exmaple2.runPF();
		exmaple2.runOPF();
		diary.enableLog();
		
		exmaple2.runRTCA();

		/* Program ends here */
		diary.done();
		System.out.println("Program ends here.");
	}
	
}

