# JenkinsTest
Tests Jenkins site using following components:

**Cucumber** - a tool for running automated acceptance tests written in a BDD style.
Cucumber allows the execution of feature files written in plain text. Each Feature is made of a collection of scenarios.
Feature files are located in the folder `<project folder>src\test\resources`.
A single scenario is a flow of events through the Feature being described.
While executinf a Steps in a Scenarios from feature file Cucumber looks for a matching Step Definition to execute.
A Step Definition is a code with a pattern attached to it. The pattern is used to link the step definition to all
the matching Steps, and the code is what Cucumber will execute when it sees a Gherkin Step.

**Selenium Web Driver** - translates Java instructions into actual browser interactions.

**JUnit** - used as the main entry point for running the entire suite of Cucumber tests and its assertion test methods.
 
**Spring** - used for project configuration and auto-injection of classes

For running it's need to install Jenkins
https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+as+a+Windows+service
