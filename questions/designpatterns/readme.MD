
#### What are SOLID principles?

###### Single Responsibility Principle (SRP)
- Definition: A class should have only one reason to change, meaning it should only have one job or responsibility.
- Benefit: This principle leads to a higher cohesion and lower coupling, making the system easier to understand and modify.
###### Open/Closed Principle (OCP)
- Definition: Software entities (like classes, modules, functions, etc.) should be open for extension, but closed for modification. This means you should be able to add new functionality without changing the existing code.
- Benefit: It encourages a more stable and resilient design that supports the addition of new features with minimal changes to existing code.
###### Liskov Substitution Principle (LSP)
- Definition: Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program. In other words, a subclass should override the parent class methods in a way that does not break functionality from a client’s point of view.
- Benefit: It ensures that a subclass can stand in for its superclass, leading to more robust, interchangeable components in a software system.
###### Interface Segregation Principle (ISP)
- Definition: Clients should not be forced to depend on interfaces they do not use. This principle is about splitting a set of actions into smaller interfaces.
- Benefit: It promotes finer-grained interfaces that are client-specific, reducing the side effects of changes in unrelated parts of the system and increasing cohesion.
###### Dependency Inversion Principle (DIP)
- Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details; details should depend on abstractions. This principle is about decoupling software modules.
- Benefit: It leads to more decoupled systems where high-level modules are not tightly bound to low-level modules, making the system easier to refactor, change, and deploy.
