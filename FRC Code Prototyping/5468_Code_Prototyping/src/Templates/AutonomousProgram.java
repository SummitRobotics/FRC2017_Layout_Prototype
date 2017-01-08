package Templates;
import org.usfirst.frc.team5468.robot.*;

public abstract class AutonomousProgram
{
	public Robot MainRobot;
	
	public String ProgramName;
	
	public AutonomousProgram(String name, Robot robot)
	{
		MainRobot = robot;
		ProgramName = name;
	}

	public abstract void AutonomousInit();
	
	public abstract void AutonomousPeriodic();
	
	public abstract void AutonomousStop();
	
	public abstract void AutonomousStoppedPeriodic();
}
