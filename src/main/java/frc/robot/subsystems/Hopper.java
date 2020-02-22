/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  DoubleSolenoid hopperSolenoid;
  WPI_VictorSPX hopperMotor;
  /**
   * Creates a new Hopper.
   */
  public Hopper() {
    hopperMotor = new WPI_VictorSPX(Constants.INTAKE_MOTOR);
     
  }
  
  public void hopperShootOut(){
    hopperMotor.set(1);
  }

  public void hopperPullIn(){
    hopperMotor.set(-1);
  }

    public void hopperMotorOff(){
    hopperMotor.set(0);
  }

}
