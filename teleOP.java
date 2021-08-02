// For Dominions TeleOP code, we used if and else statements. If a button is pressed,
// a motor will run. If not, nothing will happen
package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.CRServo;


@TeleOp(name="Skystone", group="SkystoneF")
//@Disabled
@SuppressWarnings("FieldCanBeLocal")

public class TeleOP extends LinearOpMode  { // class declaration
   // Below is the list of declard motors, servors, sensors, and 1 variable
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
   private Servo cap=null;
   double contPower;

   // Total: 8 motors, 3 sensors, 3 servors, and 1 variable

   public void runOpMode() {

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
       cap=hardwareMap.get(Servo.class, "capServo");

       leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
       rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
       leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
       rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
       // Sets the direction for the four wheels


       waitForStart();

       while (opModeIsActive()) { // The code below is essential to the movement of the robot
           // We utilited trigonometry for movement, basing off controls off the unit cirlce.
           double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
           double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
           double rightX = gamepad1.right_stick_x;
           final double v1 = r * Math.cos(robotAngle) + rightX;
           final double v2 = r * Math.sin(robotAngle) - rightX;
           final double v3 = r * Math.sin(robotAngle) + rightX;
           final double v4 = r * Math.cos(robotAngle) - rightX;

           leftFront.setPower(v1);
           rightFront.setPower(v2);
           leftRear.setPower(v3);
           rightRear.setPower(v4);
           // Setting power equal to each direction of the joystick




           if(gamepad1.dpad_up)//pressed "down" on the dpad, the motor lift will go down.
           {
               lift.setPower(-1.0);

           }

           else {
              lift.setPower(0.0);
           }

           if(gamepad1.dpad_down)//pressed "down" on the dpad, the motor lift will go down.
           {
                lift.setPower(1.0);

           }

           else {
               lift.setPower(0.0);
           }

           if(gamepad1.dpad_right)// if we press the right button on the dpad, the hook will grab onto the foundation
           {
               rHook.setPosition(0.2); //0.0
               lHook.setPosition(1.0); //1.0

           }


           else
           {
               rHook.setPosition(1.0);
               lHook.setPosition(0.5);

           }

           if(gamepad1.right_bumper)
           {

               vacuum1.setPosition(-180);
           }

           else
           {

               vacuum1.setPosition(0.5);
           }

           if (gamepad1.right_bumper)
           {
               vacuum2.setPosition(180);
           }
           else {
               vacuum2.setPosition(0.5);
           }

          if (gamepad1.x)
          {
              contPower= 0.2;
          }
          else if (gamepad1.y)
          {
              contPower=-0.2;
          }
          else
          {
              contPower=0.0;
          }
          tapeM.setPower(contPower);

           if (gamepad1.left_bumper)
           {
               flip.setPosition(0.0);
           }
           else
           {
               flip.setPosition(0.5);
           }
           if (gamepad1.right_trigger>=0.1)
           {
               cap.setPosition(1.0);
           }
           else
           {
               cap.setPosition(0.0);
           }
           /*
           if (gamepad1.b)
           {
               vacuum1.setPosition(-180);
               vacuum2.setPosition(180);

           }
           else {
               vacuum1.setPosition(0.5);
               vacuum2.setPosition(0.5);
           }

           */










       }
   }
}

