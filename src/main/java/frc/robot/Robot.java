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
// does not exist --import edu.wpi.first.wpilibj.buttons.Button;

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
  private Command m_colorWheelLeftCommand;
  private Command m_colorWheelRightCommand;
  private Command m_colorWheelExtendCommand;
  private Command m_colorWheelRetractCommand;

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
    m_robotContainer = new RobotContainer();
    driverController = new Joystick(Constants.DRIVER_CONTROLLER);
    manipulatorController = new Joystick(Constants.MANIPULATOR_CONTROLLER);

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
    m_teleopCommand = m_robotContainer.getDriveArcade();
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
    m_colorWheelLeftCommand = m_robotContainer.getColorLeft();
    m_colorWheelRightCommand = m_robotContainer.getColorRight();
    m_colorWheelExtendCommand = m_robotContainer.getColorExtend();
    m_colorWheelRetractCommand = m_robotContainer.getColorRetract();
    
  }
  @Override
  public void teleopPeriodic(){
  /*  if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_CLIMBER_ARM_DOWN)){
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
    
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_INTAKE_IN)){
      m_intakeRaiseCommand.schedule();
      System.out.println("Intake In,pneumatics, the X button was pushed");
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_INTAKE_OUT)){
      m_intakeLowerCommand.schedule();
      System.out.println("Intake Out,pneumatics, the B button was pushed");
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_INTAKE_SHOOT_OUT) && !m_intakeShootOutCommand.isScheduled()){
      m_intakeShootOutCommand.schedule();
    }
    if(driverController.getRawButton(Constants.DRIVER_CONTROLLER_INTAKE_PULL_IN) && !m_intakePullInCommand.isScheduled()){
      m_intakePullInCommand.schedule();
    }
    */
    if(driverController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_LEFT)>= 0.05){
      m_colorWheelLeftCommand.schedule();
      System.out.println("Left trigger pressed, Color Wheel turning Left");
    }
    if(driverController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT)>= 0.05){
      m_colorWheelRightCommand.schedule();
      System.out.println("Right trigger pressed, Color Wheel turning Right");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_EXTEND)) {
      m_colorWheelExtendCommand.schedule();
      System.out.println(" left manipulator button pressed, extending color wheel");
    }
    if(manipulatorController.getRawButton(Constants.MANIPULATOR_CONTROLLER_COLORWHEEL_RETRACT)) {
      m_colorWheelRetractCommand.schedule();
      System.out.println("right manipulator button pressed, retracting color wheel");
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
