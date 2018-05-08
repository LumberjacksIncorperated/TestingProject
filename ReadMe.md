# Chain Testing Project


This project exists as an implementation in the Java programming language of the chain testing principle


### The 'Chain Testing' Principle

```
The 'Chain Testing' principle is about having a testing framework in place such that you can continously
check that changes you make to code do not interefere with the functionality
```


### Explanation

```
The way in which we implement this testing framework is by monitoring function calls made and the arguements they were made with.

Testing for a class involves checking that the tested monitored calls contains the expected monitored calls. What this
means is that you can run tests after each change to a class to make sure that it does not affect expected functionality within the rest of the system.

The idea is that you can safely make changes to class code with the knowledge that you are not breaking functionality,
simply, and easily, with straightforward testing in place that is fast to run, with the intention that such testing is performed often for maximum confidence in the system when making changes to class code.

```


## Authors

Lumberjacks Incorperated (2018)
