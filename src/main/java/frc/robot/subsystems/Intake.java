/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.RobotContainer;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  CANSparkMax intakeMotor;
  DoubleSolenoid intakeSolenoid;
  

  public Intake() {
    intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
    intakeSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, Constants.INTAKE_SOLENOID_FORWARDS, Constants.INTAKE_SOLENOID_BACKWARDS);

  }
public void intakeRaise() {
   intakeSolenoid.set(DoubleSolenoid.Value.kForward);
}
public void intakeLower() {
  intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
}


public void intakeMotorShootOut() {
  intakeMotor.set(1.0);
}

public void intakeMotorPullIn() {
  intakeMotor.set(-0.5);
}

public void intakeMotorOff(){
  intakeMotor.set(0.0);
}

}
