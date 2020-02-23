/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class DriveDistance extends CommandBase {
  double distance;
  DriveTrain driveTrain;
  boolean isDone;
  Shooter shooter;
  /**
   * Creates a new DriveDistance.
   */
  public DriveDistance(double distance, DriveTrain driveTrain, Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.distance = distance;
    this.driveTrain = driveTrain;
    this.shooter = shooter;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isDone = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((shooter.getNarrowDistance() > distance - 0.1) && (shooter.getNarrowDistance() < distance + 0.1)){
      //m_shooter.shooterMotorShootOut();
      
      isDone = true;
      end(false);
      //Find out how to set shooter motor to shoot for 5ish seconds
    }
    else if(shooter.getNarrowDistance() > distance){
      driveTrain.moveForward();
    }
    else if(shooter.getNarrowDistance() < distance){
      driveTrain.moveBackward();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
