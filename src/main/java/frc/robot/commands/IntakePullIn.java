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
  Joystick manipulatorController;
  Intake intake;
  boolean isDone;
  int button;
  /**
   * Creates a new IntakeWheelOut.
   */
  public IntakePullIn(Intake intake, Joystick manipulatorController, int button) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.manipulatorController = manipulatorController;
    this.intake = intake;
    this.button = button;

    //addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    isDone = false;
    System.out.println("Intake Pull in Started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeMotorPullIn();
    if(!manipulatorController.getRawButton(button)){
      end(false);
      isDone = true;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.intakeMotorOff();
    intake.intakeRaise();
    System.out.println("Intake Pull In Stopped");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
