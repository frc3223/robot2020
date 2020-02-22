/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ShooterLower;
import frc.robot.commands.IntakeLower;
import frc.robot.commands.ShooterPullIn;
import frc.robot.commands.IntakePullIn;
import frc.robot.commands.HopperPullIn;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class IntakeAuto extends ParallelCommandGroup {
  /**
   * Creates a new IntakeAuto.
   */
  public IntakeAuto(ShooterLower shooterLower, IntakeLower intakeLower, 
  ShooterPullIn shooterPullIn, IntakePullIn intakePullIn, HopperPullIn hopperPullIn) {
    addCommands(
      shooterLower,intakeLower,shooterPullIn,intakePullIn,hopperPullIn);
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
