/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6331.robot;

import org.usfirst.frc.team6331.robot.commands.auto.AutoForward;
import org.usfirst.frc.team6331.robot.commands.auto.AutoLeft;
import org.usfirst.frc.team6331.robot.commands.auto.AutoMiddle;
import org.usfirst.frc.team6331.robot.commands.auto.AutoRight;
import org.usfirst.frc.team6331.robot.commands.auto.AutoSelect;
import org.usfirst.frc.team6331.robot.commands.auto.MiddleLeft;
import org.usfirst.frc.team6331.robot.commands.auto.MiddleRight;
import org.usfirst.frc.team6331.robot.commands.auto.None;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;
import org.usfirst.frc.team6331.robot.subsystems.Claw;
import org.usfirst.frc.team6331.robot.subsystems.Climb;
import org.usfirst.frc.team6331.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6331.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot; 
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.AutoMode;
import enums.Position;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static double AUTO_DELAY = 0;
	public static AutoMode AUTO_MODE = null;
	public static String GAME_DATA;
	
	public static OI oi;

	private SendableChooser<AutoMode> auto;
	public static SendableChooser<Integer> delay;
	private SendableChooser<Position> position;
	

	
	public static DriveTrain driveTrain = new DriveTrain();
	public static Claw claw = new Claw();
	public static Lift lift = new Lift();
	public static Climb climb = new Climb();
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		System.out.println("Starting...");
		
		oi = new OI();		
		System.out.println("OI started.");
		
		auto = new SendableChooser<>();
		auto.addDefault("None", AUTO_MODE.NONE);
		auto.addObject("Cross Line", AUTO_MODE.CROSS_LINE);
		auto.addObject("Drop Cube", AUTO_MODE.DROP);
		SmartDashboard.putData("Autonomous Mode:", auto);
		System.out.println("Auto Modes Initialized...");
		
		
		delay = new SendableChooser<>();
		delay.addDefault("0", 0);
		delay.addObject("1", 1);
		delay.addObject("2", 2);
		delay.addObject("3", 3);
		delay.addObject("4", 4);
		delay.addObject("5", 5);
		delay.addObject("6", 6);
		delay.addObject("7", 7);
		delay.addObject("8", 8);
		delay.addObject("9", 9);
		delay.addObject("10", 10);
		SmartDashboard.putData("Auto Delay", delay);
		System.out.print("Auto delay initialized...");
		
		
		position = new SendableChooser<>();
		position.addDefault("Middle", Position.MIDDLE);
		position.addObject("Left", Position.LEFT);
		position.addObject("Right", Position.RIGHT);
		SmartDashboard.putData("Start Position:", position);
		System.out.println("Positions initialized...");

		CameraServer.getInstance().startAutomaticCapture();
		System.out.println("Camera initialized...");
		
		
	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
			System.out.println(GAME_DATA);
	}

	@Override
	public void disabledPeriodic() {
		GAME_DATA = DriverStation.getInstance().getGameSpecificMessage();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		GAME_DATA = DriverStation.getInstance().getGameSpecificMessage();
		
		if(GAME_DATA.length() > 0) {
			System.out.println("(Robot.java) Game data retrieved");
			Command autoCommand = new AutoSelect(GAME_DATA, auto.getSelected(), position.getSelected()).getCommand();
			autoCommand.start();
		} else {
			System.out.println("Error: game data not retrieved...");
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//System.out.print("AUTO: " + gameData + "\n");
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
