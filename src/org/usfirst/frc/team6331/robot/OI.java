/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6331.robot;

import org.usfirst.frc.team6331.robot.commands.ClimbDown;
import org.usfirst.frc.team6331.robot.commands.ClimbStop;
import org.usfirst.frc.team6331.robot.commands.ClimbUp;
import org.usfirst.frc.team6331.robot.commands.LiftDown;
import org.usfirst.frc.team6331.robot.commands.LiftStop;
import org.usfirst.frc.team6331.robot.commands.LiftUp;
import org.usfirst.frc.team6331.robot.commands.SetIntakeSpeed;
import org.usfirst.frc.team6331.robot.commands.StopClaw;
import org.usfirst.frc.team6331.robot.commands.SuckCube;
import org.usfirst.frc.team6331.robot.commands.ThrowCube;
import org.usfirst.frc.team6331.robot.subsystems.Claw;
import org.usfirst.frc.team6331.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public int logA = 2;
	public int logB = 3;
	public int logX = 1;
	public int logY = 4;
	public int logRB = 6;
	public int logLB = 5;
	public int logRX = 3;
	public int logRY = 4;
	public int logLX = 2;
	public int logLY = 1;
	public int logRT = 8;
	public int logLT = 7;
	
	public int xboxA = 0;
	public int xboxB = 1;
	public int xboxX = 2;
	public int xboxY = 3;
	public int xboxRB = 5;
	public int xboxLB = 4;
	public int xboxRX = 4;
	public int xboxRY = 5;
	public int xboxLX = 0;
	public int xboxLY = 1;
	public int xboxRT = 3;
	public int xboxLT = 2;
	
	
	public Joystick xbox = new Joystick(0);
	public Joystick log = new Joystick(1);
	
	public OI() {
		
		/**
		 * Claw commands.
		 */
		new JoystickButton(log, logRB).whenPressed(new ThrowCube());
		new JoystickButton(log, logRB).whenReleased(new StopClaw());
		new JoystickButton(log, logLB).whenPressed(new SuckCube());
		new JoystickButton(log, logLB).whenReleased(new StopClaw());
		
		/**
		 * Lift commands.
		 */
		new JoystickButton(log, logY).whenPressed(new LiftUp());
		new JoystickButton(log, logY).whenReleased(new LiftStop());
		new JoystickButton(log, logA).whenPressed(new LiftDown());
		new JoystickButton(log, logA).whenReleased(new LiftStop());
		
		/**
		 * Climb commands.
		 */
		new JoystickButton(xbox, xboxY).whenPressed(new ClimbUp());
		new JoystickButton(xbox, xboxY).whenReleased(new ClimbStop());
		new JoystickButton(xbox, xboxA).whenPressed(new ClimbDown());
		new JoystickButton(xbox, xboxA).whenReleased(new ClimbStop());
	}
	
	public Joystick getXbox() {
		return xbox;
	}
	
	public Joystick getLog() {
		return log;
	}
}
