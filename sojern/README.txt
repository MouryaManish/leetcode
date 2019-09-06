Author Manish
Email ID:manish.r.mourya@gmail.com
**For any queries please contact****



I have completed first three questions.

1. TopN.java has comments on my approach and runtime evaluation.RunTime average case : (n + n*Log(n)),scanning + building tree.
2. Versions.java has commments on my appoarch
3. I have Spring Boot Framework and maven to build the math.api. API file is the complete list of directories.

*********files to look at inside Api folder***********
Api/src/main/java/math: Application.java,  MainController.java
Api/src/main/java/math/modal: DataAccessories.java, Data.java
Api/src/main/java/math/Exception: GlobalException.java


*************** Function of the files******************
MainController.java : The main file where I process the Rest api calls.
Data.java :  This class was made for data binding & validation and raise an exception on the way. Due to this I am able to keep track url errors.
It helps me to give precise error reporting. Error is then logged.


*******************************How to run TopN.java and Versions.Java*********************
1. Java version >= 8
2. Compile by:  javac TopN.java,javac Version.java .
3. Keep the test file with in the source directory, recommended. 
4. run by: java TopN {file path} {Nuber N} , java Versions {version 1} {version 2}.
 



**************************How to Run and test math-0.1.0.jar******************
1. we need Java to be function on the system. Java version >= 8 is recommended.The application domain is http://www.localhost:8080/.
 The API's Example: 
	http://localhost:8080/min?list=1,2,3&q=2
http://localhost:8080/max?list=1,2,3&q=2
http://localhost:8080/median?list=1,2,3
http://localhost:8080/avg?list=1,2,3
http://localhost:8080/percentile?list=1,2,3&q=50

2. Run following command on the terminal (java -jar math-0.1.0.jar). It has all the necessary file packed in it.
3. Once the server is up and running. you can use chrome browser (as it displays any error, nicely). you can also run curl on the treminal to request
the server, try: curl -s "Accept: application/json" "http://localhost:8080/#?list=*&q=*". where * is your input for list and quantifier,#is the api.
eg: curl -s "Accept: application/json" "http://localhost:8080/min?list=1,2,3&q=2"
curl -s "Accept: application/json" "http://localhost:8080/mean?list=1,2,3"

