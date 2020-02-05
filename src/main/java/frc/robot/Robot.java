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
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.Constants;
// does not exist --import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
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
  private Command m_climbUpCommand;
  private Command m_climbDownCommand;
  private Command m_intakeWheelForwardCommand;
  private Command m_intakeWheelBackwardCommand;

  public static RobotContainer m_robotContainer = null;
  public static Constants m_constants = null;

  public Joystick driverController;
  public Joystick manipulatorController;

  public ButtonType Ybutton;
  public ButtonType Abutton;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_constants = new Constants();
    driverController = new Joystick(0);
    manipulatorController = new Joystick(1);

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
    m_climbUpCommand = m_robotContainer.getClimbUp();
    m_climbDownCommand = m_robotContainer.getClimbDown();
    m_intakeWheelForwardCommand = m_robotContainer.getIntakeForward();
    m_intakeWheelBackwardCommand = m_robotContainer.getIntakeBackward();
    
  }
  @Override
  public void teleopPeriodic(){
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_CLIMBER_DOWN)){
      m_climbDownCommand.schedule();
      System.out.print("climber retracting, winch, #13, the A button was pushed");
    }
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_CLIMBER_UP)){
      m_climbUpCommand.schedule();
      System.out.print("climber extending, arm, #8, the Y button was pushed");
    }
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_INTAKE_IN)){
      m_intakeRaiseCommand.schedule();
      System.out.print("Intake In,pneumatics, the X button was pushed");
    }
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_INTAKE_OUT)){
      m_intakeLowerCommand.schedule();
      System.out.print("Intake Out,pneumatics, the B button was pushed");
    }
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_INTAKE_FORWARD)){
      m_intakeWheelForwardCommand.schedule();
      System.out.print("Intake wheels in, the left bumper was pressed");
    }
    if(driverController.getRawButton(m_constants.DRIVER_CONTROLLER_INTAKE_BACKWARD)){
      m_intakeWheelBackwardCommand.schedule();
      System.out.print("Intake wheels in, the right bumper was pressed");
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
