/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class IntakeAutoLower extends CommandBase {
  private final Intake m_intake;
  private boolean isDone;
  Joystick manipulatorController;
  /**
   * Creates a new IntakeAutoLower.
   */
  public IntakeAutoLower(Intake intake, Joystick manipulatorController) {
    this. manipulatorController = manipulatorController;
    m_intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.intakeLower();
    m_intake.intakeMotorPullIn();
    isDone = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER)){
      end(false);
      System.out.println("Intake Auto Lower should be stopping");
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.intakeMotorOff();
    m_intake.intakeRaise();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
