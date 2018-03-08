# SPRING DATA FLOW POC with Logback Configuration - Procedure to start and run

1. Clone this repository

2. Open two terminal windows and goto folder POC_DataFlow in both of them

3. Import the three projects Source, Processor, Sync into Idea

4. Build three projects using Idea and make jars with below command, make a not of generated JAR locations, you need them when registering in dataflow shell
    mvn clean install

5. Start the Dataflow Server
    java -jar spring-cloud-dataflow-server-local-1.1.0.RELEASE.jar

6. Once the server is started, start the dataflow shell in second window
    java -jar spring-cloud-dataflow-shell-1.1.0.RELEASE.jar

data flow shell should open

dataflow> 

7. In dataflow shell run the below commands, you need to change the path to match local environment.

dataflow> 
app register --name file-source --type source --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/FileSource/Filesource/target/FileSource-0.0.1-SNAPSHOT.jar

dataflow> 
app register --name file-processor --type processor --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/ProcessorDemo/FileProcessor/target/FileProcessor-0.0.1-SNAPSHOT.jar

dataflow> 
app register --name file-sink --type sink --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/SincDemo/FileSinkModule/target/FileSinkModule-0.0.1-SNAPSHOT.jar 

8. Now create a stream and deploy

dataflow> 
stream create --name file-to-log --definition 'file-source | file-processor | file-sink'

dataflow> 
stream deploy --name file-to-log

9. Go to Data flow server dashboard, verify that all these components are deployed and stream is created and deployed

http://localhost:9393/dashboard/index.html

10. Lookup the location of logs by clicking on Runtime tab and then by clicking on processor application. You should see a location at the bottom like below

working.dir

/var/folders/zc/bknrmrnx57s17ccr5d4nwnsjxjf_q2/T/spring-cloud-dataflow-4406891338833267588/time-to-log-1520521163838/time-to-log.time-processor

You will find the logs with name datastream.log which will rollover once it reaches 10MB size




