// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.EncoderPasta;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class MooveDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final EncoderPasta encoderPasta;
  private final double distance;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MooveDistance(EncoderPasta encoderPasta, double distance) {
    this.encoderPasta = encoderPasta;
    this.distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(encoderPasta);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting joystick drive command");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double apple = encoderPasta.getEncoder();
    if(apple > distance){
        encoderPasta.speed(-0.5);
    }
    else if(apple < distance){
        encoderPasta.speed(0.5);
    }  
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    encoderPasta.speed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(encoderPasta.getEncoder() - distance) < 0.15;
  }
}
