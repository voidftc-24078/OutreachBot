package org.firstinspires.ftc.teamcode

import com.arcrobotics.ftclib.command.CommandScheduler
import com.arcrobotics.ftclib.gamepad.GamepadEx
import com.qualcomm.robotcore.eventloop.opmode.OpMode

abstract class OpModeBase: OpMode() {
    lateinit var driver: GamepadEx
    lateinit var gunner: GamepadEx
    lateinit var commandScheduler: CommandScheduler
    lateinit var robot: Robot

    abstract fun initialize()

    override fun init() {
        robot = Robot(telemetry, hardwareMap)
        robot.init()

        driver = GamepadEx(gamepad1)
        gunner = GamepadEx(gamepad2)

        CommandScheduler.getInstance().reset()
        commandScheduler = CommandScheduler.getInstance()

        initialize()
    }

    abstract fun cycle()

    override fun loop() {
        commandScheduler.run()
        cycle()
        robot.update()
        telemetry.update()
    }
}