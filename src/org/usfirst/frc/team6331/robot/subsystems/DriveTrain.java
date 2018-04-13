package org.usfirst.frc.team6331.robot.subsystems;

import org.usfirst.frc.team6331.robot.commands.drive.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {

    private SpeedController m_frontLeft = new Victor(7);
    private SpeedController m_frontRight = new Victor(4);
    private SpeedController m_backLeft = new Victor(0);
    private SpeedController m_backRight = new Victor(1);
    private SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    private SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_backRight);
    
    private DifferentialDrive m_drive;
        
    private double max = 0.7;
    
    public DriveTrain() {
    	addChild("Front Left CIM", (Victor) m_frontLeft);
    	addChild("Front Right CIM", (Victor) m_frontRight);
    	addChild("Back Left CIM", (Victor) m_backLeft);
    	addChild("Back Right CIM", (Victor) m_backRight);
    	
    	m_drive = new DifferentialDrive(m_left, m_right);
    	m_drive.setSafetyEnabled(false);
    	m_drive.setExpiration(0.1);
    	m_drive.setMaxOutput(1.0);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(Joystick joy) {
        	
    	if (joy.getRawButton(6)) {
    		max = 0.8;
    	}
    	
    	if (!joy.getRawButton(6)) {
    		max = 0.5;
    	}
    		
    	if (joy.getRawAxis(3) > 0.2) {
    	//front
    		m_left.set((max * joy.getRawAxis(3)) + (joy.getRawAxis(0) * 0.4));
    		m_right.set((-max * joy.getRawAxis(3)) + (joy.getRawAxis(0) *0.4));
    	}
    	
    	if (joy.getRawAxis(2) > 0.2) {
    	//back
    		m_left.set((-max * joy.getRawAxis(2)) + (joy.getRawAxis(0) * 0.4));
    		m_right.set((max * joy.getRawAxis(2)) + (joy.getRawAxis(0) * 0.4));
    	}
    	
    	if(joy.getRawAxis(2) < 0.1 && joy.getRawAxis(3) < 0.1) {
    		stop();
    }
}
    
    public void setSpeed(double speed) {
    	m_right.set(speed);
    	m_left.set(speed);
    }
    
    public void forward() {
    	m_right.set(-0.6);
    	m_left.set(0.56);
    }
    
    public void right() {
    	m_right.set(0.3);
    	m_left.set(0.2);
    }
    
    public void left() {
		m_right.set(-0.8);
		m_left.set(-0.3);
    }
    
    public void stop() {
    	m_right.set(0);
    	m_left.set(0);
    }
    
    public void back() {
    	m_right.set(0.3);
		m_left.set(-0.3);
    }
}

