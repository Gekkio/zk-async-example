zk-async-example (with asynchronous server push)
=================

## Introduction

This is a sample project that shows one way of implementing asynchronous background processing with ZK server push.

## Running the example

*Do you want to test the normal version instead? Switch to master branch (select master from "Current branch:" at top right section of this page)*

# 1. Get the project

Either clone the repository
`git clone git://github.com/Gekkio/zk-async-example.git`

and use the async branch
`git checkout async`

or download a ZIP by using the ZIP button above and unzip that.

# 2. (Install Maven 3)
# 3. Start the application and open it in a browser

* `mvn jetty:run`
* Go to [http://localhost:8080/](http://localhost:8080/).

## Experimenting with thread starvation

You can test server push thread starvation by uncommenting the relevant section in pom.xml.
This will force Jetty to use only 3 threads and you'll quickly see if any of those threads are blocked.
