package org.usfirst.frc.team6331.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

	public static final double up = -1.0;
	public static final double down = 0.1;
	public static final double off = 0.0;
	public static final double stop = -0.3;
	
	private SpeedController m_lift = new Victor(8);
	//private DigitalInput m_up = new DigitalInput(1);
	//private DigitalInput m_down = new DigitalInput(2);
	
	public Lift() {
		addChild("Lift Motor", (Victor) m_lift);
	}
	
	/*public boolean isUp() {
		return m_up.get();
	}
	
	public boolean isDown() {
		return m_up.get();
	}*/
	
	public void setSpeed(double speed) {
		m_lift.set(-speed);
	}
	
	public void up() {
		m_lift.set(up);
	}
	
	public void down() {
		m_lift.set(down);
	}
	
	public void stop() {
		m_lift.set(0);
	}
    public void initDefaultCommand() {
    }
}

