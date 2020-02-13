/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class ClimberWinchUp extends CommandBase {
  public Climber climber;
  public Joystick driverController;
  /**
   * Creates a new ClimberDown.
   */
  public ClimberWinchUp(Climber climber, Joystick driverController) {
    this.driverController = driverController;
    this.climber = climber;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      climber.winchExtend();
    
    if(!driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_WINCH_UP)){
      end(false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.winchstop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
