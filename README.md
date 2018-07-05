# Data Services for the Retail Demo

## Data Services Offered (see Test, below, for examples of using these endpoints)

| Endpoint | HTTP Verb | Types (if any) |
| :---         |     :---:      | :--- |
| `/tweetInfo/{userName}` | PUT | userName: String, tweetId: Long |
| `/tweetInfo/{userName}/maxTweetId` | GET | userName: String |
| `/tweetInfo/maxTweetIds` | GET | N/A |
| `/tweetInfo/{userName}` | DELETE | userName: String |
| `/retailEvent/event` | PUT | String (JSON) |
| `/retailEvent/{tweetId}` | GET | Long |
| `/retailEvent/{screenName}/{topN}` | GET | screenName: String, topN: int |
| `/retailEvent/{tweetId}` | DELETE | tweetId: Long |

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

## Migrate Data
```
$ ./scripts/data_migrator.py http://EXISTING_APP.apps.YOURPCF.com http://NEW_APP.apps.YOURPCF.com
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

