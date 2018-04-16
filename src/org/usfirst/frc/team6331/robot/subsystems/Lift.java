package org.usfirst.frc.team6331.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Lift extends Subsystem {

	public static final double up = 0.7;
	public static final double down = -0.1;
	public static final double off = 0.0;
	public static final double stop = 0.3;
	
	private SpeedController m_lift = new Victor(9);//9
	
	public Lift() {
		addChild("Lift Motor", (Victor) m_lift);
	}
	
	
	public void setSpeed(double speed) {
		m_lift.set(-speed);
	}
	
	public void up() {
		m_lift.set(up);
	}
	
	public void down() {
		m_lift.set(down);
	}
	
	public void stall() {
		m_lift.set(stop);
	}
	
	public void stop() {
		m_lift.set(off);
	}
    public void initDefaultCommand() {
    }
}

