# Data Services for the Retail Demo

## Data Services Offered (REST endpoints / verbs)

* `/tweetInfo/{userName}`


## GemFire / PCC Configuration

* Set up GemFire to run in read serialized mode
```
gfsh>configure pdx --disk-store=DEFAULT --read-serialized=true
```

* Tell GemFire to use that system CLASSPATH value:
```
gfsh>start server --name=server1 --server-port=0
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

## Credits / Acknowledgements

Thanks for Mark Secrist for furnishing the code to use as a starting point for this, as well as ongoing dialog on this topic.

