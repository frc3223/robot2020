/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import java.lang.Math;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.commands.intakeWheelIn;

public class DriveArcade extends CommandBase {

  private final DriveTrain m_drivetrain;
  public Joystick m_driverController;
  public Joystick m_manipulatorController;
  /**
   * Creates a new DriveArcade.
   */
  public DriveArcade(DriveTrain drivetrain, Joystick driverController, Joystick manipulatorController) {
    m_drivetrain = drivetrain;
    m_driverController = driverController;
    m_manipulatorController = manipulatorController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_LEFT_MOVE_AXIS);
    double rotateSpeed = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_LEFT_ROTATE_AXIS);
    double slowMoveSpeed = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_RIGHT_MOVE_AXIS);
    double slowRotateSpeed = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_RIGHT_ROTATE_AXIS);



    if(Math.abs(slowMoveSpeed) >= 0.1 || Math.abs(slowRotateSpeed) >= 0.1) {
      m_drivetrain.arcadeDrive(slowMoveSpeed *0.5, slowRotateSpeed *0.5);
    } else if(Math.abs(moveSpeed) >= 0.1 || Math.abs(rotateSpeed) >= 0.1)  {
      m_drivetrain.arcadeDrive(moveSpeed *1, rotateSpeed *1); //Times one is for clarity
    } else {
      m_drivetrain.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
