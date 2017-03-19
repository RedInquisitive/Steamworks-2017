package org.usfirst.frc.team3695.robot.commands;

import org.usfirst.frc.team3695.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandRotateDegrees extends Command {	
	public static final double SCALAR = (22.5 * Math.PI) / 360;
	public static final long TIME_WAIT = 1000;
	
	private boolean inRange;
	private long time;
	public final double inches;
	
	public CommandRotateDegrees(double degrees) {
		this.inches = degrees * SCALAR;
		requires(Robot.SUB_DRIVE);
	}
	
    protected void initialize() {
    	Robot.SUB_DRIVE.reset();
    }

    protected void execute() {
    	inRange = Robot.SUB_DRIVE.driveDistance(inches, -inches);
    }

    protected boolean isFinished() {
    	if(!inRange) {
    		time = System.currentTimeMillis() + TIME_WAIT;
    	}
        return time < System.currentTimeMillis();
    }

    protected void end() {
    	Robot.SUB_DRIVE.driveDirect(0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
