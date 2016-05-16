/*
 * The Initial Developer of the content of this file is NETCONOMY.
 * All portions of the code written by NETCONOMY are property of
 * NETCONOMY. All Rights Reserved.
 *
 * NETCONOMY Software & Consulting GmbH
 * Hilmgasse 4, A-8010 Graz (Austria)
 * FN 204360 f, Landesgericht fuer ZRS Graz
 * Tel: +43 (316) 815 544
 * Fax: +43 (316) 815544-99
 * www.netconomy.net
 *
 * (c) 2015 by NETCONOMY Software & Consulting GmbH
 */

package net.netconomy.training.spring.basic;

import java.util.Queue;

/**
 * @author cprobst
 *
 */
public interface Sensor extends Queue<Measurement> {

    /**
     * A constant describing an accelerometer sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_ACCELEROMETER = 1;

    /**
     * A constant string describing an accelerometer sensor type.
     *
     * @see #TYPE_ACCELEROMETER
     */
    public static final String STRING_TYPE_ACCELEROMETER = "accelerometer";

    /**
     * A constant describing a magnetic field sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_MAGNETIC_FIELD = 2;

    /**
     * A constant string describing a magnetic field sensor type.
     *
     * @see #TYPE_MAGNETIC_FIELD
     */
    public static final String STRING_TYPE_MAGNETIC_FIELD = "magnetic_field";

    /**
     * A constant describing a gyroscope sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_GYROSCOPE = 4;

    /**
     * A constant string describing a gyroscope sensor type.
     *
     * @see #TYPE_GYROSCOPE
     */
    public static final String STRING_TYPE_GYROSCOPE = "gyroscope";

    /**
     * A constant describing a light sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_LIGHT = 5;

    /**
     * A constant string describing a light sensor type.
     *
     * @see #TYPE_LIGHT
     */
    public static final String STRING_TYPE_LIGHT = "light";

    /**
     * A constant describing a pressure sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_PRESSURE = 6;

    /**
     * A constant string describing a pressure sensor type.
     *
     * @see #TYPE_PRESSURE
     */
    public static final String STRING_TYPE_PRESSURE = "pressure";

    /**
     * A constant describing a proximity sensor type. This is a wake up sensor.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     *
     */
    public static final int TYPE_PROXIMITY = 8;

    /**
     * A constant string describing a proximity sensor type.
     *
     * @see #TYPE_PROXIMITY
     */
    public static final String STRING_TYPE_PROXIMITY = "proximity";

    /**
     * A constant describing a gravity sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_GRAVITY = 9;

    /**
     * A constant string describing a gravity sensor type.
     *
     * @see #TYPE_GRAVITY
     */
    public static final String STRING_TYPE_GRAVITY = "gravity";

    /**
     * A constant describing a linear acceleration sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_LINEAR_ACCELERATION = 10;

    /**
     * A constant string describing a linear acceleration sensor type.
     *
     * @see #TYPE_LINEAR_ACCELERATION
     */
    public static final String STRING_TYPE_LINEAR_ACCELERATION = "linear_acceleration";

    /**
     * A constant describing a rotation vector sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_ROTATION_VECTOR = 11;

    /**
     * A constant string describing a rotation vector sensor type.
     *
     * @see #TYPE_ROTATION_VECTOR
     */
    public static final String STRING_TYPE_ROTATION_VECTOR = "rotation_vector";

    /**
     * A constant describing a relative humidity sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_RELATIVE_HUMIDITY = 12;

    /**
     * A constant string describing a relative humidity sensor type
     *
     * @see #TYPE_RELATIVE_HUMIDITY
     */
    public static final String STRING_TYPE_RELATIVE_HUMIDITY = "relative_humidity";

    /**
     * A constant describing an ambient temperature sensor type.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;

    /**
     * A constant string describing an ambient temperature sensor type.
     *
     * @see #TYPE_AMBIENT_TEMPERATURE
     */
    public static final String STRING_TYPE_AMBIENT_TEMPERATURE = "ambient_temperature";

    /**
     * A constant describing an uncalibrated magnetic field sensor type.
     * <p>
     * Similar to {@link #TYPE_MAGNETIC_FIELD} but the hard iron calibration (device calibration due to distortions that
     * arise from magnetized iron, steel or permanent magnets on the device) is not considered in the given sensor
     * values. However, such hard iron bias values are returned to you separately in the result
     * {@link net.netconomy.training.spring.basic.Measurement#getValues} so you may use them for custom calibrations.
     * <p>
     * Also, no periodic calibration is performed (i.e. there are no discontinuities in the data stream while using this
     * sensor) and assumptions that the magnetic field is due to the Earth's poles is avoided, but factory calibration
     * and temperature compensation have been performed.
     * </p>
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_MAGNETIC_FIELD_UNCALIBRATED = 14;
    /**
     * A constant string describing an uncalibrated magnetic field sensor type.
     *
     * @see #TYPE_MAGNETIC_FIELD_UNCALIBRATED
     */
    public static final String STRING_TYPE_MAGNETIC_FIELD_UNCALIBRATED = "magnetic_field_uncalibrated";

    /**
     * A constant describing an uncalibrated rotation vector sensor type.
     * <p>
     * Identical to {@link #TYPE_ROTATION_VECTOR} except that it doesn't use the geomagnetic field. Therefore the Y axis
     * doesn't point north, but instead to some other reference, that reference is allowed to drift by the same order of
     * magnitude as the gyroscope drift around the Z axis.
     * <p>
     * In the ideal case, a phone rotated and returning to the same real-world orientation should report the same game
     * rotation vector (without using the earth's geomagnetic field). However, the orientation may drift somewhat over
     * time.
     * </p>
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_GAME_ROTATION_VECTOR = 15;

    /**
     * A constant string describing an uncalibrated rotation vector sensor type.
     *
     * @see #TYPE_GAME_ROTATION_VECTOR
     */
    public static final String STRING_TYPE_GAME_ROTATION_VECTOR = "game_rotation_vector";

    /**
     * A constant describing an uncalibrated gyroscope sensor type.
     * <p>
     * Similar to {@link #TYPE_GYROSCOPE} but no gyro-drift compensation has been performed to adjust the given sensor
     * values. However, such gyro-drift bias values are returned to you separately in the result
     * {@link net.netconomy.training.spring.basic.Measurement#getValues} so you may use them for custom calibrations.
     * <p>
     * Factory calibration and temperature compensation is still applied to the rate of rotation (angular speeds).
     * </p>
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_GYROSCOPE_UNCALIBRATED = 16;

    /**
     * A constant string describing an uncalibrated gyroscope sensor type.
     *
     * @see #TYPE_GYROSCOPE_UNCALIBRATED
     */
    public static final String STRING_TYPE_GYROSCOPE_UNCALIBRATED = "gyroscope_uncalibrated";

    /**
     * A constant describing a significant motion trigger sensor.
     * <p>
     * It triggers when an event occurs and then automatically disables itself. The sensor continues to operate while
     * the device is asleep and will automatically wake the device to notify when significant motion is detected. The
     * application does not need to hold any wake locks for this sensor to trigger. This is a wake up sensor.
     * <p>
     *
     */
    public static final int TYPE_SIGNIFICANT_MOTION = 17;

    /**
     * A constant string describing a significant motion trigger sensor.
     *
     * @see #TYPE_SIGNIFICANT_MOTION
     */
    public static final String STRING_TYPE_SIGNIFICANT_MOTION = "significant_motion";

    /**
     * A constant describing a step detector sensor.
     * <p>
     * A sensor of this type triggers an event each time a step is taken by the user. The only allowed value to return
     * is 1.0 and an event is generated for each step. Like with any other event, the timestamp indicates when the event
     * (here the step) occurred, this corresponds to when the foot hit the ground, generating a high variation in
     * acceleration. This sensor is only for detecting every individual step as soon as it is taken, for example to
     * perform dead reckoning. If you only need aggregate number of steps taken over a period of time, register for
     * {@link #TYPE_STEP_COUNTER} instead.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_STEP_DETECTOR = 18;

    /**
     * A constant string describing a step detector sensor.
     *
     * @see #TYPE_STEP_DETECTOR
     */
    public static final String STRING_TYPE_STEP_DETECTOR = "step_detector";

    /**
     * A constant describing a step counter sensor.
     * <p>
     * A sensor of this type returns the number of steps taken by the user since the last reboot while activated. The
     * value is returned as a float (with the fractional part set to zero) and is reset to zero only on a system reboot.
     * The timestamp of the event is set to the time when the last step for that event was taken. This sensor is
     * implemented in hardware and is expected to be low power. If you want to continuously track the number of steps
     * over a long period of time, do NOT unregister for this sensor, so that it keeps counting steps in the background
     * even when the AP is in suspend mode and report the aggregate count when the AP is awake. Application needs to
     * stay registered for this sensor because step counter does not count steps if it is not activated. This sensor is
     * ideal for fitness tracking applications.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_STEP_COUNTER = 19;

    /**
     * A constant string describing a step counter sensor.
     *
     * @see #TYPE_STEP_COUNTER
     */
    public static final String STRING_TYPE_STEP_COUNTER = "step_counter";

    /**
     * A constant describing a geo-magnetic rotation vector.
     * <p>
     * Similar to {@link #TYPE_ROTATION_VECTOR}, but using a magnetometer instead of using a gyroscope. This sensor uses
     * lower power than the other rotation vectors, because it doesn't use the gyroscope. However, it is more noisy and
     * will work best outdoors.
     * <p>
     * See {@link net.netconomy.training.spring.basic.Measurement#getValues Measurement.getValues} for more details.
     */
    public static final int TYPE_GEOMAGNETIC_ROTATION_VECTOR = 20;

    /**
     * A constant string describing a geo-magnetic rotation vector.
     *
     * @see #TYPE_GEOMAGNETIC_ROTATION_VECTOR
     */
    public static final String STRING_TYPE_GEOMAGNETIC_ROTATION_VECTOR = "geomagnetic_rotation_vector";

    /**
     * A constant describing a heart rate monitor.
     * <p>
     * The reported value is the heart rate in beats per minute.
     */
    public static final int TYPE_HEART_RATE = 21;

    /**
     * A constant string describing a heart rate monitor.
     *
     * @see #TYPE_HEART_RATE
     */
    public static final String STRING_TYPE_HEART_RATE = "heart_rate";

    /**
     * A sensor of this type generates an event each time a tilt event is detected. A tilt event is generated if the
     * direction of the 2-seconds window average gravity changed by at least 35 degrees since the activation of the
     * sensor. It is a wake up sensor.
     *
     */
    public static final int TYPE_TILT_DETECTOR = 22;

    /**
     * A constant string describing a wake up tilt detector sensor type.
     *
     */
    public static final String SENSOR_STRING_TYPE_TILT_DETECTOR = "tilt_detector";

    /**
     * A constant describing a wake gesture sensor.
     * <p>
     * Wake gesture sensors enable waking up the device based on a device specific motion.
     * <p>
     * When this sensor triggers, the device behaves as if the power button was pressed, turning the screen on. This
     * behavior (turning on the screen when this sensor triggers) might be deactivated by the user in the device
     * settings. Changes in settings do not impact the behavior of the sensor: only whether the framework turns the
     * screen on when it triggers.
     * <p>
     * The actual gesture to be detected is not specified, and can be chosen by the manufacturer of the device. This
     * sensor must be low power, as it is likely to be activated 24/7. Values of events created by this sensors should
     * not be used.
     *
     */
    public static final int TYPE_WAKE_GESTURE = 23;

    /**
     * A constant string describing a wake gesture sensor.
     *
     * @see #TYPE_WAKE_GESTURE
     */
    public static final String STRING_TYPE_WAKE_GESTURE = "wake_gesture";

    /**
     * A constant describing a wake gesture sensor.
     * <p>
     * A sensor enabling briefly turning the screen on to enable the user to glance content on screen based on a
     * specific motion. The device should turn the screen off after a few moments.
     * <p>
     * When this sensor triggers, the device turns the screen on momentarily to allow the user to glance notifications
     * or other content while the device remains locked in a non-interactive state (dozing). This behavior (briefly
     * turning on the screen when this sensor triggers) might be deactivated by the user in the device settings. Changes
     * in settings do not impact the behavior of the sensor: only whether the framework briefly turns the screen on when
     * it triggers.
     * <p>
     * The actual gesture to be detected is not specified, and can be chosen by the manufacturer of the device. This
     * sensor must be low power, as it is likely to be activated 24/7. Values of events created by this sensors should
     * not be used.
     *
     */
    public static final int TYPE_GLANCE_GESTURE = 24;

    /**
     * A constant string describing a wake gesture sensor.
     *
     * @see #TYPE_GLANCE_GESTURE
     */
    public static final String STRING_TYPE_GLANCE_GESTURE = "glance_gesture";

    /**
     * A constant describing a pick up sensor.
     *
     * A sensor of this type triggers when the device is picked up regardless of wherever it was before (desk, pocket,
     * bag). The only allowed return value is 1.0. This sensor deactivates itself immediately after it triggers.
     *
     */
    public static final int TYPE_PICK_UP_GESTURE = 25;

    /**
     * A constant string describing a pick up sensor.
     *
     * @see #TYPE_PICK_UP_GESTURE
     */
    public static final String STRING_TYPE_PICK_UP_GESTURE = "pick_up_gesture";

    /**
     *
     * @return True if sensor is active, otherwise false
     */
    boolean isActive();
    
    /**
    *
    * @param active the active boolean flag
    */
    void setActive(boolean active);

    /**
     * @return generic type of this sensor.
     */
    public int getType();

    /**
     * @return The type of this sensor as a string.
     */
    public String getStringType();
    
    /**
     * Generated sensor specific measurement data.
     */
    public void generateMeasurement();
    
    Queue<Measurement> getMeasurements();

}
