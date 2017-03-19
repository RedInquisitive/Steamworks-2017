package org.usfirst.frc.team3695.robot.commands;

import org.usfirst.frc.team3695.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandDistance extends Command {
	
	public static final long TIME_WAIT = 1000;
	public final double inches;
	private long time;
	private boolean inRange;
	
	public CommandDistance(double inches) {
		this.inches = inches;
		requires(Robot.SUB_DRIVE);
	}
	
    protected void initialize() {
    	Robot.SUB_DRIVE.reset();
    }

    protected void execute() {
    	inRange = Robot.SUB_DRIVE.driveDistance(inches, inches);
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
