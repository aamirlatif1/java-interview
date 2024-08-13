### What are bean scopes in spring framework?
1. Singleton (Default Scope)
   - Description: Only one instance of the bean is created per Spring IoC container.
   - Use Cases: Most commonly used for stateless beans. Ideal for beans that provide shared functionality (like data access objects) or where state is not a concern.
2. Prototype
   - Description: A new instance of the bean is created each time it is requested from the container.
   - Use Cases: Suitable for stateful beans where each consumer requires a new instance. Useful when each object needs to operate independently.
3. Request
   - Description: A single instance of the bean is created for each HTTP request. This scope is specific to web applications.
   - Use Cases: Useful for beans that are intended to be used within the lifecycle of an HTTP request. Ideal for managing request-specific data.
4. Session
   - Description: A single instance of the bean is created for each HTTP session. This scope is also specific to web applications.
   - Use Cases: Appropriate for beans that need to maintain user-specific state across multiple interactions during a web session, like user preferences.
5. Application
   - Description: A single instance of the bean is created for the lifecycle of a ServletContext. This is also specific to web applications.
   - Use Cases: Used for beans that need to be shared across all servlets in a web application, like application-wide configuration data.
6. WebSocket
   - Description: A single instance of the bean is created for the lifecycle of a WebSocket. This is used in applications that employ WebSocket.
   - Use Cases: Ideal for managing data in the scope of a WebSocket communication session.
7. Custom Scopes
   - Spring also allows for custom scopes, though these are less common.
#### Importance of Choosing the Right Scope
- Memory Management: Proper scope selection helps manage memory efficiently. For instance, using singleton scope unnecessarily can lead to higher memory consumption, while using prototype scope imprudently can lead to excessive object creation.
- State Management: Choosing the correct scope ensures appropriate sharing and persistence of state.
- Performance: Correct scope can impact application performance, as singleton beans are created once, while prototype beans are created on demand.
- Application Design: It affects the overall design of the application, particularly in terms of how components interact and how dependencies are managed.
