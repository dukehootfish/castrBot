// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.motors.PIDFGains;

import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.constants.ShooterConstants;
import frc.robot.motors.DBugSparkFlex;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private DBugSparkFlex _shooter;
  private Servo _feeder;
  private Trigger _trg;
  public Shooter() {
    _shooter = DBugSparkFlex.create(ShooterConstants.baseCANID, new PIDFGains(ShooterConstants.kp, 0, 0, ShooterConstants.kfBase), 
            ShooterConstants.positionFactor, ShooterConstants.velocityFactor,0 );
    _feeder = new Servo(ShooterConstants.feederPWMchannel);
    _trg = new Trigger(() -> Math.abs(_shooter.getVelocity()-ShooterConstants.shooterVelocity) < ShooterConstants.threshold);
    
  }
  public void shoot() {
      this._shooter.setReference(ShooterConstants.shooterVelocity,ControlType.kVelocity);
  }
  public void stopShooting() {
      this._shooter.setReference(0,ControlType.kVelocity);
  }
  public void feed() {
    this._feeder.set(1.0);
  }
  public void stopFeeding() {
    this._feeder.set(0);
  }
  public Trigger getTrigger() {
    return this._trg;
  }
}
