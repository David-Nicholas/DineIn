If docker is not installed please install from this website:
https://docs.docker.com/desktop/install/mac-install/

To locally work with a database, run the following command in .zsh
Replace **/path/to/your/init.sql** with your path for init.sql located in java test folder: **src/test/java/com/ic/dinin/localmssqlsql/init.sql**
```shell
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=YourStrong!Passw0rd' -p 1433:1433 --name sqlserver -v /path/to/your/init.sql:/docker-entrypoint-initdb.d/init.sql -d mcr.microsoft.com/mssql/server:2019-latest
```

Install dbeaver to see working database using this command
```shell
brew install --cask dbeaver-community
```

Add a new connection (ctrl+shift+N) and select Sql Server
Connect using URL: ```jdbc:sqlserver://localhost:1433;databaseName=ShopApplication;encrypt=true;trustServerCertificate=true;```

And use following credentials for login:
* Username: ``sa``
* Password: ``YourStrong!Passw0rd``

Test connection and make sure everything works.
If database ShopApplication is not present please create it by right-clicking on databases and hit **create new database** with the name **ShopApplication**

Now you can run the ``DininWebAppLocalMssql`` and you would be connected to the docker image. If you want the test data seed content to be in local database, you can run the app a single time with the next configuration: 
* Change line 11 in ``TestDataSeed.java`` in 
```java
@Profile({SpringProfiles.TEST_DATA_SEED, SpringProfiles.LOCAL_MS_SQL})
```
after this remove the line and you should have data in the docker image database, now you can run the application normally