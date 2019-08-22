****2/9/2019****
Limitations: This Pin Generator provides PIN numbers starting from number 1000
Tried to solve this bug to include PINs that begin with humber 0 but given the 90 min of this exercise I couldn't solve it on time.

Instructions:This readme file provides instruction on how to run the tests included on this library.

Bring up a terminal or command line, ensure that you have gradle installed

Cd into this folder location
>> cd ./PinGenerator

then on your command line run
>> gradle test

It should print out the three test cases included along with the output
you may want to redirect the output to view all valid pins.

redirect command on linux
>> gradle test > output.out


In case the output is not shown then run it with '-i' option
>> gradle test -i > output.out

or

(no redirect)
>> gradle clean test 


If you have questions please reach me at jcprimo@miners.utep.edu