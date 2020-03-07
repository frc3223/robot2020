/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class ShooterAutoDistanceLow extends CommandBase {

  private final Shooter m_shooter;
  private final DriveTrain m_driveTrain;
  private Timer time;
  private boolean timeDone;
  private boolean isDone;
  private double distance;
  /**
   * Creates a new ShooterAutoDistanceLow.
   */
  public ShooterAutoDistanceLow(Shooter shooter, DriveTrain driveTrain, double distance) {
     m_shooter = shooter;
     m_driveTrain = driveTrain;
     time = new Timer();
     timeDone = false;
     isDone = false;
     this.distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if((m_shooter.getNarrowDistance() >= distance - 0.1) && (m_shooter.getNarrowDistance() <= distance + 0.1)){
      //m_shooter.shooterMotorShootOut();
      isDone = true;
      end(false);
      //Find out how to set shooter motor to shoot for 5ish seconds
    }
    else if(m_shooter.getNarrowDistance() > distance + 0.1){
      m_driveTrain.moveForward();
    }
    else if(m_shooter.getNarrowDistance() < distance - 0.1){
      m_driveTrain.moveBackward();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
