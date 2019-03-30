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

## Build and Run (in PCF)

* Create an instance of MySQL, named `mysql`.  If you choose a different name for
the service instance, edit the `services:` value in `./manifest.yml`.
  ```
  $ cf cs p.mysql db-small mysql
  # Wait for that instance to become ready
  ```
* Build and push the app
  ```
  $ ./gradlew clean build && cf push
  ```

## Test
```
$ export URL=http://retail-data-service.apps.my-pcf.com
$ for i in ./scripts/[0-9]*.sh ; do echo "Running $i ..." && bash $i ; done
```

## Migrate Data
```
$ ./scripts/data_migrator.py http://EXISTING_APP.apps.YOURPCF.com http://NEW_APP.apps.YOURPCF.com
```
