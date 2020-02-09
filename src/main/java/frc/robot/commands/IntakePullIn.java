/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Joystick;

public class IntakePullIn extends CommandBase {
  Joystick driverController;
  Intake intake;
  /**
   * Creates a new IntakeWheelOut.
   */
  public IntakePullIn(Intake intake, Joystick DriverController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driverController = DriverController;
    this.intake = intake;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeMotorPullIn();

    if(!driverController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_PULL_IN)){
      end(false);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.intakeMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
