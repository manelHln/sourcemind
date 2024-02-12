---
author: Vahe Pezeshkian
title: Java (II) - Generics
institute: Sourcemind
theme: default
---

# Run-time type checking

```java
class Shape {

}

class Circle extends Shape {

}

class Rectangle extends Shape {

}

class Square extends Rectangle {

}

List shapes = new ArrayList();
shapes.add(new Circle());
shapes.add(new Square());
shapes.add(new Circle());

Circle a = (Circle) shapes.get(0);
Square b = (Square) shapes.get(1);
Square c = (Square) shapes.get(2);
```

# Compile-time type checking

```java
List<Circle> shapes = new ArrayList<>();
shapes.add(new Circle());	// good
shapes.add(new Square());	// error
```

- Generic types
	- Container type: `List`
	- Payload type: `Circle`

# Type parameter <T>

- List<E>
- The container type (e.g. List) does not rely on exact type of **E**
- **E** can be anything, it's a placeholder
- The real type is assigned when List<E> is used by the programmer

# Diamond syntax

```java
List<String> list = new ArrayList<String>();

// right-hand side is redundant

List<String> list = new ArrayList<>();
```

# Raw types

- Prior to Java 5, generic types were not supported

```java
// raw type
List list = getOldCollectionOfStrings();

// better
List<String> better = (List<String>) list;
```

- Generics are earased after compile phase
- Why?

# Type Earasure

Won't compile:

```java
class Test {
	void print(Map<String, Shape> items) {

	}

	void print(Map<String, Circle> items) {

	}
}
// both methods have the same erasure
// void print(Map items) { ... }
```

# Generic types and their type arguments

```java
class Box<T> { ... }

Box<String> box1 = new Box<>("1");
Box<Integer> box2 = new Box<>(1);

box1 = box2;	// compile error
```

# Bounded type parameteres

```java
// rectangles and squares
class Drawing<T extends Rectangle> {
	public void draw(T shape) {

	}
}

Drawing<Square> drawing = new Drawing<>();
drawing.draw(new Square());
drawing.draw(new Circle());	// compile error

// How about this?
Drawing rawTypeDrawing = new Drawing();
rawTypeDrawing.draw(new Circle());
```

# Comparable<T> and Comparator<T>

- A sorted drawing object contains `Shape` objects that know how to compare to themselves.

- It supports any comparable shape class

```java
class SortedDrawing<T extends Comparable<Shape>> {
    public void addShape() {

    }

    public void draw() {

    }
}
```

- Still, strongly types. Cannot mix comparable square and rectangle types

# RectList<T extends Rectangle>

Which statements are correct?

```java
class RectList<T extends Rectangle> extends ArrayList<T> {

}

RectList<Rectangle> l1 = new RectList<>();
l1.add(new Rectangle());
l1.add(new Square());
l1.add(new Shape());

RectList<Square> l2 = new RectList<>();
l2.add(new Rectangle());
l2.add(new Square());
l2.add(new Shape());

RectList<Shape> l3 = new RectList<Shape>();
l3.add(new Rectangle());
l3.add(new Square());
l3.add(new Shape());
```

# Wildcards: <?>

- `new List<T>()` ?

```java
public void printData(List<T> data) { }
```

- Unknown type: `List<?>`
```java
public void printData(List<?> data) {
	Object element = data.get(0);	// OK
	// We can be sure that all elements in data can be used as Object (Why?)
    data.add(new Object());			// won't work
}
```

- `<?>` vs `<Object>`
```java
public void printData(List<Object> data) { ... }
```

# Bounded wildcards

- We don't know what kind of `Shape` will be in the list, but it must certainly be a subtype of it.
	- List<Circle> is OK
	- List<Square> is OK
	- List<String> is not OK
- Can rely on common methods of Shape to perform a task within the method

- `<? extends Shape>` use with any type that is a subclass of Shape
- `<? super Rectangle>` use with any type that is a superclass of Rectangle

# PECS: Producer Extends Consumer Super

```java

// Shape > Rectangle > Square

// When reading from a list (the list is a producer) use extends
// You guarantee that you are working with at least a Rectangle list
public void produce(List<? extends Rectangle> data) {
    Rectangle a = data.get(0);
    Shape b = data.get(1);
    
    data.add(new Rectangle());	// not allowed
}

// When adding to a list (the list is a consumer) use super
// You know then that the list can accept at least a Rectangle
public void consume(List<? super Rectangle> data) {
    data.add(new Rectangle());
    data.add(new Square());
    data.add(new Shape());

    Rectangle a = data.get(0);	// not allowed
}
```

- Use the `<? extends T>` wildcard if you need to retrieve object of type T from a collection.

- Use the `<? super T>` wildcard if you need to put objects of type T in a collection.

- If you need to satisfy both things, don’t use any wildcard.

# Generic methods

- Type parameter defined in class:

```java
class Drawing<T> {
	private List<T> myShapes;

	public T getLargestShape() {
		// ...
	}
}
```

- Type parameters can also be defined in methods:

```java
class AnyClass {
	public <T> void drawShape(T shape) { ... }

	public <T> T getShape() { ... }
}
```

- Type parameter with wildcards in method:

```java
public <T extends Shape> sortShapes(T shapes) { ... }
```

# Extending generic interfaces
```java

interface Sorter<T extends Shape> {
    void sort(List<T> shapes);
}

// Keep the generic type parameter
class GenericSorter<T extends Shape> implements Sorter<T> {

    @Override
    public void sort(List<T> shapes) {
        
    }
}

// Implement for Square only
class SquareSorter implements Sorter<Square> {

    @Override
    public void sort(List<Square> shapes) {
        
    }
}
```

# Raw types

- Generics did not exist prior to JDK 5.
- After introducing generics, it is allowed to use generic classes without type parameters: Raw types

```java
Drawing draw = new Drawing(); // no type means Object

// Collections
List list = new List();
list.add("A");
list.add(1);
list.add(new Object());
```

# Restrictions

- Cannot call constructor on a type parameter: `new T()`
- Cannot declare generic static fields and methods
- Static methods can declare their own type parameters (unrelated to the class)

```java
class Wrong<T> {
	static T obj; // Wrong
	static T getObj() { // Wrong
		return obj;
	}
	static <T, V> V getObj(T x) { ... } // OK
}
```
- Cannot declare array of generics

```java
Box<String>[] box = new Box<String>[3]; // Not allowed
```

- Reason: In Java, arrays are covariant while generics are invariant:

```java
// Covariance in arrays: Compiles but throws runtime error
String[] array = new String[3];
Object[] objects = array;
objects[0] = 1;
String str = (String) objects[0];

// Invariance in generics: This would create issues in generics
Box<String>[] array = new Box<String>[5];
Box<Object> objects = array;
objects[0] = new Box<Object>(new Object()); // Against generics idea
```

- Recommendation: Use collections with generics