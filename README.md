# intellij_plugin_server

Scala Spray REST server.

#### Deployment
This server is built using sbt 0.13.7
If you want to deploy it on your local machine you need to install sbt first. To do it, go to [sbt download](http://www.scala-sbt.org/download.html) and follow steps.

If you have sbt installed, just go to the root directory of this project and simply type:

```
sbt run
```
Now your server should be ready to work. It listens on 8080 port.
To check it out just visit [http://localhost:8080/fortune](http://localhost:8080/fortune).

#### API

GET /fortune - responds with one of fortune sentences (JSON response: {"msg": "sample text})
