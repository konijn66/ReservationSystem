# ReservationSystem
This is a program to manage reservations for a restaurant. The code takes in user input to allow the user, under a name, to add reservations for a specific time and number of 
people. The program can also sort reservations based on when they were made, and display the sorted list. People can continue adding reservations and completing the code's
various functions as long as they like, or can exit by pressing 5.

Bonus: Users can cancel their reservation by inputting the name their reservation is under, and pressing a key to confirm. Users can also change either the time that their 
reservation is for, or the number of people for the reservation. Another key function of the system is the restaurant's capacity. If a person tries to add a reservation that
would cause more people to be in the restaurant than seats for those people (set to 16 in this code), their reservation is not made, and they are told to return and add fewer
people. This was difficult to implement, but I felt that it was one of the most essential features of a reservation system, because realistically, every restaurant has a 
maximum number of people it can seat, and the point of making a reservation is to ensure that you will have a seat. Therefore, having this system to show that the restaurant
will already be full is very useful.
