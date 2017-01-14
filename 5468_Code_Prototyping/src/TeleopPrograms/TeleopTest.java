package TeleopPrograms;
import org.usfirst.frc.team5468.robot.*;
import Templates.TeleopProgram;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopTest extends TeleopProgram
{
	public TeleopTest(String name, Robot robot)
	{
		super(name, robot);
	}
	
	@Override
	public void TeleopInit() 
	{
		SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Init!");
	}

	@Override
	public void TeleopPeriodic() 
	{	
		if(MainRobot.gamepad1 != null)
		{
			SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Periodic!\nX: " + 
				MainRobot.gamepad1.getX(Hand.kLeft) +"\nY: " + MainRobot.gamepad1.getY(Hand.kLeft));
		}
	}

	@Override
	public void TeleopStop() 
	{
		SmartDashboard.putString(MainRobot.INFO_LABEL, ProgramName + " Stopped!");
	}

	@Override
	public void TeleopStoppedPeriodic() {
		// TODO Auto-generated method stub
		
	}

}
