# Whack A Mole 



The popular arcade redemption game Whack A Mole emulated using java. Guess the location of the moles to whack them down.

## Installation
Download and extract the .zip file. Then import the folder as a project in IntelliJ.

## Instructions

A `*` represents a mole-hole in which  a mole could be possibly hiding in. Guess the x-coordinates and y-coordinates to whack a mole down. If your guess is correct the whacked mole will be indicated by `W`.  If you run out of chances all moles in board will be revealed, the locations in which these moles were will be represented by `M`.

## Usage

 - You can easily set and change mole locations by changing and perhaps
   adding 
   
   > game1.place(`x-coordinate:`1, `y-coordinate:`2); 
   
   which creates the moles.
 - Also you can change the number of chances and  board size by altering
   numberOfAttempts and gridDimensions in
   
   > WhackAMole game1 = new WhackAMole(`numberOfAttempts:`1, `gridDimensions:`10);

#### Hope you'll enjoy whacking the moles down.

