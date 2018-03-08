# POC_DataFlow

SPRING DATA FLOW POC with Logback Configuration

1. Clone the repository

2. Open two terminal windows and goto folder POC_DataFlow

3. Import the three projects Source, Processor, Sync into Idea

4. Build three projects using Idea and make jars with below command
    mvn clean install

5. Start the Dataflow Server
java -jar spring-cloud-dataflow-server-local-1.1.0.RELEASE.jar

6. Start the dataflow shell
java -jar spring-cloud-dataflow-shell-1.1.0.RELEASE.jar

data flow shell should open

dataflow> 

7. In dataflow shell run the below commands, you need to change the path to match local environment.

app register --name time-source --type source --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/FileSource/Filesource/target/FileSource-0.0.1-SNAPSHOT.jar

app register --name time-processor --type processor --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/ProcessorDemo/FileProcessor/target/FileProcessor-0.0.1-SNAPSHOT.jar

app register --name time-sink --type sink --uri file:///Users/pduddi/IdeaProjects/JEEVIProjects/POC_DataFlow/SincDemo/FileSinkModule/target/FileSinkModule-0.0.1-SNAPSHOT.jar 

8. Now create a stream and deploy
stream create --name time-to-log --definition 'time-source | time-processor | time-sink'

stream deploy --name time-to-log

9. Verify that all these components are deployed in the Data flow server dashboard


