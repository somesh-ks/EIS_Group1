# Injecting user behavior in webpage (Group 1)

1. The index.html is hosted on https://somesh-ks.github.io/EIS_moviestar/
2. Find the R model here https://colab.research.google.com/drive/1NqGLDokFJDLKm2H9kUopMv-9F7hrUoHn#scrollTo=dyPZo1_zKukN
3. The java code is in the directory **MoviestarSubmitTest**

## Instructions to run the code

1. Setup your java environment by downloading all the dependent jar files
2. And, run the SubmitTest.java on your favorite IDE
3. You will see a chrome browser being automated to enter emails with different time delays

## Additional information

1. The driver folder inside the MoviestarSubmitTest contains the chrome driver for version 90
2. The files folder inside the MoviestarSubmitTest contains the text files with the different time values generated via R-script (normal distribution)

---------------------------------------------

# Instrumentation of webpage (Group 1)

--USE FIREFOX BROWSER--

Here are the parameters that we collect from each user session,
* email: Email address
* joined: Whether the user has signed up or not
* time_to_join: Time taken (miliseconds) to signup (click the signup button)
* variation: Which variation was used by the user
* visits: How many times did the user visit this website?

Details about the files,
1. Moviestar.html: This file randomly displays either variation 1 or 2 to the user. Thus, fully automated
2. Moviestar - Variation 1.html: This file displays the first variation of the design (Text button)
3. Moviestar - Variation 2.html: This file displays the second variation of the design (Graphical button)

## Technical environment
No special packages or tools has to be installed. Download the file and you can get started with your default browser.

