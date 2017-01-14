package org.usfirst.frc.team5468.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	Robot mainRobot;
	
	//Sensor Port Declarations ------------------------------------------------
	public int rightDrive1Port = 1;
	public int rightDrive2Port = 2;
	public int leftDrive1Port = 3;
	public int leftDrive2Port = 4;
	
	public int armEncoderPort1 = 1;
	public int armEncoderPort2 = 2;
	
	public int armLowerLimitSwitchPort = 3;
	
	//Actual Hardware Declarations ----------------------------------------------
	
	public Encoder armEncoder;
	
	public AnalogInput armLowerLimitSwitch;
	
	public RobotMap (Robot robot)
	{
		mainRobot = robot;
		
		try
		{
			//armEncoder = new Encoder(armEncoderPort1, armEncoderPort2);
			
			//armLowerLimitSwitch = new AnalogInput(armLowerLimitSwitchPort);
		} catch (Exception e)
		{
			SmartDashboard.putString(mainRobot.INFO_LABEL, "Error setting up electronics: " + e.getMessage());
		}
	}
}
