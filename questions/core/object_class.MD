
### What are best practices to override the `equals` Method?
The equals method determines whether two objects are equal. Here are the steps to override it:

- **Signature:** The method must be public and take an Object as a parameter.
- **Check for self-comparison:** Return true if the parameter is the same object.
- **Check for null:** Return false if the parameter is null.
- **Check for type:** Return false if the parameter is not the same type.
- **Cast the parameter:** Cast the parameter to the correct type.
- **Compare significant fields:** Compare the relevant fields for equality.

```java
   @Override
    public boolean equals(Object o) {
        // Self-check
        if (this == o) return true;
        // Null check
        if (o == null || getClass() != o.getClass()) return false;
        // Typecast o to Person
        Person person = (Person) o;
        // Compare fields
        return age == person.age && Objects.equals(name, person.name);
    }
```