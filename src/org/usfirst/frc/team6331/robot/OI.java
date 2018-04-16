/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6331.robot;

import org.usfirst.frc.team6331.robot.commands.claw.StopClaw;
import org.usfirst.frc.team6331.robot.commands.claw.SuckCube;
import org.usfirst.frc.team6331.robot.commands.claw.ThrowCube;
import org.usfirst.frc.team6331.robot.commands.climb.ClimbDown;
import org.usfirst.frc.team6331.robot.commands.climb.ClimbStop;
import org.usfirst.frc.team6331.robot.commands.climb.ClimbUp;
import org.usfirst.frc.team6331.robot.commands.lift.LiftDown;
import org.usfirst.frc.team6331.robot.commands.lift.LiftStall;
import org.usfirst.frc.team6331.robot.commands.lift.LiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/*
	 * The buttons on the controllers. Setting local variables 
	 * and attaching them to the integer values of the button 
	 * numbers in the driver station. You don't generally need 
	 * to change these ever.
	 */
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
	
	public int xboxA = 1;
	public int xboxB = 2;
	public int xboxX = 3;
	public int xboxY = 4;
	public int xboxRB = 5;
	public int xboxLB = 6;
	public int xboxRX = 4;
	public int xboxRY = 5;
	public int xboxLX = 0;
	public int xboxLY = 1;
	public int xboxRT = 3;
	public int xboxLT = 2;
	
	/**
	 * Initializing the actual controllers to their assigned port numbers.
	 */
	public Joystick xbox = new Joystick(0);
	public Joystick log = new Joystick(1);
	
	
	/**
	 * The commands. The way it's made is to continuously initiate an instant command
	 * when the specific button is pressed and use the stop command when the button
	 * is released.
	 */
	public OI() {
		
		/**
		 * Claw commands. 
		 */
		new JoystickButton(log, logRT).whenPressed(new ThrowCube());
		new JoystickButton(log, logRT).whenReleased(new StopClaw());
		new JoystickButton(log, logLT).whenPressed(new SuckCube());
		new JoystickButton(log, logLT).whenReleased(new StopClaw());
		
		/**
		 * Lift commands.
		 */
		new JoystickButton(log, logY).whenPressed(new LiftUp());
		new JoystickButton(log, logY).whenReleased(new LiftStall());
		new JoystickButton(log, logB).whenPressed(new LiftDown());
		new JoystickButton(log, logB).whenReleased(new LiftStall());
		
		/**
		 * Climb commands.
		 */
		new JoystickButton(xbox, xboxY).whenPressed(new ClimbUp());
		new JoystickButton(xbox, xboxY).whenReleased(new ClimbStop());
		new JoystickButton(xbox, xboxB).whenPressed(new ClimbDown());
		new JoystickButton(xbox, xboxB).whenReleased(new ClimbStop());
	}
	
	
	/**
	 * Gets the Xbox controller for use in other classes.
	 * @return Xbox Controller
	 */
	public Joystick getXbox() {
		return xbox;
	}
	
	/**
	 * Gets the Logitech controller for use in other classes.
	 * @return Logitech Controller
	 */
	public Joystick getLog() {
		return log;
	}
}
