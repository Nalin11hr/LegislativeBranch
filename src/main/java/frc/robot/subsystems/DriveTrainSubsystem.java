// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel;
//import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  Spark leftFrontMotor = new Spark(Constants.DriveTrainConstants.leftFrontPWMID);
  Spark leftBackMotor = new Spark(Constants.DriveTrainConstants.leftBackPWMID);
  Spark rightFrontMotor = new Spark(Constants.DriveTrainConstants.rightFrontPWMID);
  Spark rightBackMotor = new Spark(Constants.DriveTrainConstants.rightBackPWMID);
  // CANSparkMax leftFrontMotor = new
  // CANSparkMax(Constants.DriveTrainConstants.leftFrontCANID,
  // CANSparkMaxLowLevel.MotorType.kBrushless);
  /// CANSparkMax leftBackMotor = new
  // CANSparkMax(Constants.DriveTrainConstants.leftBackCANID,
  // CANSparkMaxLowLevel.MotorType.kBrushless);
  /// CANSparkMax rightFrontMotor = new
  // CANSparkMax(Constants.DriveTrainConstants.rightFrontCANID,
  // CANSparkMaxLowLevel.MotorType.kBrushless);
  /// CANSparkMax rightBackMotor = new
  // CANSparkMax(Constants.DriveTrainConstants.rightBackCANID,
  // CANSparkMaxLowLevel.MotorType.kBrushless);

  // RelativeEncoder leftEncoder = leftFrontMotor.getEncoder();
  // RelativeEncoder rightEncoder = rightFrontMotor.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  public DriveTrainSubsystem() {
    // leftFrontMotor.restoreFactoryDefaults();
    // rightFrontMotor.restoreFactoryDefaults();
    // leftBackMotor.restoreFactoryDefaults();
    // rightBackMotor.restoreFactoryDefaults();

    // leftEncoder.setPosition(0);
    // rightEncoder.setPosition(0);
    // rightBackMotor.follow(rightFrontMotor);
    // leftBackMotor.follow(leftBackMotor);

    rightControllerGroup.setInverted(false);
    leftControllerGroup.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
