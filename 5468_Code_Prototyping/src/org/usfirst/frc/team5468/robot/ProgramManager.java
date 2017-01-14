package org.usfirst.frc.team5468.robot;

import java.util.List;

import Templates.*;
import AutonomousPrograms.*;
import TeleopPrograms.*;

public class ProgramManager 
{
	public int AutonomousProgramCount;
	public int TeleopProgramCount;
	
	public List<AutonomousProgram> AutonomousPrograms;	
	public List<TeleopProgram> TeleopPrograms;
	
	public ProgramManager(Robot robot)
	{
		//Add autonomous programs to use here
		AutonomousPrograms.add(new AutonomousTest("Auto Test", robot));
		
		//Add teleop programs to use here
		TeleopPrograms.add(new TeleopTest("Teleop Test", robot));
		
		//Cache the size of both program arrays
		AutonomousProgramCount = AutonomousPrograms.size();
		TeleopProgramCount = TeleopPrograms.size();
	}
	
	//Finds an autonomous program via its index and returns the proper program
	//Returns null if a program cannot be found
	public AutonomousProgram GetAutonomousProgram(int index)
	{
		AutonomousProgram program = null;
		
		if(index >= 0 && index < AutonomousProgramCount)
		{
			program = AutonomousPrograms.get(index);
		}
		
		return program;
	}
	
	//Finds an autonomous program via its name and returns the proper program
	//Returns null if a program cannot be found
	public AutonomousProgram GetAutonomousProgram(String name)
	{
		AutonomousProgram program = null;
			
		for(int i = 0; i < AutonomousProgramCount; i++)
		{
			program = AutonomousPrograms.get(i);
			
			if(program.ProgramName == name)
			{
				return program;
			}
		}
			
		return null;
	}
	
	//Finds a teleop program via its index and returns the proper program
	//Returns null if a program cannot be found
	public TeleopProgram GetTeleopProgram(int index)
	{
		TeleopProgram program = null;
		
		if(index >= 0 && index < TeleopProgramCount)
		{
			program = TeleopPrograms.get(index);
		}
		
		return program;
	}
	
	//Finds an autonomous program via its name and returns the proper program
	//Returns null if a program cannot be found
	public TeleopProgram GetTeleopProgram(String name)
	{
		TeleopProgram program = null;
			
		for(int i = 0; i < TeleopProgramCount; i++)
		{
			program = TeleopPrograms.get(i);
			
			if(program.ProgramName == name)
			{
				return program;
			}
		}
				
		return null;
	}
}
