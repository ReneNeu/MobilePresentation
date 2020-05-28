# Sensors in Android
by Rene Neuhaus, Thomas Wagner
## Motivation

Sensors in android are there to make your life a little easier. Most of the time those sensore are unnoticed.
The following are use cases and it's sensor usage from our daily life.

|use case  |main sensor involved  |
|--|--|
| taking a call| proximity sensor  |
| navigation system| gps sensor  |
| thermometer|ambient temperature sensor  |
|auto brightness| lightt sensor  |
| VR (Google Cardboard)| gyroscope, magnetic  sensor, orientation  |

## Sensors

Android has up to 13. Standard Sensors in one device

|Sensor |Description  |
|--|--|
|Accelerometer  |Measures the acceleration force in m/s2  |
|Ambient Temperature  |Measures the ambient room temperature in degrees Celsius (°C)  |
|Gravity  |Measures the force of gravity in m/s2 that is applied to a device on all three physical axes (x, y, z)  |
|Gyroscope  |Measures a device's rate of rotation in rad/s around each of the three physical axes (x, y, and z)  |
|Light  |Measures the ambient light level (illumination) in lx  |
|Linear Acceleration  |Measures the acceleration force in m/s2 that is applied to a device on all three physical axes (x, y, and z)  |
|Magnetic Field  |Measures the ambient geomagnetic field for all three physical axes  |
|Orientation  |Measures degrees of rotation that a device makes around all three physical axes (x, y, z)  |
|Pressure  |Measures the ambient air pressure in hPa or mbar  |
|Proximity  |Measures the proximity of an object in cm relative to the view screen of a device  |
|Relative Humidity  |Measures the relative ambient humidity in percent (%)  |
|Rotation Vector  |Measures the orientation of a device by providing the three elements of the device's rotation vector  |
|Temperature  |Measures the temperature of the device in degrees Celsius (°C)  |





## Technichal background

TODO

## Our Application

If you want to try our app you just have to go to our project in AndroidStudio Clone and go to the Main (https://github.com/ReneNeu/MobilePresentation/blob/27a8ca7d275316000234c42b41d2ac6369d3b0d8/app/src/main/java/com/example/mobileambienttemperature/MainActivity.kt). Then you have to execute it


## Summary

New sensore are not always a good thing. For example the new radar based Soli sensor in Googles Pixel 4 is not living up to it's true potential. The capability are limited by Googles implementation.
On the other hand, already implemented sensors like the proximity sensors are here to stay. 
They make our life so much easier and improve the smartphone usage in a substanial way.
Furthermore future smartphones are going to have even more sensors implemented. Just imagine the development of dual screen or folding smarphones. There could be a sensor measuring how much the smartphones opens up. This information could be use to render the display content accordingly.
"We are just at the beginning of smartphone development"
