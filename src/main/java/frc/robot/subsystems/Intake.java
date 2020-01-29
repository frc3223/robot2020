/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.RobotContainer;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  CANSparkMax intakeMotor = null;
  Solenoid intakePiston = null;

  public Intake() {
      intakeMotor = new CANSparkMax(Constants.MANIPULATOR_CONTROLLER_INTAKE_CONTROLLER, MotorType.kBrushless);
      intakePiston = new Solenoid(Constants.INTAKE_SOLENOID);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
