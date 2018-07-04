# Data Services for the Retail Demo

## GemFire / PCC Configuration

* Extract the Spring Boot JAR, and set CLASSPATH based on its contents:
```
$ ./scripts/setup_gemfire_classpath.sh
```
Run that `export CLASSPATH=...` within the shell used to start GemFire.

* Ensure your domain classes are serializable by GemFire:
```
gfsh>configure pdx --disk-store=DEFAULT --auto-serializable-classes="io.pivotal.retail.domain.*"
```

* Tell GemFire to use that system CLASSPATH value:
```
gfsh>start server --name=server1 --server-port=40411 --include-system-classpath=true
```

## Build and Run (locally)

```
./mvnw clean package && java -jar ./target/data-service-0.0.1-SNAPSHOT.jar
```

## Build and Run (in PCF)

**TODO**

## Test

```
$ time for i in ./scripts/*.sh ; do echo "Running $i ..." && bash $i ; done
```

## GemFire Queries

* Pull out the values:
```
gfsh>query --query='SELECT r.screenName, r.id, r.json FROM /RetailEvent r'
```

* Delete an item by key, making sure to specify the Java class for this key:
```
gfsh>remove --region=/RetailEvent --key=842479757170159616  --key-class=java.lang.Long
```

