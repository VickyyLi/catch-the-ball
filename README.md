# catch-the-ball
## java body sensing game

In this project, I developed a body sensing game, called catch the ball. To get the scores, you should try to catch balls as much as possible by moving your head before the "Timer" reaches 30. The user interface is implemented by Java Swing. The program use multithreading technique to control the position detection by face++\cite{faceplus}, the image taken by webcam and the ball falling in the JFrame. Since the API has a concurrency limit for free users, so the detection of the position has latency. The game has a database connectivity, so you can see the ID and scores of three top. The game is tested via JUnit. (Actually, the database is out of date, I will update the code when I have a new database.)

![Screenshot of the game:](https://github.com/VickyyLi/catch-the-ball/blob/master/user_interface.png)

***Privacy Policy Reminder:***
The camera of your laptop will be used to detect your head position, so please make sure your camera is available and is allowed to be called by the program. The latest image will be stored at the "java project\camera pics", and won't be automatically deleted after the game.

If you want to know more details about the game, please reder to [introduction video](https://github.com/VickyyLi/catch-the-ball/blob/master/intro_video.mp4) and [report](https://github.com/VickyyLi/catch-the-ball/blob/master/report.pdf)
