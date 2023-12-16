// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EncoderPasta extends SubsystemBase {
    private CANSparkMax omNomNom;
    private RelativeEncoder appleSauce;
    public EncoderPasta(){
        omNomNom = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
        appleSauce = omNomNom.getEncoder();
        appleSauce.setPositionConversionFactor(1.0);
        appleSauce.setPosition(0.0);
    }
    public void speed(double speed){
        omNomNom.set(speed);
    }
    public double getEncoder(){
        return appleSauce.getPosition();
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
