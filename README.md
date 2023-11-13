
# Formulation

An online store selling computer components needed a tool for selecting and assembling a ready-made system unit. It is necessary to implement a "***Configurator***" to assemble ***computers*** from the available set of components for further transmission of orders to the sales department. The main customer requirement is the ability to select **compatible** components for selling to customers.

Building a computer is a complex and well-organized process consisting of several stages, such as selecting equipment and checking compatibility. The average buyer may not have knowledge of all the nuances of the PC assembly process, so it is necessary to ensure that the components have physical compatibility, all components have sufficient power consumption, and available buses/slots satisfy the requirements of various components before sending such an assembly to the sales department for further implementation.

Also, there are cases when a buyer simply wants to select a ready-made system and only replace a couple of components, so it is necessary to provide the possibility of launching the "configurator" based on a specific platform.

# Component Base

Mandatory components are marked with an asterisk*

## Motherboard*

This is the main board of the computer, connecting all the components of the system unit into one logical whole. Its open architecture allows you to assemble the system yourself. Any module, whether it's a processor, RAM, or graphics card, has a corresponding socket where the necessary power is supplied.

Depending on the used board and its **chipset**, restrictions on compatibility with other parts are introduced, such as the processor and RAM (slots for different bus versions have a different number of contacts on the printed circuit board).

**Attributes:**

- Processor socket
- Number of PCI-E lines soldered on the board
- Number of SATA ports soldered on the board
- Chipset (available memory frequencies, XMP support)
- Supported DDR standard
- Number of RAM slots
- Form factor
- BIOS (Type, Version)

## Processor*

CPU - this is the "brain" of the computer. It consists of several million transistors grouped into cores. Each CPU core can process a separate task, so the number of cores and clock frequency directly affect overall performance. It is important to understand that not every processor can be installed in a specific motherboard, even if the socket matches and there is a physical possibility to place the processor on the motherboard, the manufacturer/vendor may not support newer versions released for a specific platform. This check is implemented within the built-in component called BIOS. This is a set of microprograms implementing low-level APIs for working with the computer's hardware. If the processor does not support the API used by the BIOS on the motherboard, such a PC assembly option will not start.

**Attributes**:

- Core frequency
- Number of cores
- Socket
- Presence of integrated graphics
- Supported memory frequencies
- Thermal Design Power (TDP)
- Power consumption (in watts)


## BIOS

**BIOS - Basic Input/Output System.**

This component is responsible for applying settings and coordinating frequencies at which all computer components will operate.

It is known that not every processor will run on a motherboard, even if the socket is compatible. When buying a processor and a motherboard, beginners look at the chipset support and socket compatibility, which is correct but does not guarantee that such a "pairing" will start. This is because when releasing a motherboard, for example, in 2022, the manufacturer does not know about a processor released in 2023. Of course, this is resolved by adjusting the BIOS, but it is important to note that for BIOS update, the computer must be running. Therefore, it is crucial at the processor purchase stage to be sure that the BIOS supports the chosen processor model. The firmware of motherboard microprograms differs in "firmware." Therefore, at the assembly stage, it is essential to know which processors the purchased motherboard is compatible with.

**Attributes:**

- Type
- Version
- List of supported processors

## **CPU Cooling System***

The computer cooling system is a set of tools for dissipating heat from components that heat up during computer operation. These systems have specific peak values of the maximum possible heat dissipation mass. In cases where a weak cooling system is installed on a sufficiently powerful processor, malfunctions may occur. However, such an assembly option should be allowed for sale, adding a corresponding disclaimer about the waiver of warranty obligations, as the buyer may still use this system (despite violations of operating recommendations).

**Attributes:**

- Dimensions
- Supported sockets
- Maximum heat dissipation mass (TDP)

## RAM*

RAM serves as a temporary data storage for the processor needed at a specific moment. The key indicators of RAM are expressed in the **speed** of receiving/transmitting information and the volume of stored data. The higher they are, the more efficiently the CPU works. However, it should be understood that "fast" memory may work on not fully compatible motherboards at slower frequencies, but not vice versa. If there are compatibility issues, the motherboard will independently select the nearest working frequency from the available list. This is how DRAM works according to JEDEC standards. Also, a memory module has a chip with firmware installed. The manufacturer writes several profiles in the form of "frequency/timings" into it, from which the computer chooses a suitable mode for stable system operation. But maximum operating settings differ from basic standards. If JEDEC limits chip characteristics at the DDR technology level, XMP is a specific case for each model, which only the manufacturer of this kit is responsible for.

**Attributes:**

- Amount of available memory size
- Supported pairs of JEDEC frequencies and voltage
- Available XMP/DOCP(A-XMP) profiles
- Form factor
- DDR standard version
- Power consumption (in watts)

## XMP Profile

XMP is an acronym for Extreme Memory Profiles. It is a technology developed by Intel specifically for quick overclocking of RAM. AMD has a similar technology called DOCP (Direct Overclock Profile).

The profile contains characteristics that can be **applied** to a specific memory module **to modify** its characteristics and **lock** directly those **values** specified in the profile, regardless of supported JEDEC pairs.

<aside>
💡 When purchasing XMP-compatible memory, it is also necessary to have a motherboard compatible with XMP and a central processor that supports the specified speeds.

</aside>

**Attributes:**

- Timings
- Voltage
- Frequency

** - Mandatory component if specific conditions are not met.

## Graphics Card **

The graphics adapter outputs the image to the computer monitor. This device is essential in assemblies where the processor does not have an integrated graphics core because without the ability to display an image, the buyer will not be able to use the computer.

********************Attributes:********************

- Height and width of the graphics card
- Amount of video memory
- PCI-E version
- Chip frequency
- Power consumption (in watts)

## SSD Storage **

This is a solid-state storage device. The performance of an SSD is significantly higher than that of a hard drive, so it is advisable to use it for systems in the high-end segment.

********************Attributes:********************

- Connection type (PCI-E / SATA)
- Capacity in GB
- Maximum operating speed
- Power consumption (in watts)

## Hard Drive **

HDD is a data storage device. The rotation speed of the "hard drive" directly affects the user's comfort when working with the operating system. Low noise level, high fault tolerance, and an optimal price/volume ratio have defined HDD as a device for storing important information.

**Attributes:**

- Capacity in GB
- Spindle rotation speed
- Power consumption

** The assembly must contain at least one type of storage, otherwise the buyer will not be able to install the operating system.

## Case*

The system unit case serves as a place for installing the PC power supply, its working modules, motherboard, and other auxiliary components. The main property is the dimensions. It is necessary to check that the buyer's selected motherboard with the installed cooler fits inside, and the side cover can close without coming into contact with the heat pipes of the processor cooling system.

**Attributes:**

- Maximum length and width of the graphics card
- Supported form factors of motherboards
- Dimensions

## Power Supply Unit*

To some extent, the power supply unit performs functions of stabilization and protection against minor disturbances of the supply voltage. The power delivered to the PSU load depends on the power of the computer system and varies from 300 (office small form factor platforms) to a couple of thousand watts (the most high-performance workstations, servers, or powerful gaming machines). In cases where the buyer installs a power supply with insufficient power, such an assembly should be considered invalid. Also, manufacturers of components often overstate the indicators of the consumed power, so when not following the **recommended** power, it is possible to notify the buyer about this and release such an assembly to the sales department.

********************Attributes:********************

- Peak load

## Wi-Fi Adapter

Wi-Fi adapters are special devices used to connect to a wireless network. This component is optional, but when attempting to add it to a computer whose motherboard already has a built-in Wi-Fi module, such an assembly should be considered invalid due to a conflict with network equipment.

********************Attributes:********************

- Wi-Fi standard version
- Presence of a built-in Bluetooth module
- PCI-e version
- Power consumption
