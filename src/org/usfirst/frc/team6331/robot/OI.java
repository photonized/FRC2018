/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6331.robot;

import org.usfirst.frc.team6331.robot.commands.SetIntakeSpeed;
import org.usfirst.frc.team6331.robot.subsystems.Claw;
import org.usfirst.frc.team6331.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick xbox = new Joystick(0);
	public Joystick log = new Joystick(1);
	
	public OI() {
		new JoystickButton(log, 8).whenPressed(new SetIntakeSpeed(Claw.output));
		new JoystickButton(log, 7).whenPressed(new SetIntakeSpeed(Claw.input));
	}
	
	public Joystick getXbox() {
		return xbox;
	}
	
	public Joystick getLog() {
		return log;
	}
}
