package AutonomousPrograms;
import org.usfirst.frc.team5468.robot.*;
import Templates.AutonomousProgram;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousTest extends AutonomousProgram
{	
	public AutonomousTest(String name, Robot robot) 
	{
		super(name, robot);
	}

	@Override
	public void AutonomousInit() 
	{
		SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Init!");
	}

	@Override
	public void AutonomousPeriodic() 
	{
		SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Periodic!");
	}

	@Override
	public void AutonomousStop() 
	{
		SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Stopped!");
	}

	@Override
	public void AutonomousStoppedPeriodic() 
	{
		// TODO Auto-generated method stub
		
	}

}
