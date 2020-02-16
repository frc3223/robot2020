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

public class DriveTank extends CommandBase {

  private final DriveTrain m_drivetrain;
  private final Joystrick m_driverController;

  /**
   * Creates a new DriveTank.
   */
  public DriveTank(DriveTrain driveTrain, Joystick driverController) {
    m_driveTrain = driveTrain;
    m_driverController = driverController;
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
    double leftStick = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_TANK_LEFT);
    double rightStick = m_driverController.getRawAxis(Constants.DRIVER_CONTROLLER_TANK_RIGHT);

    if(leftStick*rightStick < 0) {
      m_driveTrain.tankDrive(leftStick*Constants.TANK_DRIVE_SPEED_RATIO, rightStick*Constants.TANK_DRIVE_SPEED_RATIO);
    } else {
      m_driveTrain.tankDrive(leftStick, rightStick);
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
