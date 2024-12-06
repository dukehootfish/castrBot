package frc.robot.constants;

public class ShooterConstants {
    public static final int baseCANID = 1;
    public static final int feederPWMchannel = 2;

    public static final double kp = 0.01;
    public static final double kfBase = 0;

    //public static final double squareVelocity = 0; //rpm
    //ublic static final double circleVelocity = 0; //rpm
    //public static final double offVelocity = 0; //rpm
    public static final double shooterVelocity = -0.39;
    public static final double threshold = 0.05;

    
    private static final double gearRatio = 1.0;
    public static final double positionFactor = 360 * gearRatio; // deg/rotations
    public static final double velocityFactor = 360 * gearRatio / 60; // (deg/sec)/RPM


}
