# MassiveMotion
CS 245 Project 02<br>
Ernesto Elguezabal<br>
[Video of Implementation (Random seed was set to be the same for demonstration purposes)](https://drive.google.com/file/d/1x4rYD_kVVZLjDvz2Tu8e0Jd5IIkupvVM/view?usp=sharing)

## MassiveMotion.java
This file runs the main program. When ran, this takes in the property file as an argument.
This file handles graphics and creating and updating celestial bodies.

## CelestialBody.java
This file contains the information for a celestial body. It takes in a size, initial position, initial velocity, and color.
If no color is specified, it defaults to black. This file contains the logic for how to update a celestial body and when
to delete it.

## List.java
This file is the basic structure for ArrayList, LinkedList, DummyHeadLinkedList, and DoublyLinkedList.

## ArrayList.java
This file implements an array list. It utilizes an array whose size is increased when needed.

## LinkedList.java
This file implements a linked list. It stores elements as nodes which contain a value and a next node.
Nodes are added to the beginning of the list.

## DummyHeadLinkedList.java
This file implements a dummy head linked list. It works the same as LinkedList.java with the main difference being that
the 1st node of this linked list in null. While it would have been a better design decision to extend LinkedList.java,
for the sake of practicing writing a dummy head linked list for this class, I chose not to.

## DoublyLinkedList.java
This file implements a doubly linked list. It works similarly to LinkedList.java with the main difference being that
each node also contains a previous node. For a similar reason to DummyHeadLinkedList.java, While it may have been a better
design choice, I chose not to extend LinkedList.java.

## Future Implementations
### Gravity
A setVelocity method can easily be implemented into CelestialBody.java. We can then calculate an acceleration vector
for each celestial body, and adjust the velocity accordingly. In practice, we would subtract by the sun's velocity
vector to keep the screen centered on the sun.

### Collisions
During each update, we can keep track of which bodies collide with each other. From there, it is a simple calculation
to find the resulting velocities