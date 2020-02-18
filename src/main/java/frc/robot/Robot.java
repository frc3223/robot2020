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


import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Command m_teleopCommand;
  private Command m_intakeLowerCommand;
  private Command m_intakeRaiseCommand;
  private Command m_climbArmUpCommand;
  private Command m_climbArmDownCommand;
  private Command m_climbWinchUpCommand;
  private Command m_climbWinchDownCommand;
  private Command m_intakeShootOutCommand;
  private Command m_intakePullInCommand;
  private Command m_intakeAutoLowerCommand;
  private Command m_colorWheelLeftCommand;
  private Command m_colorWheelRightCommand;
  private Command m_colorWheelRaiseCommand;
  private Command m_colorWheelLowerCommand;
  private Command m_colorAutoCommand;
  private Command m_shooterRaiseCommand;
  private Command m_shooterShootOutCommand;
  private Command m_shooterPullInCommand;
  private Command m_shooterLowerCommand;
  private Command m_hopperPullInCommand;
  private Command m_hopperShootOutCommand;
  private Command m_shooterLowAutoCommand;
  private Command m_shooterHighAutoCommand;
  

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
      m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
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
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    m_teleopCommand = m_robotContainer.getDriveTank();
    if (m_teleopCommand != null) {
      m_teleopCommand.schedule();
    }
    
    m_intakeLowerCommand = m_robotContainer.getIntakeLower();
    m_intakeRaiseCommand = m_robotContainer.getIntakeRaise();

    m_climbArmUpCommand = m_robotContainer.getClimbArmUp();
    m_climbArmDownCommand = m_robotContainer.getClimbArmDown();
    m_climbWinchUpCommand = m_robotContainer.getClimbWinchUp();
    m_climbWinchDownCommand = m_robotContainer.getClimbWinchDown();

    m_intakePullInCommand = m_robotContainer.getIntakePullIn();
    m_intakeShootOutCommand = m_robotContainer.getIntakeShootOut();

    m_intakeAutoLowerCommand = m_robotContainer.getIntakeAutoLower();

    m_colorWheelLeftCommand = m_robotContainer.getColorLeft();
    m_colorWheelRightCommand = m_robotContainer.getColorRight();
    m_colorWheelRaiseCommand = m_robotContainer.getColorRaise();
    m_colorWheelLowerCommand = m_robotContainer.getColorLower();
    m_colorAutoCommand = m_robotContainer.getColorAuto();

    m_shooterRaiseCommand = m_robotContainer.getShooterRaise();
    m_shooterLowerCommand = m_robotContainer.getShooterRaise();
    m_shooterShootOutCommand = m_robotContainer.getShooterShootOut();
    m_shooterPullInCommand = m_robotContainer.getShooterPullIn();
    m_shooterLowAutoCommand = m_robotContainer.getShooterLowAuto();
    m_shooterHighAutoCommand = m_robotContainer.getShooterHighAuto();
    m_hopperPullInCommand = m_robotContainer.getHopperPullIn();
    m_hopperShootOutCommand = m_robotContainer.getHopperShootOut();
    
  }
  @Override
  public void teleopPeriodic(){

  // REMEMBER TO UNCOMMENT THIS WHEN TESTING THE ENTIRE ROBOT 
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
    /*if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_RAISE)){
      m_intakeRaiseCommand.schedule();
      System.out.println("the Y button was pressed, intake raising");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_LOWER)){
      m_intakeLowerCommand.schedule();
      System.out.println("the B button was pressed, intake lowering");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_SHOOT_OUT)){
      m_intakeShootOutCommand.schedule();
      System.out.println("Right bumper was pressed, intake shooting out");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_PULL_IN)){
      m_intakePullInCommand.schedule();
      System.out.println("Left bumper was pressed, intake pulling in");
    }*/
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER)){
      m_intakeAutoLowerCommand.schedule();
    }
    
    /*if(manipulatorController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_LEFT)>= 0.05 ){
      m_colorWheelLeftCommand.schedule();
      System.out.println("Left trigger pressed, Color Wheel Left");
    }
    if(manipulatorController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT)>= 0.05 ){
      m_colorWheelRightCommand.schedule();
      System.out.println("Right trigger pressed, Color Wheel Right");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_Raise)) {
      m_colorWheelRaiseCommand.schedule();
      System.out.println("left manipulator back button pressed, Raiseing color wheel");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_Lower)) {
      m_colorWheelLowerCommand.schedule();
      System.out.println("right manipulator back button pressed, Lowering color wheel");
    }
    */
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_RAISE)) {
      m_colorWheelRaiseCommand.schedule();
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_AUTO_SPIN)) {
      m_colorAutoCommand.schedule();
    }

    /*if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_RAISE)) {
      m_shooterRaiseCommand.schedule();
      System.out.println("Shoot out(X) button pressed, shooter motor spinning out");
    }
    if(manipulatorController.getPOV() == 0){
      m_shooterShootOutCommand.schedule();
      System.out.println("Up POV pressed, should be raising the shooter");
    }
    if(manipulatorController.getPOV() == 180){
      m_shooterPullInCommand.schedule();
    System.out.println("Down POV pressed, should be lowering the shooter");
    }
    if(manipulatorController.getPOV() == 90){
      m_hopperShootOutCommand.schedule();
      System.out.println("Right POV pressed, should be shooting the hopper out");
    }
    if(manipulatorController.getPOV() == 270){
      m_hopperPullInCommand.schedule();
      System.out.println("Left POV pressed, should be pulling the hopper in");
    }
    
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_LOWER)){
      m_shooterLowerCommand.schedule();
      System.out.println("the A button was pressed, the shooter should be pulling in");
    }*/
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_HIGH_AUTO)){
      m_shooterHighAutoCommand.schedule();
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
