package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;


@Autonomous (name="Pushbot:FouasdndationL", group="FounasdfdationL")



public class FoundationBlue  extends LinearOpMode {
   private  HardwareMap hwMap ;
   private DcMotor leftFront= null;
   private DcMotor leftRear = null;
   private DcMotor rightFront = null;
   private DcMotor rightRear = null;
   private Servo vacuum1= null;
   private Servo vacuum2=null;
   private DcMotor lift= null;

   private Servo grip1= null;

   private Servo lHook=null;
   CRServo tapeM=null;
   private Servo rHook= null;
   private Servo flip=null;

   @Override


   public void runOpMode() throws InterruptedException {
       hwMap = hardwareMap;
       // Below is the device declaration of motors, sensors and sensors
       // This is neccessary for the robot phones as it uses the "deviceName" to
       // detect which specific motor need to move at that time

       leftFront = hardwareMap.get(DcMotor.class, "leftFront_drive");
       rightRear = hardwareMap.get(DcMotor.class, "rightRear_drive");
       leftRear = hardwareMap.get(DcMotor.class, "leftRear_drive");
       rightFront = hardwareMap.get(DcMotor.class, "rightFront_drive");

       vacuum1=hardwareMap.get(Servo.class, "vacuum1_Servo");
       vacuum2= hardwareMap.get(Servo.class, "vacuum2_Servo");
       lift= hardwareMap.get(DcMotor.class, "liftMotor");

       //grip1=hardwareMap.get(Servo.class, "grip1Servo");
       // grip2=hardwareMap.get(Servo.class,"grip2Servo");
       lHook=hardwareMap.get(Servo.class,"lHookServo");
       rHook=hardwareMap.get(Servo.class, "rHookServo");
       tapeM=hardwareMap.get(CRServo.class, "tapeMServo");
       flip=hardwareMap.get(Servo.class, "flipServo");

       leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
       rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
       leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
       rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
       // Sets the direction for the four whee
       waitForStart();
       strafeRight(-0.5,0.5,0.5,-0.5, 1000);

       stop(500);

       backward(0.75,1900);

       // strafeLeft(-0.25,0.25,0.25,-0.25, 800);

       rHook.setPosition(0.2);  // hook onto the foundation
       stop(1900);
       lHook.setPosition(1.0);
       stop (1900);

       forward(-0.75,2350); //1750 initially // bring the foundation into the triangle
       //2200
       stop(1000);

       rHook.setPosition(1.0);
       lHook.setPosition(0.5);

       backward(0.2, 300);

       stop( 1000);


       strafeLeft(0.5,-0.5,-0.5,0.5, 4850);

   }
   public void move(double lwheel, double lrwheel, double rwheel, double rrwheel, long time)
   {
       leftFront.setPower(lwheel);
       leftRear.setPower(lrwheel);
       rightFront.setPower(rwheel);
       rightRear.setPower(rrwheel);
       sleep(time);
   }

   public void forward(double power, long time)
   {
       move(power, power, power, power, time);
   }

   public void backward ( double power, long time)
   {

       move(power, power, power, power, time);


   }

   public void left ( double power1, double power2, double power3, double power4, long time)
   {
       move(power1, power2, power3, power4, time);
   }

   public void right ( double power1, double power2, double power3, double power4, long time)
   {
       move(power1, power2, power3, power4, time);
   }

   public void strafeRight ( double power1, double power2, double power3, double power4,
                             long time)
   {
       move(power1, power2, power3, power4, time);
   }

   public void strafeLeft ( double power1, double power2, double power3, double power4,
                            long time)
   {

       move(power1, power2, power3, power4, time);
   }

   public void stop ( long time)
   {
       move(0, 0, 0, 0, time);
   }

}

