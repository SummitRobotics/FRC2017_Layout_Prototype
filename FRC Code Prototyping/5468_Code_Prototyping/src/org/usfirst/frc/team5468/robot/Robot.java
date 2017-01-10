package org.usfirst.frc.team5468.robot;

import Templates.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public RobotMap robotMap;
	
	public ProgramManager programManager;
	
	SendableChooser<String> autoProgramChooser;
	SendableChooser<String> teleopProgramChooser;

	public AutonomousProgram autonomousProgram;
	
	public TeleopProgram teleopProgram;
	
	public Joystick gamepad1;
	public Joystick gamepad2;
	
	final public String AUTO_CHOOSER_LABEL = "Auto Program Chooser";
	final public String TELEOP_CHOOSER_LABEL = "Teleop Program Chooser";
	final public String INFO_LABEL = "Info";
	
	public int autonomousProgramIndex = 0;
	public int teleopProgramIndex = 0;
	
	public boolean willRunAutonomous = false;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	robotMap = new RobotMap(this);
    	programManager = new ProgramManager(this);
    	
    	SetupAutonomousProgramOptions();
    	SetupTeleopProgramOptions();
    	
    	SetupJoysticks();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit()
    {
    	if(autonomousProgram != null)
    		autonomousProgram.AutonomousStop();
    	
    	if(teleopProgram != null)
    		teleopProgram.TeleopStop();
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
		
		if(autonomousProgram != null)
    		autonomousProgram.AutonomousStoppedPeriodic();
    	
    	if(teleopProgram != null)
    		teleopProgram.TeleopStoppedPeriodic();
	}

    public void autonomousInit() 
    {
    	/*
    	 * Set a fallback value for the autonomous program index 
    	 * (incase we can't get the option from the smart dashboard)
    	*/
    	
    	//Attempt to get the chosen autonomous option from the smart dashboard
    	try
    	{
	    	
	    	autonomousProgram = programManager.GetAutonomousProgram(autoProgramChooser.getSelected());
    	}catch (Exception e)
    	{
    		SmartDashboard.putString(INFO_LABEL, "Couldn't get choosen auto option: " + e.getMessage());
    	}
	    	
	    //Only run autonomous if the proper autonomous program was found
	    if(autonomousProgram != null)
	    {
	    	willRunAutonomous = true;
	    }
    	
    	if(willRunAutonomous && autonomousProgram != null)
    	{
    		autonomousProgram.AutonomousInit();
    	}
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
        
        //Only call the autonomous function if we are definitely sure we are running autonomous
        if(willRunAutonomous && autonomousProgram != null)
        {
        	autonomousProgram.AutonomousPeriodic();
        }
    }

    public void teleopInit() 
    {
    	//Ensure that autonomous has stopped
    	if(autonomousProgram != null)
    	{
    		autonomousProgram.AutonomousStop();
    	}
    	
    	//Attempt to get the choosen teleop option from the smart dashboard
    	try
    	{
	    	teleopProgram = programManager.GetTeleopProgram(teleopProgramChooser.getSelected());
    	}catch (Exception e)
    	{
    		SmartDashboard.putString(INFO_LABEL, "Couldn't get choosen teleop option: " + e.getMessage());
    	}
    	
    	if(teleopProgram != null)
    	{
    		teleopProgram.TeleopInit();
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        if(teleopProgram != null)
        {
        	teleopProgram.TeleopPeriodic();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
    
    void SetupAutonomousProgramOptions()
    {
    	autoProgramChooser.addDefault("None", "None");
    	
    	for(int i = 0; i < programManager.AutonomousProgramCount; i++)
    	{
    		String programName = programManager.GetAutonomousProgram(i).ProgramName;
    		autoProgramChooser.addObject(programName, programName);
    	}
    	
    	SmartDashboard.putData(AUTO_CHOOSER_LABEL, autoProgramChooser);
    }
    
    void SetupTeleopProgramOptions()
    {
    	for(int i = 0; i < programManager.TeleopProgramCount; i++)
    	{
    		String programName = programManager.GetTeleopProgram(i).ProgramName;
    		if(i == 0)
    		{
    			teleopProgramChooser.addDefault(programName, programName);
    		}
    		else
    		{
    			teleopProgramChooser.addObject(programName, programName);
    		}
    	}
    	
    	SmartDashboard.putData(TELEOP_CHOOSER_LABEL, teleopProgramChooser);
    }
    
    void SetupJoysticks()
    {
    	try
    	{
    		gamepad1 = new Joystick(0);
    	} catch (Exception e)
    	{
    		SmartDashboard.putString(INFO_LABEL, "Couldn't setup Joystick 1: " + e.getMessage());
    	}
    	
    	try
    	{
    		gamepad2 = new Joystick(1);
    	} catch (Exception e)
    	{
    		SmartDashboard.putString(INFO_LABEL, "Couldn't setup Joystick 2: " + e.getMessage());
    	}
    }
}
