To Solve this question first I user Okhttp library to fetch the data.
then I used Gson to fill the data object with json data. I created separate class based on 
Json data.
Okhttp must be call using enqueue rather than execute since in the main thread there are some restiriction.
I update the textview as well but i had to be executed in uniThread block for the same reason explained above.

