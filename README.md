# Mips-WebApplication 

## This was a project on a school subject: Microprocessor systems

There are 2 relevant repositories:
1. Mips-WebApplication(this one) - which has web application code which basicly logs the sensor data and shows it in the application
2. Mips-BoardCode - which has board code (Mikro C mostly)

In the other repo we have Meteo Station which measures temperature, humidity, pressure and send all that data via SIM module to this simple web application.

**Link to the repository of the code which is on the board: <a href="https://github.com/xlstefan/Mips-BoardCode"> Mips-BoardCode </a>**

We built a mobile hydro meteorological station which had following components:
- Board used (Clicker 2 STM32 from MikroElektronika)
- GSM module for communication with the Apache Tomcat server
- Temperature sensor (DS18B20)
- Pressure sensor (BMP280)
- Humidity sensor (DHT11)
- Ultrasonic device (HCSR04)
- Solar powered battery

Device logged all the sensor data and sent it over GSM network to the Raspberry Pi connected on my local network at home (with port forwarding) and stored all the data in MySQL database.

We also built simple web application which was deployed on Raspberry Pi 2.
- SQL: MySQL server
- Application server: Apache Tomcat
- JSF application with simple dashboard and insight on all the details from the sensors
