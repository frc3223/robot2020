/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class TimedAutoDrive extends CommandBase {
  private final DriveTrain m_driveTrain;
  private Timer time;
  /**
   * Creates a new TimedAutoDrive.
   */
  public TimedAutoDrive(DriveTrain driveTrain) {
    time = new Timer();
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.start();
    m_driveTrain.moveForward();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(time.get() > 5.0){
          end(false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
