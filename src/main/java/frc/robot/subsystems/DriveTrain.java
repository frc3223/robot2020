/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveTrain extends SubsystemBase {
  /*
   * Creates a new DriveTrain.
   */
  DifferentialDrive differentialDrive = null;
  CANSparkMax rightFrontMotor = null;
  CANSparkMax leftFrontMotor = null;
  CANSparkMax rightBackMotor = null;
  CANSparkMax leftBackMotor = null;

  public DriveTrain() {
    this.rightBackMotor = new CANSparkMax(Constants.DRIVETRAIN_RIGHT_BACK_SPARK, MotorType.kBrushless);
    this.leftBackMotor = new CANSparkMax(Constants.DRIVETRAIN_LEFT_BACK_SPARK, MotorType.kBrushless);
    this.rightFrontMotor = new CANSparkMax(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK, MotorType.kBrushless);
    this.leftFrontMotor = new CANSparkMax(Constants.DRIVETRAIN_LEFT_FRONT_SPARK, MotorType.kBrushless);

    MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
    MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontMotor, leftBackMotor);

    this.differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }
  

public void arcadeDrive(double moveSpeed, double rotateSpeed){
  differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
}

public void tankDrive(double leftSpeed, double rightSpeed){
  differentialDrive.tankDrive(leftSpeed, rightSpeed);
}

public void moveLeft() {
  tankDrive(-0.75, 0.75);
}

public void moveRight() {
  tankDrive(0.75, -0.75);
}

public void moveForward() {
  tankDrive(0.5, 0.5);
}

public void stop() {
  tankDrive(0, 0);
}
public void moveBackward() {
  tankDrive(-0.5, -0.5);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
