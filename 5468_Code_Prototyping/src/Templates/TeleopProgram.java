package Templates;
import org.usfirst.frc.team5468.robot.*;

public abstract class TeleopProgram 
{
	public Robot MainRobot;
	public String ProgramName;
	
	public TeleopProgram (String name, Robot robot)
	{
		MainRobot = robot;
		ProgramName = name;
	}
	
	public abstract void TeleopInit();
	
	public abstract void TeleopPeriodic();
	
	public abstract void TeleopStop();
	
	public abstract void TeleopStoppedPeriodic();
}
