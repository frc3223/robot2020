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

public class ClimberArmUp extends CommandBase {
  public Climber climber;
  public Joystick driverController;
  public boolean isDone;
  /**
   * Creates a new ClimberUp.
   */
  public ClimberArmUp(Climber climber, Joystick driverController) {
    this.driverController = driverController;
    this.climber = climber;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.armExtend();
    isDone = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_ARM_UP)){
      end(false);
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.armstop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
