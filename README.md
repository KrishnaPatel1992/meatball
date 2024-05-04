# Meatball

## 1.0) Introduction

In Object Oriented Programming, one typically defines a class with data (e.g. global variables) and application logic (e.g. methods). But in Pure Functional Programming, there is a separation of concerns between data and application logic. In particular, one typically writes application logic by defining stateless functions and composing them into functional streams; data is processed when it passes through the stream i.e. the output of one function in the stream is passed as input to the next function in the stream.

This library seeks to empower developers to write Java code using the Pure Functional Programming paradigm. In particular, this library introduces a new data type called Meatball. Fundamentally, Meatball is an immutable `Map<String, Object>`. Since Meatball is a `Map<String, Object>`, it is flexible enough to model the state of any object; the intention is for developers to use instances of Meatball to store data, instead of using objects. For example, in Object Oriented Programming, one might define a Customer class which has global variables like `forename`, `surname`,  and `age`; instead of defining such a class, developers should create an instance of a Meatball where these items of data are defined as keys e.g. `{ forename=Krishna, surname=Patel, age=31 }`. This library is also furnished with a large number of functions that are designed to be composed together to form up long functional streams through which instances of Meatball can pass through. 

One might choose to adopt this approach for several reasons. Firstly, since Meatball is a `Map<String, Object>`, one has the flexibility to dynamically add and remove key-value pairs. By contrast, a class in Object Oriented Programming is very rigid e.g. it is not possible to add or remove global variables dynamically to a class; this means that one may have to use complicated and convoluted solutions like MapStruct mappers and write a lot of additional boilerplate code. 

Secondly, since all objects in the application are instances of Meatball, all functions have extremely high reuse potential because they can be applied to any object instance in the system. In contrast, a method that was created in Object Oriented Programming might have limited scope to be used with its own global variables, or with a very specific class or subclasses.

Thirdly, functional code is easier to read and understand. This is because functions can be composed in a declarative style, such that a given functional stream resembles natural language. This is also because the structure of functional code tends to be much simpler e.g. inheritance hierarchies are typically not used.

Recall that Meatball is immutable; this also improves the understandability of the code because it's easier to reason about state. Being immutable also means that Meatball is thread-safe and therefore ideal for systems with a high degree of concurrency. Meatball is particularly suited to Reactive Programming, and was created with Project Reactor in mind.

## 2.0) Library

This library introduces a new data type called Meatball, as well as an expansive set of functions that can be applied to Meatball. Section 2.1 presents some noteworthy features of Meatball, and Section 2.2 briefly describes the functions that are available.  

### 2.1) Meatball

This library introduces one class called Meatball *(/src/main/java/map/DataStructures/Meatball.java)*. Meatball is a custom `Map<String, Object>` with several noteworthy properties. This section describes these properties.

#### 2.1.1) Immutability

The most important property of Meatball is immutability. This section describes how Meatball achieves immutability through defensive cloning.

Firstly, Meatball overrides methods that retrieve data from the map, so that it can clone the data before it is returned. For example, `public Object get( Object key );` clones the value associated with `key` before returning it. This ensures that state changes to the returned value do not alter the state of Meatball.

Secondly, Meatball overrides methods that perform state updates, so that it throws `UnsupportedOperationException` e.g. `public Object put( String key, Object value )`. This prevents the state of the Meatball being modified.

Lastly, Meatball exposes builder methods. A given builder method can be used to construct a new Meatball instance. This new Meatball instance is a version of the original Meatball, after some additional processing has been applied to it. To exemplify this, let us consider the `public Meatball enrich( String key, Object value )` method. `Meatball newMeatball = originalMeatball.enrich( "drink", "Tea" )` will construct a new Meatball instance called `newMeatball`, which has all the key-value pairs from the `originalMeatball` as well as an additional key called `drink` with the associated valued `Tea`. Note that this builder method preserves the state of the original Meatball, while still providing a means of obtaining a Meatball in the desired state after a `put` operation has been executed.  

#### 2.1.2) Nulls

The behaviour of Meatball when exposed to `null` keys and `null` values is nuanced. This section explains these nuanced behaviours.

Meatball does not store `null` keys. If one attempts to instantiate a Meatball with a key-value pair where the key is `null`, the Meatball will gracefully ignore the specific key-value pair.   

When an attempt is made to instantiate a new Meatball with a key-value pair where the value is `null`, the key is ignored by the builder. This gives rise to two distinct scenarios. In the first scenario, suppose that a given key is not defined in the original Meatball, and that one attempts to use a builder like `enrich` with this key and a `null` value. In this case, Meatball will gracefully ignore the specified key-value pair. In the second scenario, suppose that a given key is defined in the original Meatball, and that one attempts to use a builder like `enrich` with this key and a `null` value. In this case, the new Meatball will not contain the specified key.

If one attempts to retrieve the value for a key that does not exist, they will receive a `null` value.

#### 2.1.3) Supported Data Types

Meatball supports a narrow range of data types including all the primitives (e.g. `int`, `char`, `byte`), object variants of the primitives (e.g. `Integer`, `Character`, `Byte`), and `BigInteger` and `BigDecimal`. Meatball also supports data structures, including Lists, Sets, Maps, PriorityQueue and Arrays.

It's important to note that, Meatball only preserves the value of a BigDecimal, and does not preserve other attributes like precision and scale.

### 2.2) Functions

This library includes an expansive set of functions that are designed to operate on the Meatball (these functions are flexible enough to accommodate other types of maps). The core functions for the library are available in *(/src/main/java/map/functions/MapFn)* and *(/src/main/java/functions/Fn)*. Other functions, relating to primitives and collections are available in *(/src/main/java/map/functions/Primitives)* and *(/src/main/java/map/functions/Collections)* respectively.

    public static Function<Map<String, Object>, String> substring( String strKey, int beginIndex ) {
        return map -> ((String) map.get( strKey )).substring( beginIndex );
    }

Most functions in this library can be customised through currying. The substring method above is a concrete example of this. The substring method above takes two inputs, `strKey` and `beginIndex`. These inputs are used to define a function that takes a `Map<String, Object>` called `map` as input and returns a substring of the value associated with `strKey` that starts from `beginIndex`. For example, suppose that `map` contained this key value pair: `"date"="1992-05-01"`; `substring( "date", 8 ).apply( map )` would return `"01"`.

    Stream.of( 500 )
          .map( MapFn.toMeatballWith( "price" )
                     .andThen( put( "balance", balance ) )
                     .andThen( compute( "newBalance", subtract( "balance", "price", Integer.class ) ) )
                     .andThen( when( isGreaterThanOrEqualTo( "newBalance", 0, Integer.class ), 
                                     put( "hasSufficientFunds", true ), 
                                     put( "hasSufficientFunds", false ) ) )
                     .andThen( keep( "hasSufficientFunds" ) ) )
          .forEach( print );

The functions in this library can be composed into functional streams. Above is an example of a basic functional stream that can be created using functions from the library. This stream can be described as follows:
1. The first line defines a stream that contains one integer `500`. 
2. The second line constructs a new Meatball with one key called `price`, with `500` as it's associated value. At this point in the stream, `Meatball={ price=500 }`.
3. The third line constructs a new Meatball instance which contains all of the key-value pairs from the Meatball instance defined by the second line, as well as an additional key called `"balance"` which is associated with the value in the `balance` variable. For the purpose of the running example, let's suppose that balance is `400`. Thus, at this point in the stream, `Meatball={ price=500, balance=400 }`.
4. The fourth line constructs a new Meatball instance which contains all of the key-value pairs from the Meatball instance defined by the third line, as well as an additional key called `"newBalance"`. The value associated with `"newBalance"` is the result of subtracting the values associated with `"balance"` and `"price"` i.e. `"-100"`. Therefore, at this point in the stream,  `Meatball={ price=500, balance=400, newBalance=-100 }`.
5. The fifth line compares the value associated with `"newBalance"` against `0`; if the `"newBalance"` is greater than or equal to 0, then the sixth line is executed, otherwise the seventh line is executed. The sixth and seventh lines work in the same way as the third line. Since `newBalance < 0`, the seventh line will execute, and at this point in the stream, `Meatball={ price=500, balance=400, newBalance=-100, hasSufficientFunds=false }`.
6. The eighth line constructs a new Meatball instance which only contains one key-value pair (`"hasSufficientFunds=false"`) that was present in the Meatball instance that was constructed by the seventh line; thus at this point in the stream, `Meatball={ hasSufficientFunds=false }`.       
7. The final line prints out the Meatball i.e. `{ hasSufficientFunds=false }`

## 3.0 Recommendations

This section presents several development practices that I recommend, which can elevate the quality of the code that is written with this library.

Recall that Meatball is immutable. This means that one can effortlessly maximise the concurrency of their application to enhance its performance. Thus, I recommend using this library in conjunction with a complementary Reactive Programming library like Project Reactor.

Also recall that immutability is achieved by defensive cloning. This can add additional overhead. Even though this overhead is offset by the efficiency gains from greater concurrency, it is possible to optimise further. I recommend removing complex/large data from a Meatball as soon as it becomes redundant, because this would reduce the cloning costs. This library has a number of functions that enable one to effortlessly achieve this e.g. `keep` and `discard`.

It's also worth mentioning that most functions in the library support a variety of other `Map<String, Object>` subclasses, and has been also been thoroughly tested against `HashMap<String, Object>`. Thus, if further performance optimisations are required, one could swap Meatball for HashMap. Unfortunately, this would be at the cost of guaranteed thread-safety, and so one would have to be more mindful and diligent about how data is being processed across multiple threads.

The flexibility afforded by Pure Functional Programming comes at a cost; type safety is not as rigorously checked as in Object Oriented programming. This library has convenience functions for verifying types, which can be used to alleviate this e.g. Meatball has a method called `boolean classIs( String key, Class<T> clazz )`, which returns true if a value associated with the `key` is of type `clazz`. I recommend making strategic use of these convenience functions to obtain a greater level of confidence with respect to type safety. For example, verifying the data types in a HTTP request body that is received by an endpoint.

    public Function<Meatball, String> toInvitationEmail = meatball -> {
        final var inviteeEmailAddress = meatball.getString( "inviteeEmailAddress" );
        final var inviteeName = meatball.getString( "inviteeName" );
        final var inviterName = meatball.getString( "inviterName" );
        final var groupName = meatball.getString( "groupName" );
        
        final var subject = String.format( "%s has invited you to join %s!", inviterName, groupName );
        
        // ... remaining business logic ...
    };

The functions available in this library are general purpose. It may be necessary for the user to define their own domain specific functions. When defining these functions, I recommend extracting all of the data that is necessary for the function's business logic, before any of the business logic is defined. This enables one to understand the data requirements for the function at a glance, in a manner analogous to inspecting the parameters of a method. For example, the `toInvitationEmail` function above extracts all the data from Meatball that is required, before any of the business logic is defined; thus at a glance, one can surmise that this function requires Meatball to contain four strings: `inviteeEmailAddress`, `inviteeName`, `inviterName`, and `groupName`.  

Some functions might conditionally return a Meatball instance. For example the returned Meatball might be wrapped in an optional or in a Reactive stream that can become empty. In some of these cases, I recommend altering the function so that it defaults to returning an empty Meatball (either directly, or wrapped) e.g. `mono.switchIfEmpty( Mono.just( new Meatball() ) )`. This can significantly simplify the code in the caller, because the caller is guaranteed to receive a Meatball from the function.

Since all data is stored as key-value pairs in maps, this can make variable renaming refactorings challenging. To circumvent this issue, I recommend defining keys as static constants e.g. one might define `public static final String INVITEE_NAME = "inviteeName";` and retrieve the value like this: `meatball.getString( INVITEE_NAME )`. Changing the variable name of `INVITEE_NAME` and changing its value is trivial and will rename all usages across the system.

## 4.0 Acknowledgements

_MongoDB_ is a widely used open source NoSQL database (available at: https://www.mongodb.com). _Any_ is an open source library (available at: https://gitlab.com/dahaiuk/open/any), which was developed by _Richard Bourner_ and has been used in a commercial setting to develop three Minimum Viable Products. The Meatball library was inspired by _MongoDB_ and the _Any_ library. While the Meatball library shares some concepts with _MongoDB_ and the _Any_ library, the design and implementation of the Meatball library is substantially different and entirely my own. I am grateful for the inspiration provided by _MongoDB_ and the _Any_ library.

## 5.0 Licence

This library is released under the MIT licence: 

Copyright (c) 2024 Krishna Patel

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.