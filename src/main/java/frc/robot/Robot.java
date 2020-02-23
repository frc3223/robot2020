/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;
import frc.robot.Constants;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_teleopDriveCommand;

  private Command m_climbArmUpCommand;
  private Command m_climbArmDownCommand;
  private Command m_climbWinchUpCommand;
  private Command m_climbWinchDownCommand;

  private Command m_intakeAutoCommand;

 /* private Command m_colorWheelLeftCommand;
  private Command m_colorWheelRightCommand;
  private Command m_colorWheelRaiseCommand;
  private Command m_colorWheelLowerCommand;
  private Command m_colorAutoCommand; */

  private Command m_driveDistance;

  private SequentialCommandGroup m_shooterSupreme_High;
  private SequentialCommandGroup m_shooterSupreme_Low;

  NetworkTable table;
  NetworkTable deb;
  NetworkTableEntry position;

  public static RobotContainer m_robotContainer = null;

  public Joystick driverController;
  public Joystick manipulatorController;
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    
    driverController = new Joystick(Constants.DRIVER_CONTROLLER);
    manipulatorController = new Joystick(Constants.MANIPULATOR_CONTROLLER);
    m_robotContainer = new RobotContainer(driverController, manipulatorController);
    
    table = NetworkTableInstance.getDefault().getTable("SmartDashboard");
    deb = table.getSubTable("DB");
    
    System.out.println("Robot is now online.");

    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    System.out.println("Robot is now offline.");
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    System.out.println("Robot is now autonomous.");

    m_driveDistance = m_robotContainer.getDriveDistance();
    m_shooterSupreme_High = m_robotContainer.getHighShooterSupreme();

    NetworkTableEntry position = deb.getEntry("String 0");
    String autoPosition = position.getString("pos3");

    if(autoPosition.contains("1")){
      m_shooterSupreme_High.schedule();
    }else if(autoPosition.contains("2")){
      m_driveDistance.schedule();
    }else{
      m_driveDistance.schedule();
    }
     
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
     System.out.println("Robot is now teleop.");
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if(m_driveDistance != null){
      m_driveDistance.cancel();
    }
    if(m_shooterSupreme_High != null){
      m_shooterSupreme_High.cancel();
    }
    //m_teleopDriveCommand = m_robotContainer.getDriveTank();
    m_teleopDriveCommand = m_robotContainer.getDriveArcade();
    if (m_teleopDriveCommand != null) {
      m_teleopDriveCommand.schedule();
    }

    m_climbArmUpCommand = m_robotContainer.getClimbArmUp();
    m_climbArmDownCommand = m_robotContainer.getClimbArmDown();
    m_climbWinchUpCommand = m_robotContainer.getClimbWinchUp();
    m_climbWinchDownCommand = m_robotContainer.getClimbWinchDown();

    m_intakeAutoCommand = m_robotContainer.getIntakeAutoLower();

   /* m_colorWheelLeftCommand = m_robotContainer.getColorLeft();
    m_colorWheelRightCommand = m_robotContainer.getColorRight();
    m_colorWheelRaiseCommand = m_robotContainer.getColorRaise();
    m_colorWheelLowerCommand = m_robotContainer.getColorLower();
    m_colorAutoCommand = m_robotContainer.getColorAuto(); */

    m_shooterSupreme_High = m_robotContainer.getHighShooterSupreme();
    m_shooterSupreme_Low = m_robotContainer.getLowShooterSupreme();
  
  }
  @Override
  public void teleopPeriodic(){

    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_ARM_DOWN)){
      m_climbArmDownCommand.schedule();
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_ARM_UP)){
      m_climbArmUpCommand.schedule();
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_WINCH_DOWN)){
      m_climbWinchDownCommand.schedule();
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_WINCH_UP)){
      m_climbWinchUpCommand.schedule();
    }
     // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MANIPULATOR CONTROLLER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER)){
      System.out.println("Right bumper was pressed, intake should be happening");
      m_intakeAutoCommand.schedule(); // Right bumper
    }
    
    /*Colorwheel commands that should be put back in if implemented

    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_LOWER)) {
      m_colorWheelLowerCommand.schedule(); // back button right
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_RAISE)) {
      m_colorWheelRaiseCommand.schedule(); // back button left
    } 
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_AUTO_SPIN)) {
      m_colorAutoCommand.schedule(); // start button
    }
    */
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_HIGH_AUTO)){
      m_shooterSupreme_High.schedule(); // X button
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_LOW_AUTO)){
     m_shooterSupreme_Low.schedule(); //A button
    }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
