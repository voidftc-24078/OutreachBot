package org.firstinspires.ftc.teamcode

import com.arcrobotics.ftclib.hardware.motors.CRServo
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive
import java.util.Arrays

class Robot(
    val telemetry: Telemetry,
    val hwMap: HardwareMap
) {
    lateinit var fl: DcMotorEx
    lateinit var fr: DcMotorEx
    lateinit var bl: DcMotorEx
    lateinit var br: DcMotorEx

    lateinit var slide: DcMotorEx

    lateinit var motors: List<DcMotorEx>

    // subsystems
    lateinit var drive: MecanumDrive

    fun init() {
        instance = this

        telemetry.msTransmissionInterval = 100

        fl = motor("fl")
        fr = motor("fr")
        bl = motor("bl")
        br = motor("br")

        fr.direction = DcMotorSimple.Direction.REVERSE
        br.direction = DcMotorSimple.Direction.REVERSE

        motors = Arrays.asList<DcMotorEx>(fl, bl, br, fr)

        for (motor in motors) {
            val motorConfigurationType = motor.motorType.clone()
            motorConfigurationType.achieveableMaxRPMFraction = 1.0
            motor.motorType = motorConfigurationType
            motor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        }

        // subsystems
        drive = MecanumDrive(fl,fr,bl,br)
    }

    fun update() {

    }

    fun motor(name: String): DcMotorEx = hwMap.get(DcMotorEx::class.java, name)
    fun servo(name: String): Servo = hwMap.get(Servo::class.java, name)
    fun crservo(name: String): CRServo = hwMap.get(CRServo::class.java, name)

    companion object {
        lateinit var instance: Robot
            private set
    }
}