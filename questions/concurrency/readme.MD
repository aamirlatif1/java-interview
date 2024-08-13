## Java Concurrency

### What is use of volatile keyword?
#### Uses of the `volatile` Keyword
1. **Visibility:** The most important use of the `volatile` keyword is to ensure visibility of changes to variables across threads. When a variable is declared as volatile, the Java Memory Model ensures that any read of the variable will always return the most recent write by any thread.

2. **Atomicity for Reference Types:** For reference types and primitives (`boolean`, `int`, `long`, etc.), reads and writes to volatile variables are atomic, meaning the operation completes in a single step relative to other threads.

#### What is difference between `Thread.sleep()` and 'Object.wait()'?


#### What is use of `join()` and `notify()` methods?

[Example](../../src/main/java/com/learning/concurrency/WaitAndNotify.java) is given here.