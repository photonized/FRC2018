package org.usfirst.frc.team6331.robot.subsystems;

import org.usfirst.frc.team6331.robot.Robot;
import org.usfirst.frc.team6331.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

    private SpeedController m_frontLeft = new Victor(9);
    private SpeedController m_frontRight = new Victor(4);
    private SpeedController m_backLeft = new Victor(3);
    private SpeedController m_backRight = new Victor(2);
    private SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    private SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_backRight);
    
    private DifferentialDrive m_drive;
    
    //private Encoder m_rightEncoder = new Encoder(1, 2, true, EncodingType.k4X);
    //private Encoder m_leftEncoder = new Encoder(3, 4, true, EncodingType.k4X);
    
    private AnalogGyro m_gyro = new AnalogGyro(1);
    
    private double max = 0.8;
    
    public DriveTrain() {
    	addChild("Front Left CIM", (Victor) m_frontLeft);
    	addChild("Front Right CIM", (Victor) m_frontRight);
    	addChild("Back Left CIM", (Victor) m_backLeft);
    	addChild("Back Right CIM", (Victor) m_backRight);
    	
    	m_drive = new DifferentialDrive(m_left, m_right);
    	m_drive.setSafetyEnabled(true);
    	m_drive.setExpiration(0.1);
    	m_drive.setMaxOutput(1.0);
    	
    	//m_rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    	//m_leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    	
    	/*if(Robot.isReal()) {
    		m_rightEncoder.setDistancePerPulse(0.0785398);
    		m_leftEncoder.setDistancePerPulse(0.0785398);
    	} else {
    		m_rightEncoder.setDistancePerPulse((4.0 * Math.PI) / (360.0 * 12.0));
    		m_rightEncoder.setDistancePerPulse((4.0 * Math.PI) / (360.0 * 12.0));
    	}*/
    	if(Robot.isReal()) {
    		m_gyro.setSensitivity(0.007);
    	}
    	addChild("Gyro", m_gyro);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(Joystick joy) {
    	m_left.set((-max * joy.getRawAxis(3)) - joy.getRawAxis(0));
    	m_right.set((-max * joy.getRawAxis(3)) + joy.getRawAxis(0));
    	
    	m_left.set((max * joy.getRawAxis(2)) - joy.getRawAxis(0));
    	m_right.set((max * joy.getRawAxis(2)) + joy.getRawAxis(0));
    }
    
    public void tankDrive() {
    	
    }
    
    public void forward() {
    	m_right.set(-0.6);
    	m_left.set(0.6);
    }
    
    public void right() {
    	m_right.set(0.3);
    	m_left.set(0.2);
    }
    
    public void left() {
		m_right.set(1.0);
		m_left.set(0.4);
    }
    
    public void stop() {
    	m_right.set(0);
    	m_left.set(0);
    }
    
    public void back() {
    	m_right.set(0.3);
		m_left.set(-0.37);
    }
}

