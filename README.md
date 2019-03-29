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

## Build and Run (locally)

* Start a locator
  ```
  gfsh>start locator --name=locator1
  ```

* Start a server
  ```
  gfsh>start server --name=server1 --server-port=0
  ```

* Build and start the Spring Boot app
  ```
  $ ./mvnw clean package && java -jar ./target/data-service-0.0.1-SNAPSHOT.jar
  ```

## Build and Run (in PCF)

* Build and push the app (without starting it)
  ```
  $ ./mvnw clean package
  $ cf push --no-start
  ```
* Create an instance of PCC ([reference](https://docs.pivotal.io/p-cloud-cache/1-2/developer.html#bind-service))
  ```
  cf create-service p-cloudcache small pcc-retail
  ```
* Edit your `manifest.yml` file, setting `PCC_INSTANCE_NAME` to the **name** of your service instance; e.g.
  ```
  PCC_INSTANCE_NAME: pcc-retail
  ```
  This will be picked up when you push the app and used to inject the username, password, and locator addresses.
  [Here](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/cloud/CloudFoundryVcapEnvironmentPostProcessor.html)
  is a reference on how that's accomplished.
* After that has completed (a couple of minutes), create and then access a service key for the PCC instance
  ```
  cf create-service-key pcc-retail pcc-retail-key
  cf service-key pcc-retail pcc-retail-key
  ```
* Using the `urls` value provided, access that instance using `gfsh` (here, I'm using HTTP instead of HTTPS)
  ```
  [mgoddard:bin]$ ./gfsh
      _________________________     __
     / _____/ ______/ ______/ /____/ /
    / /  __/ /___  /_____  / _____  /
   / /__/ / ____/  _____/ / /    / /
  /______/_/      /______/_/    /_/    9.3.0

  Monitor and Manage Pivotal GemFire
  gfsh>connect --use-http=true --url=http://cloudcache-89247a3d-3781-428d-99b7-b8a462be7ab5.sys.my-pcf.com/gemfire/v1
  user: cluster_operator_Au2BzlncveXJQHNGZlkiVP
  password: **********************
  Successfully connected to: GemFire Manager HTTP service @ org.apache.geode.management.internal.web.http.support.HttpRequester@117354b6
  ```
* Create the regions (as above)
* Bind this instance to your app
  ```
  cf bind-service retail-data-service pcc-retail
  ```
* Finally, start the app
  ```
  $ cf start retail-data-service
  ```
## Test
```
$ export URL=http://retail-data-service.apps.my-pcf.com
$ time for i in ./scripts/[0-9]*.sh ; do echo "Running $i ..." && bash $i ; done
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

## Ideas for Extensions

* Write new data elements into Kafka topics, say `retail_event` and `tweet_info`, then have Greenplum consume these and run analytical queries.
* Async write-behind into Google Cloud Storage
* GemFire-Greenplum connector
* GemFire WAN replication for multi-site configuration

## Credits / Acknowledgements

Thanks for Mark Secrist for furnishing the code to use as a starting point for this, as well as ongoing dialog on this topic.

