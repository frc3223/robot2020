/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import com.ctre.phoenix.motorcontrol.can.*;

public class Climber extends SubsystemBase {
  public WPI_VictorSPX winch;
  public WPI_VictorSPX arm;

  /**
   * Creates a new Climber.
   */
  public Climber() {
    winch = new WPI_VictorSPX(Constants.CLIMBER_WINCH_TALON);
    arm = new WPI_VictorSPX(Constants.CLIMBER_ARM_TALON);

  }

  public void armstop(){
    arm.set(0);
  }

  public void winchstop(){
    winch.set(0);
  }

  public void extend(){
    arm.set(1);
  }

  public void retract(){
    winch.set(-1);
  }
}