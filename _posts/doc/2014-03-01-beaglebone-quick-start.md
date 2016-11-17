---
layout: page
title:  "BeagleBone Quick Start"
categories: [doc]
---

[Overview](#overview)

[Target Platform Installation](#target-platform-installation)

[Disable Web Services](#_Disable_Web_Services)

[Support Serial Communication](#support-serial-communication)

[Development Environment
Installation](#development-environment-installation)

## Overview

This section provides Eclipse Kura quick installation procedures for the BeagleBone Black rev C and the
Kura development environment.

{% include alerts.html message="This quickstart will install the version of  Kura with the administraive web UI and netwowrk configuration support but not CAN support. For more information on this please visit https://www.eclipse.org/kura/downloads.php" %}

## Disable Web Services

BeagleBone ships with several web services enabled to assist in setting
up the device and doing example projects. If the Kura web UI is to be
used, these services must be disabled to avoid interference. To disable
the BeagleBone web services, perform the following commands:

```
    systemctl disable cloud9.service
    systemctl disable gateone.service
    systemctl disable bonescript.service
    systemctl disable bonescript.socket
    systemctl disable bonescript-autorun.service
    systemctl disable avahi-daemon.service
    systemctl disable gdm.service
    systemctl disable mpd.service
```

## Target Platform Installation

To install Kura with its dependencies on the BeagleBone, perform the
following steps:

1.  Boot the BeagleBone Black with the latest Debian image.

2.  Eclipse Kura requires Oracle Java VM or Open JDK to be installed on
    the target device.

    Verify that Java 7 or above is installed with:

    <pre>java –version</pre>

    If not, install it with:

    <pre>sudo apt-get install java</pre>

3.  Connect to the platform shell (ssh).

4.  Download the Kura package with:

    <pre>wget https://s3.amazonaws.com/kura_downloads/debian/release/1.4.0/kura_1.4.0_beaglebone_debian_installer.deb</pre>

5.  Install Kura with: 

    <pre>sudo apt-get update

    sudo dpkg -i kura_1.4.0_beaglebone_debian_installer.deb

    sudo apt-get install -f</pre>

6.  Reboot the BeagleBone Black with:

    <pre>sudo reboot</pre>

    Kura starts on the target platform after reboot.

7.  Kura setups a local web ui that is available using a browser via:
    <pre>http://&lt;device-ip&gt;</pre>

    Default **username** is:
    <pre>admin</pre>

    Default **password** is:
    <pre>admin</pre>

## Support Serial Communication

The recommended method for using serial communication on the BeagleBone
is through a USB to Serial adapter. When this adapter is plugged in, it
should appears as /dev/ttyUSB0. Verify with:
```
    dmesg | grep tty*
```
Sample output:
    [ 9.121499] usb 1-1: FTDI USB Serial Device converter now attached to ttyUSB0

and
```
    ls /dev/ttyUSB\*
```
Sample output:

    /dev/ttyUSB0

UART1 through UART5 also provide serial ports on the BeagleBone;
UART0/ttyO0 is reserved for serial console.

{% include alerts.html message="The voltage levels on the BeagleBone header pins are 3.3V. Make sure that the device connecting to the BeagleBone also uses 3.3V,
or else use a [logic level converter](https://www.sparkfun.com/products/12009). Failure to
match voltage levels could damage the BeagleBone Black, the connected device, or both." %}

To enable a UART for serial communication, perform the following step:

1.  Open **/boot/uboot/uEnv.txt** with a text editor and add the
    following:

    <pre>optargs=quiet drm.debug=7 capemgr.enable\_partno=BB-UARTX</pre>

    where, "BB-UARTX" is the desired UART number (i.e., BB-UART1, BB-UART2,
    BB-UART3, BB-UART4, BB-UART5).

2.  Save changes to **boot/uboot/uEnv.txt**.

3.  Reboot the BeagleBone.

4.  Verify that the serial port is available with:

    <pre>dmesg | grep tty*</pre>

    Sample output:
    <pre>[ 0.738547] 481aa000.serial: ttyO5 at MMIO 0x481aa000 (irq = 46) is a OMAP UART5</pre>

    and

    <pre>ls /dev/ttyO\*</pre>

    Sample output:

    <pre>/dev/ttyO0 /dev/ttyO5</pre>

## Development Environment Installation

To set up the development environment for Eclipse Kura, perform the
following steps:

1. Download and install JDK SE 7 as appropriate for your OS (if it is not already installed). For Windows and Linux users, the JDK can be
downloaded from Java SE 7 Downloads. Use the latest version of Java SE Development Kit.
2. Download and install the Eclipse IDE for Java EE Developers from the <a href="http://www.eclipse.org/downloads/" target="_blank">Eclipse download site</a>.
3.  Download the Kura user workspace archive from the <a href="https://www.eclipse.org/kura/downloads.php" target="_blank">Eclipse Kura download site</a>.
4.  Import the Kura workspace zip file into the new Eclipse project development environment.
5.  Begin developing Kura-based applications for your target platform.